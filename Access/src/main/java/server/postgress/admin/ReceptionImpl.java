package server.postgress.admin;

import pojo.client.admin.CardDATA;
import pojo.client.admin.GuestDATA;

import java.util.List;

/**
 * Created by Guardeec on 08.02.16.
 */
public interface ReceptionImpl {
    public GuestDATA addGuest(GuestDATA guestDATA);
    public GuestDATA changeGuest(GuestDATA guestDATA);
    public GuestDATA deleteGust(GuestDATA guestDATA);
    public List<GuestDATA> getGuests(GuestDATA guestDATA);
    public List<GuestDATA> getGuestsHistory(GuestDATA guestDATA);

    public List<CardDATA> getFreeCards();

    public void deleteExpiredCards();
}
