package server.postgres.jdbc.client.admin;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.client.admin.RightDATA;

/**
 * Created by root on 08.10.15.
 */
public class RightDAO extends JdbcDaoSupport implements RightImpl {


    @Override
    public String log(RightDATA right) {
        try{
            getJdbcTemplate().update(
                    "INSERT INTO sec_dep_acs_r_events (event_id, device_id, device_spec, sys_r_id, sys_r_title, access) VALUES (?, ?, ?, ?, ?, ?);",
                    right.getGeneralEventTypeId(),
                    right.getDeviceId(),
                    right.getDeviceSpecification(),
                    right.getSystemRoleId(),
                    right.getSystemRoleTitle(),
                    right.getAccess());
            return "Success";
        }catch (CannotGetJdbcConnectionException ex){
            return "Error";
        }
    }
}
