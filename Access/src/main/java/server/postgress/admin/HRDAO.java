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
                    "INSERT INTO  empl(name) VALUES (?) RETURNING id;",
                    new Object[]{employeeDATA.getEmployeeName()},
                    Integer.class
            );
            employeeDATA.setEmployeeId(id);
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            employeeDATA.setEmployeeId(null);
            employeeDATA.setGeneralDescription("FAIL");
            return employeeDATA;
        }

        if (employeeDATA.getEmployeeId()!=null){
            try{
                getJdbcTemplate().update(
                        "INSERT INTO empl_and_cards VALUES (?,?);",
                        employeeDATA.getEmployeeId(), employeeDATA.getCardId());
                getJdbcTemplate().update(
                        "INSERT INTO empl_and_r VALUES (?,?);",
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
            if(employeeDATA.getEmployeeName() != null && employeeDATA.getEmployeeStateId()!=null){
                getJdbcTemplate().update(
                        "UPDATE empl SET name = ?, st_id = ? WHERE id = ?;",
                        employeeDATA.getEmployeeName(), employeeDATA.getEmployeeStateId(), employeeDATA.getEmployeeId());
            }
            if (employeeDATA.getSystemRoleId() != null){
                getJdbcTemplate().update(
                        "UPDATE empl_and_r SET sys_r_id = ? WHERE empl_id = 27;",
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
                    "SELECT empl.id, empl.name, empl_and_r.sys_r_id, empl_st.descr FROM empl JOIN empl_and_r ON empl.id = empl_id JOIN empl_st ON empl.st_id = empl_st.id WHERE empl.id = coalesce(?, empl.id) AND empl.name = coalesce(?, empl.name) AND sys_r_id = coalesce(?, sys_r_id) AND empl_st.cond = TRUE;",
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
                    "SELECT id FROM cards WHERE id NOT IN (SELECT card_id FROM empl_and_cards) AND id NOT IN (SELECT card_id FROM guests_and_cards);",
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
                    "SELECT * FROM sys_r WHERE sys_r.id != 1 ORDER BY id;",
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
                employeeDATA.setEmployeeId(resultSet.getInt("id"));
                employeeDATA.setEmployeeName(resultSet.getString("name"));
                employeeDATA.setSystemRoleId(resultSet.getInt("sys_r_id"));
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
                cardDATA.setCardId(resultSet.getInt("card_id"));
                cardDATAList.add(cardDATA);
            }while (resultSet.next());

            return cardDATAList;
        }
    }



}
