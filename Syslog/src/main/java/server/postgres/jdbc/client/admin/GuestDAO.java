package server.postgres.jdbc.client.admin;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.client.admin.GuestDATA;

import java.sql.Timestamp;

/**
 * Created by root on 08.10.15.
 */
public class GuestDAO extends JdbcDaoSupport implements GuestImpl {

    @Override
    public String log(GuestDATA guest) {
        try{
            getJdbcTemplate().update(
                    "INSERT INTO rec_dep_events (event_id, guest_id, guest_name, card_id, time_start, time_end) VALUES (?, ?, ?, ?, ?, ?);",
                    guest.getGeneralEventTypeId(),
                    guest.getGuestId(),
                    guest.getGuestName(),
                    guest.getCardId(),
                    new Timestamp(guest.getTimeStart()),
                    new Timestamp(guest.getTimeEnd()));
            return "Success";
        }catch (CannotGetJdbcConnectionException ex){
            return "Error";
        }
    }
}
