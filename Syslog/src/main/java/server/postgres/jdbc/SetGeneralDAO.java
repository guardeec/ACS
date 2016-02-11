package server.postgres.jdbc;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.GeneralParams;
import java.sql.Timestamp;

/**
 * Created by root on 28.10.15.
 */
public class SetGeneralDAO extends JdbcDaoSupport implements SetGeneralImpl {

    @Override
    public Integer log(GeneralParams object) {

        Integer source_id;

        /*
        Ищем id источника по sourceParams
        Если не находим - добавляем новый и берём id нового источника
         */
        try{
            source_id = getJdbcTemplate().queryForObject(
                   "SELECT id AS source_id FROM event_sources WHERE type_id = coalesce(?, type_id) AND ip = coalesce(?, ip) AND mac = coalesce(?, mac) AND device_id = coalesce(?, device_id) AND cl_acc_id = coalesce(?, cl_acc_id) AND cl_acc_l = coalesce(?, cl_acc_l);",
                    new Object[]{
                            object.getSourceTypeId(),
                            object.getSourceIp(),
                            object.getSourceMac(),
                            object.getSourceDeviceId(),
                            object.getSourceClientAccountId(),
                            object.getSourceClientAccountLogin()
                    },
                    Integer.class
            );
        }catch (CannotGetJdbcConnectionException ex){
            return null;
        }catch (EmptyResultDataAccessException ex){
            try {
                source_id = getJdbcTemplate().queryForObject(
                        "INSERT INTO event_sources (type_id, ip, mac, device_id, cl_acc_id, cl_acc_l) VALUES (?, ?, ?, ?, ?, ?) RETURNING id AS source_id;",
                        new Object[]{
                                object.getSourceTypeId(),
                                object.getSourceIp(),
                                object.getSourceMac(),
                                object.getSourceDeviceId(),
                                object.getSourceClientAccountId(),
                                object.getSourceClientAccountLogin()
                        },
                        Integer.class
                );
            }catch (CannotGetJdbcConnectionException ex1){
                return null;
            }

        }

        /*
        Заносим общие параметры события
         */
        Integer eventId;
        try{
            eventId = getJdbcTemplate().queryForObject(
                    "INSERT INTO events (type_id, source_id, date_time, res_type, descr) VALUES (?, ?, ?, ?, ?) RETURNING id AS event_id;",
                    new Object[]{
                            object.getGeneralEventTypeId(),
                            source_id,
                            new Timestamp(object.getGeneralDatetime()),
                            object.getGeneralResultType(),
                            object.getGeneralDescription()
                    },
                    Integer.class
            );
        }catch (CannotGetJdbcConnectionException ex){
            return null;
        }

        return eventId;
    }
}
