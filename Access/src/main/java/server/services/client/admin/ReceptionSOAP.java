package server.services.client.admin;
import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.client.admin.GuestDATA;
import server.postgress.admin.ReceptionDAO;
import server.postgress.admin.ReceptionImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Guardeec on 08.02.16.
 */
@WebService()
public class ReceptionSOAP {
  private final ApplicationContext appContext = new ClassPathXmlApplicationContext("server/JDBC_config.xml");
  private final ReceptionImpl DAO = (ReceptionDAO) appContext.getBean("ReceptionAdmin");
  private final Gson gson = new Gson();
  @WebMethod
  public Object receptionMethods(
          String targetAndCrud,
          GuestDATA guestDATA
  ) {
    switch (targetAndCrud){
      case "GUEST_CREATE":{
        return DAO.addGuest(guestDATA);
      }
      case "GUEST_READ":{
        return gson.toJson(DAO.getGuests(guestDATA));
      }
      case "GUEST_READ_HISTORY":{
        return DAO.getGuestsHistory(guestDATA);
      }
      case "GUEST_UPDATE":{
        return DAO.changeGuest(guestDATA);
      }
      case "GUEST_DELETE":{
        return DAO.deleteGust(guestDATA);
      }
      case "CARD_READ":{
        return gson.toJson(DAO.getFreeCards());
      }
      case "EXPIRED_CARDS_DELETE":{
        DAO.deleteExpiredCards();
        return true;
      }
      default:{
        return null;
      }
    }
  }
}
