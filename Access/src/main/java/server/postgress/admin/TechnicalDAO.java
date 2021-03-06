package server.postgress.admin;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.client.admin.DeviceDATA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Guardeec on 09.02.16.
 */
public class TechnicalDAO extends JdbcDaoSupport implements TechnicalImpl {
    @Override
    public DeviceDATA addDevice(DeviceDATA deviceDATA) {
        Integer id;
        try{
            id = getJdbcTemplate().queryForObject(
                    "INSERT INTO devices (spec, ip, mac) VALUES (?, ?, ?) RETURNING id;",
                    new Object[]{deviceDATA.getDeviceSpecification(), deviceDATA.getDeviceIp(), deviceDATA.getDeviceMac()},
                    Integer.class
            );
            deviceDATA.setDeviceId(id);
            deviceDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            deviceDATA.setGeneralDescription("FAIL");
        }
        return deviceDATA;
    }

    @Override
    public DeviceDATA changeDevice(DeviceDATA deviceDATA) {

        try{
            getJdbcTemplate().update(
                    "UPDATE devices SET spec = ?, ip = ?, mac = ? WHERE id = ?;",
                    deviceDATA.getDeviceSpecification(), deviceDATA.getDeviceIp(), deviceDATA.getDeviceMac(), deviceDATA.getDeviceId());
            deviceDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            deviceDATA.setGeneralDescription("FAIL");
        }
        return deviceDATA;
    }

    @Override
    public DeviceDATA deleteDevice(DeviceDATA deviceDATA) {
        try{
            getJdbcTemplate().update(
                    "DELETE FROM devices WHERE id = ?;",
                    deviceDATA.getDeviceId());
            deviceDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            deviceDATA.setGeneralDescription("FAIL");
        }
        return deviceDATA;
    }

    @Override
    public List<DeviceDATA> getDevice(DeviceDATA deviceDATA) {
        List<DeviceDATA> deviceDATAList;
        try{
            deviceDATAList = (List<DeviceDATA>) getJdbcTemplate().queryForObject(
                    "SELECT * FROM devices WHERE id = coalesce(?, id) AND ip = coalesce(?, ip) AND mac = coalesce(?, mac) AND spec = coalesce(?, spec) ORDER BY id;",
                    new Object[]{deviceDATA.getDeviceId(), deviceDATA.getDeviceIp(), deviceDATA.getDeviceSpecification(), deviceDATA.getDeviceSpecification()},
                    new SearchRowMapper()
            );
        }catch (org.springframework.dao.EmptyResultDataAccessException ex){
            deviceDATAList = new LinkedList<>();
            deviceDATAList.add(new DeviceDATA());
        }catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            deviceDATAList = null;
        }
        return deviceDATAList;
    }

    private class SearchRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            List<DeviceDATA> deviceDATAList = new LinkedList<>();

            do {
                DeviceDATA deviceDATA = new DeviceDATA();

                deviceDATA.setDeviceId(resultSet.getInt("id"));
                deviceDATA.setDeviceSpecification(resultSet.getString("spec"));
                deviceDATA.setDeviceIp(resultSet.getString("ip"));
                deviceDATA.setDeviceMac(resultSet.getString("mac"));

                deviceDATAList.add(deviceDATA);
            }while (resultSet.next());

            return deviceDATAList;
        }
    }
}
