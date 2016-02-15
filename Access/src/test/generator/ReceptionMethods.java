package generator;

import com.google.gson.Gson;
import soap.SoapURL;
import soap.reception.*;

import java.net.URL;
import java.util.List;

/**
 * Created by Guardeec on 13.02.16.
 */
public class ReceptionMethods {

    private static final URL URL = SoapURL.getInstance().RECEPTION_URL();

    public static GuestDATA addGuest(GuestDATA guestDATA){
        ReceptionSOAPService receptionSOAPService = new ReceptionSOAPService(URL);
        ReceptionSOAP receptionSOAP = receptionSOAPService.getReceptionSOAPPort();

        guestDATA = (GuestDATA) receptionSOAP.receptionMethods("GUEST_CREATE", guestDATA, null);
        return guestDATA;
    }
    public static GuestDATA changeGuest(GuestDATA guestDATA){
        ReceptionSOAPService receptionSOAPService = new ReceptionSOAPService(URL);
        ReceptionSOAP receptionSOAP = receptionSOAPService.getReceptionSOAPPort();

        guestDATA = (GuestDATA) receptionSOAP.receptionMethods("GUEST_UPDATE", guestDATA, null);
        return guestDATA;
    }
    public static GuestDATA deleteGuest(GuestDATA guestDATA){
        ReceptionSOAPService receptionSOAPService = new ReceptionSOAPService(URL);
        ReceptionSOAP receptionSOAP = receptionSOAPService.getReceptionSOAPPort();

        guestDATA = (GuestDATA) receptionSOAP.receptionMethods("GUEST_DELETE", guestDATA, null);
        return guestDATA;
    }
    public static List<GuestDATA> getGuest(GuestDATA guestDATA){
        ReceptionSOAPService receptionSOAPService = new ReceptionSOAPService(URL);
        ReceptionSOAP receptionSOAP = receptionSOAPService.getReceptionSOAPPort();

        String json = (String) receptionSOAP.receptionMethods("GUEST_READ", guestDATA, null);
        Gson gson = new Gson();
        return gson.fromJson(json, List.class);
    }
    public static List<GuestDATA> getGuestHistory(GuestDATA guestDATA){
        ReceptionSOAPService receptionSOAPService = new ReceptionSOAPService(URL);
        ReceptionSOAP receptionSOAP = receptionSOAPService.getReceptionSOAPPort();

        String json = (String) receptionSOAP.receptionMethods("HISTORY_READ_HISTORY", guestDATA, null);
        Gson gson = new Gson();
        return gson.fromJson(json, List.class);
    }

    public static List<CardDATA> getFreeCards(CardDATA cardDATA){
        ReceptionSOAPService receptionSOAPService = new ReceptionSOAPService(URL);
        ReceptionSOAP receptionSOAP = receptionSOAPService.getReceptionSOAPPort();

        String json = (String) receptionSOAP.receptionMethods("CARD_READ", null, cardDATA);
        Gson gson = new Gson();
        return gson.fromJson(json, List.class);
    }

    public static void deleteExpiredCards(){
        ReceptionSOAPService receptionSOAPService = new ReceptionSOAPService(URL);
        ReceptionSOAP receptionSOAP = receptionSOAPService.getReceptionSOAPPort();
        receptionSOAP.receptionMethods("EXPIRED_CARDS_DELETE", null, null);
    }

}
