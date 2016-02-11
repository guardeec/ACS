package server.postgres.jdbc.client.arduino;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.client.arduino.GetAccessData;

/**
 * Created by root on 08.10.15.
 */
public class EnterOrOutTheRoomDAO extends JdbcDaoSupport implements EnterOtOutTheRoomImpl {


    @Override
    public String log(GetAccessData room) {
        try{
            getJdbcTemplate().update(
                    "INSERT INTO ard_rfid_events (event_id, user_id, user_name, sys_r_id, sys_r_title, card_id) VALUES (?, ?, ?, ?, ?, ?);",
                    room.getGeneralEventTypeId(),
                    room.getEmployeeId(),
                    room.getEmployeeName(),
                    room.getSystemRoleId(),
                    room.getSystemRoleTitle(),
                    room.getCardId());
            return "Success";
        }catch (CannotGetJdbcConnectionException ex){
            return "Error";
        }
    }
}
