package server.postgres.jdbc.client.admin;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.client.admin.DeviceDATA;

/**
 * Created by root on 08.10.15.
 */
public class DeviceDAO extends JdbcDaoSupport implements DeviceImpl {

    @Override
    public String log(DeviceDATA device) {
        try{
            getJdbcTemplate().update(
                    "INSERT INTO tech_dep_events (event_id, device_id, device_ip, device_mac, device_spec, device_st_cond, device_st_descr)VALUES (?, ?, ?, ?, ?, ?, ?);",
                    device.getGeneralEventTypeId(),
                    device.getDeviceId(),
                    device.getDeviceIp(),
                    device.getDeviceMac(),
                    device.getDeviceSpecification(),
                    device.getDeviceCondition(),
                    device.getDeviceSecription());
            return "Success";
        }catch (CannotGetJdbcConnectionException ex){
            return "Error";
        }


    }
}
