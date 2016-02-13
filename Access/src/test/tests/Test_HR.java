package tests;

import org.junit.Assert;
import soap.hr.EmployeeDATA;
import soap.hr.HRSoap;
import soap.hr.HRSoapService;
import soap.security.CardDATA;

import java.util.List;

/**
 * Created by Guardeec on 12.02.16.
 */
public class Test_HR {



    public void test_addGuest(){
        HRSoapService hrSoapService = new HRSoapService();
        HRSoap hrSoap = hrSoapService.getHRSoapPort();

        List<CardDATA> list = (List<CardDATA>) hrSoap.hrMethods("CARD_READ", new EmployeeDATA());

        for (CardDATA cardDATA : list){
            System.out.println(cardDATA.getCardId());
        }
        if (list==null){
            Assert.fail();
        }
    }

}
