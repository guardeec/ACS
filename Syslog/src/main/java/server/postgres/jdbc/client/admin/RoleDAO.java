package server.postgres.jdbc.client.admin;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.client.admin.RoleDATA;

/**
 * Created by root on 08.10.15.
 */
public class RoleDAO extends JdbcDaoSupport implements RoleImpl {


    @Override
    public String log(RoleDATA role) {
        try{
            getJdbcTemplate().update(
                    "INSERT INTO sec_dep_sys_r_events (event_id, sys_r_id, sys_r_title) VALUES (?, ?, ?);",
                    role.getGeneralEventTypeId(),
                    role.getSystemRoleId(),
                    role.getSystemRoleTitle());
            return "Success";
        }catch (CannotGetJdbcConnectionException ex){
            return "Error";
        }
    }
}
