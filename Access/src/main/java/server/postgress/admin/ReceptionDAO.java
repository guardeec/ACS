package server.postgress.admin;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pojo.client.admin.CardDATA;
import pojo.client.admin.GuestDATA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Guardeec on 08.02.16.
 */
public class ReceptionDAO extends JdbcDaoSupport implements ReceptionImpl {
    @Override
    public GuestDATA addGuest(GuestDATA guestDATA) {
        Integer id;
        try{
            id = getJdbcTemplate().queryForObject(
                    "INSERT INTO guests(name) VALUES(?) RETURNING id;",
                    new Object[]{guestDATA.getGuestName()},
                    Integer.class
            );
            getJdbcTemplate().update(
                    "INSERT INTO guests_and_cards VALUES (?,?);",
                    id, guestDATA.getCardId());
            guestDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            guestDATA.setGeneralDescription("FAIL");
        }
        return guestDATA;
    }

    @Override
    public GuestDATA changeGuest(GuestDATA guestDATA) {
        try {
            if (guestDATA.getGuestName()!=null){
                    getJdbcTemplate().update(
                            "UPDATE guests SET name = ? WHERE id = ?;",
                            guestDATA.getGuestName(), guestDATA.getGuestId());
            }
            if (guestDATA.getCardId() != null){
                    getJdbcTemplate().update(
                            "UPDATE guests_and_cards SET card_id = ?  WHERE  guest_id = ?;",
                            guestDATA.getCardId(), guestDATA.getGuestId());
            }
            guestDATA.setGeneralDescription("SUCCESS");
        } catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            guestDATA.setGeneralDescription("FAIL");
        }
        return guestDATA;
    }

    @Override
    public GuestDATA deleteGust(GuestDATA guestDATA) {
        try{
            getJdbcTemplate().update(
                    "DELETE FROM guests_and_cards WHERE guest_id = ?;",
                    guestDATA.getGuestId());
            guestDATA.setGeneralDescription("SUCCESS");
        }catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            guestDATA.setGeneralDescription("FAIL");
        }
        return guestDATA;
    }

    @Override
    public List<GuestDATA> getGuests(GuestDATA guestDATA) {
        List<GuestDATA> guestDATAList;
        try{
            guestDATAList = (List<GuestDATA>) getJdbcTemplate().queryForObject(
                    "SELECT guest_id, name, card_id, time_start, time_end, date FROM guests JOIN guests_and_cards ON guests.id = guests_and_cards.guest_id WHERE name = coalesce(?,name) AND date = coalesce(?, date) AND card_id = coalesce(?,card_id) AND current_date = date AND current_time <= time_end ORDER BY guest_id;",
                    new Object[]{guestDATA.getGuestName(), guestDATA.getGeneralDatetime(), guestDATA.getCardId()},
                    new SearchRowMapper()
            );
        }catch (org.springframework.dao.EmptyResultDataAccessException ex){
            guestDATAList = new LinkedList<>();
            guestDATAList.add(new GuestDATA());
        } catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            guestDATAList = null;
        }
        return guestDATAList;
    }

    @Override
    public List<GuestDATA> getGuestsHistory(GuestDATA guestDATA) {
        List<GuestDATA> guestDATAList;
        try{
            guestDATAList = (List<GuestDATA>) getJdbcTemplate().queryForObject(
                    "SELECT * FROM guests WHERE id NOT IN(SELECT guest_id FROM guests_and_cards) AND name = coalesce(?,name) AND date = coalesce(?, date) ORDER BY id;",
                    new Object[]{guestDATA.getGuestName(), guestDATA.getGeneralDatetime()},
                    new HistorySearchRowMapper()
            );
        }catch (org.springframework.dao.EmptyResultDataAccessException ex){
            guestDATAList = new LinkedList<>();
            guestDATAList.add(new GuestDATA());
        } catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            guestDATAList = null;
        }
        return guestDATAList;
    }

    @Override
    public List<CardDATA> getFreeCards() {
        List<CardDATA> cardDATAList;
        try{
            cardDATAList = (List<CardDATA>) getJdbcTemplate().queryForObject(
                    "SELECT id FROM cards WHERE id NOT IN (SELECT card_id FROM employees_and_cards) AND id NOT IN (SELECT card_id FROM guests_and_cards);",
                    new Object[]{},
                    new CardRowMapper()
            );
        }catch (org.springframework.dao.EmptyResultDataAccessException ex){
            cardDATAList = new LinkedList<>();
            cardDATAList.add(new CardDATA());
        } catch (org.springframework.jdbc.CannotGetJdbcConnectionException ex){
            cardDATAList = null;
        }
        return cardDATAList;
    }

    @Override
    public void deleteExpiredCards() {
        getJdbcTemplate().update("DELETE FROM guests_and_cards WHERE guest_id IN (SELECT id FROM guests JOIN guests_and_cards ON guests.id = guests_and_cards.guest_id WHERE date = current_date);");
    }

    private class SearchRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            List<GuestDATA> guestDATAList = new LinkedList<>();
            do {
                GuestDATA guestDATA = new GuestDATA();

                guestDATA.setGuestId(resultSet.getInt("guest_id"));
                guestDATA.setGuestName(resultSet.getString("name"));
                guestDATA.setCardId(resultSet.getInt("card_id"));
                guestDATA.setTimeStart(resultSet.getTime("time_start").getTime());
                guestDATA.setTimeEnd(resultSet.getTime("time_end").getTime());
                guestDATA.setGeneralDatetime(resultSet.getDate("date").getTime());

                guestDATAList.add(guestDATA);
            }while (resultSet.next());

            return guestDATAList;
        }
    }

    private class HistorySearchRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            List<GuestDATA> guestDATAList = new LinkedList<>();
            do {
                GuestDATA guestDATA = new GuestDATA();

                guestDATA.setGuestId(resultSet.getInt("id"));
                guestDATA.setGuestName(resultSet.getString("name"));
                guestDATA.setTimeStart(resultSet.getTime("time_start").getTime());
                guestDATA.setTimeEnd(resultSet.getTime("time_end").getTime());
                guestDATA.setGeneralDatetime(resultSet.getDate("date").getTime());

                guestDATAList.add(guestDATA);
            }while (resultSet.next());

            return guestDATAList;
        }
    }

    private class CardRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            ArrayList<Map> message = new ArrayList<>();

            do {
                Map<String, String> messageComponent = new HashMap<>();
                messageComponent.put("id", Integer.toString(resultSet.getInt("id")));
                message.add(messageComponent);
            }while (resultSet.next());

            Map<String, String> messageComponent = new HashMap<>();
            messageComponent.put("message", "Success getting guest free cards");
            message.add(messageComponent);

            return message;
        }
    }
}
