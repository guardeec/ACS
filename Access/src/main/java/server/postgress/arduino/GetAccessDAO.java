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
        public Object mapRow(ResultSet rs, int i) throws SQLException {
            GetAccessData getAccessData = new GetAccessData();

            getAccessData.setEmployeeId(rs.getInt("empl.id"));
            getAccessData.setEmployeeName(rs.getString("name"));
            getAccessData.setAccess(rs.getBoolean("access"));
            getAccessData.setSystemRoleId(rs.getInt("sys_r_id"));
            getAccessData.setType("employee");
            getAccessData.setMessage("Success");
            return getAccessData;
        }
    }

    private class RowMapperGuestGetAccess implements RowMapper {
        public Object mapRow(ResultSet rs, int i) throws SQLException {
            GetAccessData getAccessData = new GetAccessData();

            getAccessData.setEmployeeId(rs.getInt("id"));
            getAccessData.setEmployeeName(rs.getString("name"));
            getAccessData.setAccess(rs.getBoolean("access"));
            getAccessData.setSystemRoleId(1);
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
            userOrGuestId = getJdbcTemplate().queryForObject(
                "SELECT empl_id FROM empl_and_cards WHERE card_id = (SELECT cards.id FROM cards WHERE cards.number = ?);",
                new Object[]{getAccessData.getCardNumber()},
                    Integer.class
            );
            indefiniteUser = true;
        }catch (org.springframework.dao.EmptyResultDataAccessException ex){
            indefiniteUser = false;
        }catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            getAccessData = fail(getAccessData, "NO_CONNECTION");
            return getAccessData;
        }

        //Если не пользователь то проверка на гостя
        if (!indefiniteUser){
            try {
                userOrGuestId = getJdbcTemplate().queryForObject(
                        "SELECT guest_id FROM guests_and_cards WHERE card_id = (SELECT cards.id FROM cards WHERE cards.number = ?);",
                        new Object[]{getAccessData.getCardNumber()},
                        Integer.class
                );
                indefiniteGuest = true;
            } catch (org.springframework.dao.EmptyResultDataAccessException ex){
                indefiniteGuest = false;
            } catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
                getAccessData = fail(getAccessData, "NO_CONNECTION");
                return getAccessData;
            }
        }

        //если проверка на пользователя успешна
        if (indefiniteUser){
            try {
                getAccessData = (GetAccessData) getJdbcTemplate().queryForObject(
                        "SELECT empl.id, empl.name, acs_r.sys_r_id, acs_r.access FROM empl JOIN empl_st ON empl.st_id = empl_st.id JOIN empl_and_cards ON empl.id = empl_and_cards.empl_id JOIN cards ON cards.id = empl_and_cards.card_id JOIN empl_and_r ON empl.id = empl_and_r.empl_id JOIN sys_r ON empl_and_r.sys_r_id = sys_r.id JOIN acs_r ON sys_r.id = acs_r.sys_r_id WHERE empl_st.cond = TRUE AND device_id = ? AND cards.number = ?;",
                        new Object[]{getAccessData.getDeviceId(), getAccessData.getCardNumber()},
                        new RowMapperUserGetAccess()
                );
            }
            catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
                getAccessData = fail(getAccessData, "NO_CONNECTION");
            }
            catch (org.springframework.dao.EmptyResultDataAccessException ex ){
                getAccessData = fail(getAccessData, "BLOCKED");
            }
        }

        //если проверка на гостя успешна
        if (indefiniteGuest){
            try {
                getAccessData = (GetAccessData) getJdbcTemplate().queryForObject(
                        "SELECT guests.id, guests.name, acs_r.access FROM guests JOIN guests_and_cards ON guests.id = guests_and_cards.guest_id JOIN cards ON cards.id = guests_and_cards.card_id JOIN acs_r ON acs_r.sys_r_id = (SELECT id FROM sys_r WHERE title = 'guest') WHERE device_id = ? AND current_timestamp <= time_end AND cards.number = ?;",
                        new Object[]{getAccessData.getDeviceId(), getAccessData.getCardNumber()},
                        new RowMapperGuestGetAccess()
                );
            }
            catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
                getAccessData = fail(getAccessData, "NO_CONNECTION");
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
                getAccessData.setEmployeeId(0);
                getAccessData.setEmployeeName("DB_FAIL");
                getAccessData.setAccess(false);
                getAccessData.setType("FAIL");
                getAccessData.setMessage("FAIL");
                break;
            }
            case "BLOCKED": {
                getAccessData.setEmployeeId(0);
                getAccessData.setEmployeeName("BLOCKED");
                getAccessData.setAccess(false);
                getAccessData.setType("UNKNOWN");
                getAccessData.setMessage("Success");
                break;
            }
            case "TIME_END":{
                getAccessData.setEmployeeId(0);
                getAccessData.setEmployeeName("TIME_END");
                getAccessData.setAccess(false);
                getAccessData.setType("guest");
                getAccessData.setMessage("Success");
                break;
            }
            case "UNKNOWN":{
                getAccessData.setEmployeeId(0);
                getAccessData.setEmployeeName("UNKNOWN");
                getAccessData.setAccess(false);
                getAccessData.setType("UNKNOWN");
                getAccessData.setMessage("Success");
                break;
            }
        }
        return getAccessData;
    }
}
