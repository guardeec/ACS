package generator;

import soap.reception.GuestDATA;
import soap.reception.ReceptionSOAP;
import soap.reception.ReceptionSOAPService;
import soap.security.CardDATA;

import java.util.List;

/**
 * Created by Guardeec on 13.02.16.
 */
public class ReceptionMethods {

    public static GuestDATA addGuest(GuestDATA guestDATA){
        ReceptionSOAPService receptionSOAPService = new ReceptionSOAPService();
        ReceptionSOAP receptionSOAP = receptionSOAPService.getReceptionSOAPPort();

        guestDATA = (GuestDATA) receptionSOAP.receptionMethods("GUEST_CREATE", guestDATA);
        return guestDATA;
    }
    public static GuestDATA changeGuest(GuestDATA guestDATA){
        ReceptionSOAPService receptionSOAPService = new ReceptionSOAPService();
        ReceptionSOAP receptionSOAP = receptionSOAPService.getReceptionSOAPPort();

        guestDATA = (GuestDATA) receptionSOAP.receptionMethods("GUEST_UPDATE", guestDATA);
        return guestDATA;
    }
    public static GuestDATA deleteGuest(GuestDATA guestDATA){
        ReceptionSOAPService receptionSOAPService = new ReceptionSOAPService();
        ReceptionSOAP receptionSOAP = receptionSOAPService.getReceptionSOAPPort();

        guestDATA = (GuestDATA) receptionSOAP.receptionMethods("GUEST_DELETE", guestDATA);
        return guestDATA;
    }
    public static List<GuestDATA> getGuest(GuestDATA rightDATA){
        return null;
    }
    public static List<GuestDATA> getGuestHistory(GuestDATA rightDATA){
        return null;
    }

    public static List<CardDATA> getFreeCards(){
        return null;
    }

    public static void deleteExpiredCards(){
    }

}
