package server.postgress.admin;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.client.admin.CardDATA;
import pojo.client.admin.EmployeeDATA;
import pojo.client.admin.RoleDATA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Guardeec on 08.02.16.
 */
public class HRDAO extends JdbcDaoSupport implements HRImpl {
    @Override
    public EmployeeDATA addEmployee(EmployeeDATA employeeDATA) {

        try{
            Integer id = getJdbcTemplate().queryForObject(
                    "INSERT INTO employees(name,employee_status_id) VALUES (?, 1) RETURNING id;",
                    new Object[]{employeeDATA.getEmployeeName()},
                    Integer.class
            );
            employeeDATA.setEmployeeId(id);
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            employeeDATA.setEmployeeId(null);
            employeeDATA.setGeneralDescription("FAIL");
        }

        if (employeeDATA.getEmployeeId()!=null){
            try{
                getJdbcTemplate().update(
                        "INSERT INTO employees_and_cards VALUES (?,?);",
                        employeeDATA.getEmployeeId(), employeeDATA.getCardId());
                getJdbcTemplate().update(
                        "INSERT INTO employees_and_roles VALUES (?,?);",
                        employeeDATA.getEmployeeId(), employeeDATA.getSystemRoleId());
                employeeDATA.setGeneralDescription("SUCCESS");
            }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
                employeeDATA.setGeneralDescription("FAIL");
            }
        }

        return employeeDATA;
    }

    @Override
    public EmployeeDATA changeEmployee(EmployeeDATA employeeDATA) {
        try{
            if(employeeDATA.getEmployeeName() != null){
                getJdbcTemplate().update(
                        "UPDATE employees SET name = ? WHERE id = ?;",
                        employeeDATA.getEmployeeName(), employeeDATA.getEmployeeId());
            }
            if (employeeDATA.getSystemRoleId() != null){
                getJdbcTemplate().update(
                        "UPDATE employees_and_roles SET system_role_id = ? WHERE employee_id = ?;",
                        employeeDATA.getSystemRoleId(), employeeDATA.getEmployeeId());
            }
            employeeDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
                employeeDATA.setGeneralDescription("FAIL");
        }
        return employeeDATA;
    }

    @Override
    public EmployeeDATA deleteEmployee(EmployeeDATA employeeDATA) {
        try{
            getJdbcTemplate().update(
                    "DELETE FROM employees_and_cards WHERE employee_id = ?;",
                    employeeDATA.getEmployeeId());
            getJdbcTemplate().update(
                    "DELETE FROM employees_and_roles WHERE employee_id = ?;",
                    employeeDATA.getEmployeeId());
            getJdbcTemplate().update(
                    "DELETE FROM employees WHERE id = ?;",
                    employeeDATA.getEmployeeId());
            employeeDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            employeeDATA.setGeneralDescription("FAIL");
        }
        return employeeDATA;
    }

    @Override
    public List<EmployeeDATA> getEmployee(EmployeeDATA employeeDATA) {
        List<EmployeeDATA> employeeDATAList;
        try{
            employeeDATAList = (List<EmployeeDATA>) getJdbcTemplate().queryForObject(
                    "SELECT employee_id, name, system_role_id FROM employees JOIN employees_and_roles ON id = employee_id JOIN employee_status ON employee_status_id = employee_status.id WHERE employees.id = coalesce(?,employees.id) AND name = coalesce(?,name) AND system_role_id = coalesce(?, system_role_id) AND description = 'unblocked';",
                    new Object[]{employeeDATA.getEmployeeId(), employeeDATA.getEmployeeName(), employeeDATA.getSystemRoleId()},
                    new SearchRowMapper()
            );
        }catch (org.springframework.dao.EmptyResultDataAccessException | CannotGetJdbcConnectionException ignored){
            employeeDATAList = null;
        }
        return employeeDATAList;
    }

    @Override
    public List<CardDATA> getFreeCards() {
        List<CardDATA> cardDATAList;
        try{
            cardDATAList = (List<CardDATA>) getJdbcTemplate().queryForObject(
                    "SELECT id FROM cards WHERE id NOT IN (SELECT card_id FROM employees_and_cards) AND id NOT IN (SELECT card_id FROM guests_and_cards);",
                    new Object[]{},
                    new CardRowMapper()
            );
        }catch (org.springframework.dao.EmptyResultDataAccessException ex){
            cardDATAList = new LinkedList<>();
            cardDATAList.add(new CardDATA());
        } catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            cardDATAList = null;
        }
        return cardDATAList;
    }

    @Override
    public List<RoleDATA> getRoles() {
        List<RoleDATA> roleDATAList;
        try{
            roleDATAList = (List<RoleDATA>) getJdbcTemplate().queryForObject(
                    "SELECT * FROM system_roles WHERE id != 1;",
                    new Object[]{},
                    new RolesRowMapper()
            );
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            roleDATAList = null;
        }
        return roleDATAList;
    }

    private class SearchRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            List<EmployeeDATA> employeeDATAList = new LinkedList<>();

            do {
                EmployeeDATA employeeDATA = new EmployeeDATA();
                employeeDATA.setEmployeeId(resultSet.getInt("employee_id"));
                employeeDATA.setEmployeeName(resultSet.getString("name"));
                employeeDATA.setSystemRoleId(resultSet.getInt("system_role_id"));
                employeeDATAList.add(employeeDATA);
            }while (resultSet.next());

            return employeeDATAList;
        }
    }

    private class RolesRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            List<RoleDATA> roleDATAList = new LinkedList<>();

            do {
                RoleDATA roleDATA = new RoleDATA();
                roleDATA.setSystemRoleId(resultSet.getInt("id"));
                roleDATA.setSystemRoleTitle(resultSet.getString("title"));
                roleDATAList.add(roleDATA);
            }while (resultSet.next());

            return roleDATAList;
        }
    }

    private class CardRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            List<CardDATA> cardDATAList = new LinkedList<>();

            do {
                CardDATA cardDATA = new CardDATA();
                cardDATA.setCardId(resultSet.getInt("id"));
                cardDATAList.add(cardDATA);
            }while (resultSet.next());

            return cardDATAList;
        }
    }



}
