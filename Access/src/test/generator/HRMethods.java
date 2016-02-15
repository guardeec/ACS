package generator;


import com.google.gson.Gson;
import soap.SoapURL;
import soap.hr.*;

import java.net.URL;
import java.util.List;

/**
 * Created by Guardeec on 13.02.16.
 */
public class HRMethods {

    private static final URL URL = SoapURL.getInstance().HR_URL();

    public static EmployeeDATA addEmployee(EmployeeDATA employeeDATA){
        HRSOAPService hrSoapService = new HRSOAPService(URL);
        HRSOAP hrSoap = hrSoapService.getHRSOAPPort();

        employeeDATA = (EmployeeDATA) hrSoap.hrMethods("EMPLOYEE_CREATE", employeeDATA, null, null);
        return employeeDATA;
    }
    public static EmployeeDATA changeEmployee(EmployeeDATA employeeDATA){
        HRSOAPService hrSoapService = new HRSOAPService(URL);
        HRSOAP hrSoap = hrSoapService.getHRSOAPPort();

        employeeDATA = (EmployeeDATA) hrSoap.hrMethods("EMPLOYEE_UPDATE", employeeDATA, null ,null);
        return employeeDATA;
    }
    public static EmployeeDATA deleteEmployee(EmployeeDATA employeeDATA){
        HRSOAPService hrSoapService = new HRSOAPService(URL);
        HRSOAP hrSoap = hrSoapService.getHRSOAPPort();

        employeeDATA = (EmployeeDATA) hrSoap.hrMethods("EMPLOYEE_DELETE", employeeDATA, null ,null);
        return employeeDATA;
    }
    public static List<EmployeeDATA> getEmployee(EmployeeDATA employeeDATA){
        HRSOAPService hrSoapService = new HRSOAPService(URL);
        HRSOAP hrSoap = hrSoapService.getHRSOAPPort();

        String json = (String) hrSoap.hrMethods("EMPLOYEE_READ", employeeDATA, null, null);
        Gson gson = new Gson();
        List<EmployeeDATA> employeeDATAList = gson.fromJson(json, List.class);
        return employeeDATAList;
    }



    public static List<CardDATA> getCards(CardDATA cardDATA){
        HRSOAPService hrSoapService = new HRSOAPService(URL);
        HRSOAP hrSoap = hrSoapService.getHRSOAPPort();

        String json = (String) hrSoap.hrMethods("CARD_READ", null, cardDATA, null);
        Gson gson = new Gson();
        return gson.fromJson(json, List.class);
    }



    public static List<RoleDATA> getRoles(RoleDATA roleDATA){
        HRSOAPService hrSoapService = new HRSOAPService(URL);
        HRSOAP hrSoap = hrSoapService.getHRSOAPPort();

        String json = (String) hrSoap.hrMethods("ROLE_READ", null, null, roleDATA);
        Gson gson = new Gson();
        return gson.fromJson(json, List.class);
    }

}
