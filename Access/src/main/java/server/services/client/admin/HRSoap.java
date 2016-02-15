package server.services.client.admin;
import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.client.admin.CardDATA;
import pojo.client.admin.EmployeeDATA;
import pojo.client.admin.RoleDATA;
import server.postgress.admin.HRDAO;
import server.postgress.admin.HRImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Guardeec on 08.02.16.
 */
@WebService()
public class HRSOAP {
  private final ApplicationContext appContext = new ClassPathXmlApplicationContext("server/JDBC_config.xml");
  private final HRImpl DAO = (HRDAO) appContext.getBean("HRAdmin");
  private  final Gson gson = new Gson();
  @WebMethod
  public Object HRMethods(
          String targetAndCrud,
          EmployeeDATA employeeDATA,
          CardDATA cardDATA,
          RoleDATA roleDATA
  ) {
    switch (targetAndCrud){
      case "EMPLOYEE_CREATE":{
        return DAO.addEmployee(employeeDATA);
      }
      case "EMPLOYEE_READ":{
        return gson.toJson(DAO.getEmployee(employeeDATA));
      }
      case "EMPLOYEE_UPDATE":{
        return DAO.changeEmployee(employeeDATA);
      }
      case "EMPLOYEE_DELETE":{
        return DAO.deleteEmployee(employeeDATA);
      }
      case "CARD_READ":{
        return gson.toJson(DAO.getFreeCards());
      }
      case "ROLE_READ":{
        return gson.toJson(DAO.getRoles());
      }
      default:{
        return null;
      }
    }
  }
}
