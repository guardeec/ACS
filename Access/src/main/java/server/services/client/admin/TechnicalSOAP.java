package server.services.client.admin;

import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.client.admin.DeviceDATA;
import server.postgress.admin.TechnicalDAO;
import server.postgress.admin.TechnicalImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Guardeec on 10.02.16.
 */
@WebService()
public class TechnicalSOAP {
  private final ApplicationContext appContext = new ClassPathXmlApplicationContext("server/JDBC_config.xml");
  private final TechnicalImpl DAO = (TechnicalDAO) appContext.getBean("TechnicalAdmin");
  private final Gson gson = new Gson();
  @WebMethod
  public Object technicalMethods(
          String targetAndCRUD,
          DeviceDATA deviceDATA
  ) {
    switch (targetAndCRUD){
      case "DEVICE_CREATE":{
        return DAO.addDevice(deviceDATA);
      }
      case "DEVICE_READ":{
        return gson.toJson(DAO.getDevice(deviceDATA));
      }
      case "DEVICE_UPDATE":{
        return DAO.changeDevice(deviceDATA);
      }
      case "DEVICE_DELETE":{
        return DAO.deleteDevice(deviceDATA);
      }
      default:{
        return null;
      }
    }
  }
}
