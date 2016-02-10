package server.postgress.admin;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.client.admin.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Guardeec on 09.02.16.
 */
public class SecurityDAO extends JdbcDaoSupport implements SecurityImpl {
    @Override
    public AccountDATA addAccount(AccountDATA accountDATA) {
        try{
            Integer account_id = getJdbcTemplate().queryForObject(
                    "INSERT INTO accounts(login,password,employee_id) VALUES (?,?,?) RETURNING id;",
                    new Object[]{accountDATA.getClientAccountLogin(), accountDATA.getPassword(), accountDATA.getEmployeeId()},
                    Integer.class
            );
            accountDATA.setClientAccountId(account_id);
            if (accountDATA.getAccessRights().compareTo("TECHNICAL")==0){
                getJdbcTemplate().update(
                        "INSERT INTO accounts_and_roles VALUES (?,4);",
                        accountDATA.getClientAccountId());
            }

            if (accountDATA.getAccessRights().compareTo("RECEPTION")==0){
                getJdbcTemplate().update(
                        "INSERT INTO accounts_and_roles VALUES (?,2);",
                        accountDATA.getClientAccountId());
            }

            if (accountDATA.getAccessRights().compareTo("HR")==0){
                getJdbcTemplate().update(
                        "INSERT INTO accounts_and_roles VALUES (?,1);",
                        accountDATA.getClientAccountId());
            }

            if (accountDATA.getAccessRights().compareTo("SECURITY")==0){
                getJdbcTemplate().update(
                        "INSERT INTO accounts_and_roles VALUES (?,3);",
                        accountDATA.getClientAccountId());
            }
            accountDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            accountDATA.setGeneralDescription("FAIL");
        }
        return accountDATA;
    }

    @Override
    public AccountDATA changeAccount(AccountDATA accountDATA) {
        try{
            if (accountDATA.getClientAccountLogin()!=null){
                getJdbcTemplate().update(
                        "UPDATE accounts SET login = ? WHERE id = coalesce(?, id);",
                        accountDATA.getClientAccountLogin(), accountDATA.getClientAccountId());
            }
            if (accountDATA.getPassword()!=null){
                getJdbcTemplate().update(
                        "UPDATE accounts SET password = ? WHERE id = coalesce(?, id);",
                        accountDATA.getPassword(), accountDATA.getClientAccountId());
            }






            if (accountDATA.getAccessRights().contains("TECHNICAL")){
                getJdbcTemplate().update(
                        "DELETE FROM accounts_and_roles WHERE db_role_id = 4 AND  account_id = ?;",
                        accountDATA.getClientAccountId());
                getJdbcTemplate().update(
                        "INSERT INTO accounts_and_roles VALUES (?,4);",
                        accountDATA.getClientAccountId());
            }else {
                getJdbcTemplate().update(
                        "DELETE FROM accounts_and_roles WHERE db_role_id = 4 AND  account_id = ?;",
                        accountDATA.getClientAccountId());
            }





            if (accountDATA.getAccessRights().contains("RECEPTION")){
                getJdbcTemplate().update(
                        "DELETE FROM accounts_and_roles WHERE db_role_id = 2 AND account_id = ?;",
                        accountDATA.getClientAccountId());
                getJdbcTemplate().update(
                        "INSERT INTO accounts_and_roles VALUES (?,2);",
                        accountDATA.getClientAccountId());
            }else {
                getJdbcTemplate().update(
                        "DELETE FROM accounts_and_roles WHERE db_role_id = 2 AND account_id = ?;",
                        accountDATA.getClientAccountId());
            }




            if (accountDATA.getAccessRights().contains("HR")){
                getJdbcTemplate().update(
                        "DELETE FROM accounts_and_roles WHERE db_role_id = 1 AND account_id = ?;",
                        accountDATA.getClientAccountId());
                getJdbcTemplate().update(
                        "INSERT INTO accounts_and_roles VALUES (?,1);",
                        accountDATA.getClientAccountId());
            }else {
                getJdbcTemplate().update(
                        "DELETE FROM accounts_and_roles WHERE db_role_id = 1 AND account_id = ?;",
                        accountDATA.getClientAccountId());
            }




            if (accountDATA.getAccessRights().contains("SECURITY")){
                getJdbcTemplate().update(
                        "DELETE FROM accounts_and_roles WHERE db_role_id = 3 AND  account_id = ?;",
                        accountDATA.getClientAccountId());
                getJdbcTemplate().update(
                        "INSERT INTO accounts_and_roles VALUES (?,3);",
                        accountDATA.getClientAccountId());
            }else {
                getJdbcTemplate().update(
                        "DELETE FROM accounts_and_roles WHERE db_role_id = 3 AND  account_id = ?;",
                        accountDATA.getClientAccountId());
            }
            accountDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            accountDATA.setGeneralDescription("FAIL");
        }
        return accountDATA;
    }

    @Override
    public AccountDATA deleteAccount(AccountDATA accountDATA) {
        try{
            getJdbcTemplate().update(
                    "DELETE FROM accounts WHERE id = ?;",
                    accountDATA.getClientAccountId());
            accountDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            accountDATA.setGeneralDescription("FAIL");
        }
        return accountDATA;
    }

    @Override
    public List<AccountDATA> getAccount(AccountDATA accountDATA) {
        List<AccountDATA> accountDATAList;
        try{
            accountDATAList = (List<AccountDATA>) getJdbcTemplate().queryForObject(
                    "SELECT accounts.id, accounts.employee_id, accounts.login,db_roles.title FROM accounts JOIN accounts_and_roles ON accounts.id = accounts_and_roles.account_id JOIN db_roles ON accounts_and_roles.db_role_id = db_roles.id WHERE accounts.id =coalesce(?, accounts.id) AND   login = coalesce(?, login) AND  employee_id = coalesce(?, employee_id);",
                    new Object[]{accountDATA.getClientAccountId(), accountDATA.getClientAccountLogin(), accountDATA.getEmployeeId()},
                    new AccountSearchRowMapper()
            );
        }catch (org.springframework.dao.EmptyResultDataAccessException ex){
            accountDATAList = new LinkedList<>();
            accountDATAList.add(new AccountDATA());
        }
        catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            accountDATAList = null;
        }
        return accountDATAList;
    }

    private class AccountSearchRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            List<AccountDATA> accountDATAList = new LinkedList<>();
            do {
                AccountDATA accountDATA = new AccountDATA();

                accountDATA.setClientAccountId(resultSet.getInt("id"));
                accountDATA.setClientAccountLogin(resultSet.getString("login"));
                accountDATA.setEmployeeId(resultSet.getInt("employee_id"));

                String title = resultSet.getString("title");
                String accessRights = "";
                if (title.contains("hr")) {
                    accessRights += "HR ";
                }
                if (title.contains("reception")) {
                    accessRights += "RECEPTION ";
                }
                if (title.contains("technical")) {
                    accessRights += "TECHNICAL ";
                }
                if (title.contains("security")) {
                    accessRights += "SECURITY ";
                }
                accountDATA.setAccessRights(accessRights);
            } while (resultSet.next());
            return accountDATAList;
        }
    }















    @Override
    public CardDATA addCard(CardDATA cardDATA) {
        try{
            Integer id = getJdbcTemplate().queryForObject(
                    "INSERT INTO cards(number) VALUES (?) RETURNING id;",
                    new Object[]{cardDATA.getCardNumber()},
                    Integer.class
            );
            cardDATA.setCardId(id);
            cardDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            cardDATA.setGeneralDescription("FAIL");
        }
        return cardDATA;
    }

    @Override
    public CardDATA deleteCard(CardDATA cardDATA) {
        try{
            getJdbcTemplate().update(
                    "DELETE FROM cards WHERE id = ?;",
                    cardDATA.getCardId());
            cardDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            cardDATA.setGeneralDescription("FAIL");
        }
        return cardDATA;
    }

    @Override
    public List<CardDATA> getCard(CardDATA cardDATA) {
        List<CardDATA> cardDATAList;
        try{
            cardDATAList = (List<CardDATA>) getJdbcTemplate().queryForObject(
                    "SELECT id FROM cards WHERE id NOT IN (SELECT card_id FROM employees_and_cards) AND id NOT IN (SELECT card_id FROM guests_and_cards);",
                    new Object[]{},
                    new CardSearchRowMapper()
            );
        }catch (org.springframework.dao.EmptyResultDataAccessException ex){
            cardDATAList = new LinkedList<>();
            cardDATAList.add(new CardDATA());
        }catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            cardDATAList = null;
        }
        return cardDATAList;
    }

    private class CardSearchRowMapper implements RowMapper {
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









    @Override
    public List<DeviceDATA> getDevice(DeviceDATA deviceDATA) {
        List<DeviceDATA> deviceDATAList;
        try{
            deviceDATAList = (List<DeviceDATA>) getJdbcTemplate().queryForObject(
                    "SELECT * FROM devices WHERE id = coalesce(?,id) AND ip = coalesce(?,ip) AND specification = coalesce(?,specification) ORDER BY id;",
                    new Object[]{deviceDATA.getDeviceId(), deviceDATA.getDeviceIp(), deviceDATA.getDeviceSpecification()},
                    new DeviceSearchRowMapper()
            );
        }catch (org.springframework.dao.EmptyResultDataAccessException ex){
            deviceDATAList = new LinkedList<>();
            deviceDATAList.add(new DeviceDATA());
        } catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            deviceDATAList = null;
        }
        return deviceDATAList;
    }

    private class DeviceSearchRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            List<DeviceDATA> deviceDATAList = new LinkedList<>();
            do {
                DeviceDATA deviceDATA = new DeviceDATA();

                deviceDATA.setDeviceId(resultSet.getInt("id"));
                deviceDATA.setDeviceSpecification(resultSet.getString("specification"));
                deviceDATA.setDeviceIp(resultSet.getString("ip"));

                deviceDATAList.add(deviceDATA);
            }while (resultSet.next());

            return deviceDATAList;
        }
    }








    @Override
    public RightDATA changeRigth(RightDATA rightDATA) {
        try{
            getJdbcTemplate().update(
                    "UPDATE access_rights SET access = ? WHERE system_role_id = ? AND device_id = ?;",
                    rightDATA.getAccess(), rightDATA.getSystemRoleId(), rightDATA.getDeviceId());
            rightDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            rightDATA.setGeneralDescription("FAIL");
        }
        return rightDATA;
    }

    @Override
    public List<RightDATA> getRights(RightDATA rightDATA) {
        List<RightDATA> rightDATAList;
        try{
            rightDATAList = (List<RightDATA>) getJdbcTemplate().queryForObject(
                    "SELECT * FROM access_rights WHERE system_role_id = coalesce(?, system_role_id) AND device_id = coalesce(?, device_id) AND access = coalesce(NULL, access);",
                    new Object[]{rightDATA.getSystemRoleId(), rightDATA.getDeviceId()},
                    new RigthSearchRowMapper()
            );
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            rightDATAList = null;
        }
        return rightDATAList;
    }

    private class RigthSearchRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            List<RightDATA> rightDATAList = new LinkedList<>();
            do {
                RightDATA rightDATA = new RightDATA();
                rightDATA.setSystemRoleId(resultSet.getInt("system_role_id"));
                rightDATA.setDeviceId(resultSet.getInt("device_id"));
                rightDATA.setAccess(resultSet.getBoolean("access"));
                rightDATAList.add(rightDATA);
            }while (resultSet.next());
            return rightDATAList;
        }
    }







    @Override
    public RoleDATA addRole(RoleDATA roleDATA) {
        try{
            Integer id = getJdbcTemplate().queryForObject(
                    "INSERT INTO system_roles(title) VALUES (?) RETURNING id;",
                    new Object[]{roleDATA.getSystemRoleTitle()},
                    Integer.class
            );
            roleDATA.setSystemRoleId(id);
            roleDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            roleDATA.setGeneralDescription("FAIL");
        }
        return roleDATA;
    }

    @Override
    public RoleDATA changeRole(RoleDATA roleDATA) {
        try{
            getJdbcTemplate().update(
                    "UPDATE system_roles SET title = ? WHERE id = ?;",
                    roleDATA.getSystemRoleTitle(), roleDATA.getSystemRoleId());
            roleDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            roleDATA.setGeneralDescription("FAIL");
        }
        return roleDATA;
    }

    @Override
    public RoleDATA deleteRole(RoleDATA roleDATA) {
        try{
            getJdbcTemplate().update(
                    "DELETE FROM system_roles WHERE id = ?;",
                    roleDATA.getSystemRoleId());
            roleDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            roleDATA.setGeneralDescription("FAIL");
        }
        return roleDATA;
    }

    @Override
    public List<RoleDATA> getRoles(RoleDATA roleDATA) {
        List<RoleDATA> roleDATAList;
        try{
            roleDATAList = (List<RoleDATA>) getJdbcTemplate().queryForObject(
                    "SELECT * FROM system_roles WHERE id = coalesce(?, id) AND title = coalesce(?, title);",
                    new Object[]{roleDATA.getSystemRoleId(), roleDATA.getSystemRoleTitle()},
                    new RoleSearchRowMapper()
            );
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            roleDATAList = new LinkedList<>();
            roleDATAList.add(new RoleDATA());
        }
        return roleDATAList;
    }

    private class RoleSearchRowMapper implements RowMapper {
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
}
