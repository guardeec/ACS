package generator;

import soap.hr.EmployeeDATA;
import soap.hr.HRSoap;
import soap.hr.HRSoapService;
import soap.security.CardDATA;
import soap.security.RoleDATA;

import java.util.List;

/**
 * Created by Guardeec on 13.02.16.
 */
public class HRMethods {

    public static EmployeeDATA addEmployee(EmployeeDATA employeeDATA){
        HRSoapService hrSoapService = new HRSoapService();
        HRSoap hrSoap = hrSoapService.getHRSoapPort();

        employeeDATA = (EmployeeDATA) hrSoap.hrMethods("EMPLOYEE_CREATE", employeeDATA);
        return employeeDATA;
    }
    public static EmployeeDATA changeEmployee(EmployeeDATA employeeDATA){
        HRSoapService hrSoapService = new HRSoapService();
        HRSoap hrSoap = hrSoapService.getHRSoapPort();

        employeeDATA = (EmployeeDATA) hrSoap.hrMethods("EMPLOYEE_UPDATE", employeeDATA);
        return employeeDATA;
    }
    public static EmployeeDATA deleteEmployee(EmployeeDATA employeeDATA){
        HRSoapService hrSoapService = new HRSoapService();
        HRSoap hrSoap = hrSoapService.getHRSoapPort();

        employeeDATA = (EmployeeDATA) hrSoap.hrMethods("EMPLOYEE_DELETE", employeeDATA);
        return employeeDATA;
    }
    public static List<EmployeeDATA> getEmployee(EmployeeDATA employeeDATA){
        return null;
    }



    public static List<CardDATA> getCards(){
        return null;
    }



    public static List<RoleDATA> getRoles(){
        return null;
    }

}
