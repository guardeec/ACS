package server.postgress.arduino;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.client.arduino.GetAccessData;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by guardeec on 20.05.15.
 */
public class GetAccessDAO extends JdbcDaoSupport implements GetAccessImpl {

    private class RowMapperUserGetAccess implements RowMapper {
        public Object mapRow(ResultSet rs, int i) throws SQLException, SQLException {
            GetAccessData getAccessData = new GetAccessData();

            getAccessData.setId(rs.getInt("id"));
            getAccessData.setName(rs.getString("name"));
            getAccessData.setAccess(rs.getBoolean("access"));
            getAccessData.setType("user");
            getAccessData.setMessage("Success");
            return getAccessData;
        }
    }

    private class RowMapperGuestGetAccess implements RowMapper {
        public Object mapRow(ResultSet rs, int i) throws SQLException, SQLException {
            GetAccessData getAccessData = new GetAccessData();

            getAccessData.setId(rs.getInt("id"));
            getAccessData.setName(rs.getString("name"));
            getAccessData.setAccess(rs.getBoolean("access"));
            getAccessData.setType("guest");
            getAccessData.setMessage("Success");

            return getAccessData;
        }
    }


    public GetAccessData Get(GetAccessData getAccessData) {

        Boolean indefiniteUser;
        Boolean indefiniteGuest = false;
        Integer userOrGuestId = null;

        //Проверка пользователь ли это
        try{
            userOrGuestId = (Integer) getJdbcTemplate().queryForObject(
                "SELECT employee_id FROM employees_and_cards WHERE card_id = (SELECT cards.id FROM cards WHERE cards.number = ?);",
                new Object[]{getAccessData.getCard()},
                    Integer.class
            );
            indefiniteUser = true;
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            indefiniteUser = false;
        }

        //Если не пользователь то проверка на гостя
        if (!indefiniteUser){
            try {
                userOrGuestId = (Integer) getJdbcTemplate().queryForObject(
                        "SELECT guest_id FROM guests_and_cards WHERE card_id = (SELECT cards.id FROM cards WHERE cards.number = ?);",
                        new Object[]{getAccessData.getCard()},
                        Integer.class
                );
                indefiniteGuest = true;
            }
            catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
                indefiniteGuest = false;
            }
        }

        //если проверка на пользователя успешна
        if (indefiniteUser){
            try {
                getAccessData = (GetAccessData) getJdbcTemplate().queryForObject(
                        "SELECT employees.id, employees.name, access_rights.system_role_id, access_rights.access FROM employees JOIN employees_and_cards ON employees.id = employees_and_cards.employee_id JOIN cards ON cards.id = employees_and_cards.card_id JOIN employees_and_roles ON employees.id = employees_and_roles.employee_id JOIN system_roles ON employees_and_roles.system_role_id = system_roles.id JOIN access_rights ON system_roles.id = access_rights.system_role_id WHERE employee_status_id = 1 AND device_id = ? AND cards.number = ?;",
                        new Object[]{userOrGuestId, getAccessData.getCard()},
                        new RowMapperUserGetAccess()
                );
            }
            catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
                getAccessData = fail(getAccessData, "DB_FAIL");
            }
            catch (org.springframework.dao.EmptyResultDataAccessException ex ){
                getAccessData = fail(getAccessData, "BLOCKED");
            }
        }

        //если проверка на гостя успешна
        if (indefiniteGuest){
            try {
                getAccessData = (GetAccessData) getJdbcTemplate().queryForObject(
                        "SELECT guests.id, guests.name, access_rights.access FROM guests JOIN guests_and_cards ON guests.id = guests_and_cards.guest_id JOIN cards ON cards.id = guests_and_cards.card_id JOIN access_rights ON access_rights.system_role_id = (SELECT id FROM system_roles WHERE title = 'guest') WHERE device_id = ? AND current_time <= time_end AND cards.number = ?;",
                        new Object[]{getAccessData.getDeviceId(), getAccessData.getCard()},
                        new RowMapperGuestGetAccess()
                );
            }
            catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
                getAccessData = fail(getAccessData, "DB_FAIL");
            }
            catch (org.springframework.dao.EmptyResultDataAccessException ex){
                getAccessData = fail(getAccessData, "TIME_END");
            }
        }

        if (!indefiniteUser && !indefiniteGuest){
            getAccessData = fail(getAccessData, "UNKNOWN");
        }

        return getAccessData;
    }

    private GetAccessData fail(GetAccessData getAccessData, String failType){
        switch (failType){
            case "NO_CONNECTION": {
                getAccessData.setId(null);
                getAccessData.setName("DB_FAIL");
                getAccessData.setAccess(false);
                getAccessData.setType(null);
                getAccessData.setMessage("FAIL");
                break;
            }
            case "BLOCKED": {
                getAccessData.setId(null);
                getAccessData.setName("BLOCKED");
                getAccessData.setAccess(false);
                getAccessData.setType("UNKNOWN");
                getAccessData.setMessage("Success");
                break;
            }
            case "TIME_END":{
                getAccessData.setId(null);
                getAccessData.setName("TIME_END");
                getAccessData.setAccess(false);
                getAccessData.setType("guest");
                getAccessData.setMessage("Success");
                break;
            }
            case "UNKNOWN":{
                getAccessData.setId(null);
                getAccessData.setName("UNKNOWN");
                getAccessData.setAccess(false);
                getAccessData.setType("UNKNOWN");
                getAccessData.setMessage("Success");
                break;
            }
        }
        return getAccessData;
    }
}
