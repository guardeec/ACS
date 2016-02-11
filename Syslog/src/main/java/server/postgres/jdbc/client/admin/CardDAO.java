package server.postgres.jdbc.client.admin;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.client.admin.CardDATA;

/**
 * Created by root on 08.10.15.
 */
public class CardDAO extends JdbcDaoSupport implements CardImpl {

    @Override
    public String log(CardDATA card) {
        try{
            getJdbcTemplate().update(
                    "INSERT INTO sec_dep_cards_events (event_id, card_id) VALUES (?, ?);",
                    card.getGeneralEventTypeId(),
                    card.getCardId());
            return "Success";
        }catch (CannotGetJdbcConnectionException ex){
            return "Error";
        }
    }
}
