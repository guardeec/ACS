package server.services.client.admin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.client.admin.EmployeeDATA;
import server.postgress.admin.HRDAO;
import server.postgress.admin.HRImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Guardeec on 08.02.16.
 */
@WebService()
public class HRSoap {
  private final ApplicationContext appContext = new ClassPathXmlApplicationContext("server/JDBC_config.xml");
  private final HRImpl DAO = (HRDAO) appContext.getBean("HRAdmin");

  @WebMethod
  public Object HRMethods(
          String targetAndCrud,
          EmployeeDATA employeeDATA
  ) {
    switch (targetAndCrud){
      case "EMPLOYEE_CREATE":{
        return DAO.addEmployee(employeeDATA);
      }
      case "EMPLYEE_READ":{
        return DAO.getEmployee(employeeDATA);
      }
      case "EMPLOYEE_UPDATE":{
        return DAO.changeEmployee(employeeDATA);
      }
      case "EMPLOYEE_DELETE":{
        return DAO.deleteEmployee(employeeDATA);
      }
      case "CARD_READ":{
        return DAO.getFreeCards();
      }
      case "ROLE_READ":{
        return DAO.getRoles();
      }
      default:{
        return null;
      }
    }
  }
}
