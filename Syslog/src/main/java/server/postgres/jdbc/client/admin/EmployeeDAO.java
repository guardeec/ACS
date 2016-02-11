package server.postgres.jdbc.client.admin;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.client.admin.EmployeeDATA;

/**
 * Created by root on 08.10.15.
 */
public class EmployeeDAO extends JdbcDaoSupport implements EmplyeeImpl {

    public String log(EmployeeDATA object) {
        //HR DEPARTMENT EVENTS
        try{
            getJdbcTemplate().update(
                    "INSERT INTO hr_dep_events (event_id, empl_id, empl_name, empl_st_id, empl_st_descr, sys_r_id, sys_r_title, card_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);",

                    object.getGeneralEventTypeId(),
                    object.getEmployeeId(),
                    object.getEmployeeName(),
                    object.getEmployeeStateId(),
                    object.getEmployeeStateDescription(),
                    object.getSystemRoleId(),
                    object.getSystemRoleTitle(),
                    object.getCardId());
            return "Success";
        }catch (CannotGetJdbcConnectionException ex){
            return "Error";
        }
    }
}
