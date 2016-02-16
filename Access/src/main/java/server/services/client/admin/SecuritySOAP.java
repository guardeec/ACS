package server.services.client.admin;
import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.client.admin.*;
import server.postgress.admin.SecurityDAO;
import server.postgress.admin.SecurityImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Guardeec on 10.02.16.
 */
@WebService()
public class SecuritySOAP {
  private final ApplicationContext appContext = new ClassPathXmlApplicationContext("server/JDBC_config.xml");
  private final SecurityImpl DAO = (SecurityDAO) appContext.getBean("SecurityAdmin");
  private final Gson gson = new Gson();
  @WebMethod
  public Object securityMethods(
          String targetAndCRUD,
          AccountDATA accountDATA,
          CardDATA cardDATA,
          DeviceDATA deviceDATA,
          RightDATA rightDATA,
          RoleDATA roleDATA
  ) {
    switch (targetAndCRUD){

      case "ACCOUNT_CREATE" :{
        return DAO.addAccount(accountDATA);
      }
      case "ACCOUNT_READ":{
        return gson.toJson(DAO.getAccount(accountDATA));
      }
      case "ACCOUNT_UPDATE":{
        return DAO.changeAccount(accountDATA);
      }
      case "ACCOUNT_DELETE":{
        return DAO.deleteAccount(accountDATA);
      }

      case "CARD_CREATE":{
        return DAO.addCard(cardDATA);
      }
      case "CARD_READ":{
        return gson.toJson(DAO.getCard(cardDATA));
      }
      case "CARD_DELETE":{
        return DAO.deleteCard(cardDATA);
      }

      case "DEVICE_READ":{
        return gson.toJson(DAO.getDevice(deviceDATA));
      }

      case "RIGHT_READ":{
        return gson.toJson(DAO.getRights(rightDATA));
      }
      case "RIGHT_UPDATE":{
        return DAO.changeRigth(rightDATA);
      }

      case "ROLE_CREATE":{
        return DAO.addRole(roleDATA);
      }
      case "ROLE_READ":{
        return gson.toJson(DAO.getRoles(roleDATA));
      }
      case "ROLE_UPDATE":{
        return DAO.changeRole(roleDATA);
      }
      case "ROLE_DELETE":{
        return DAO.deleteRole(roleDATA);
      }

      default:{
        return null;
      }
    }
  }
}
