package tests.basic;

import generator.HRMethods;
import generator.SecurityMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import soap.hr.EmployeeDATA;
import soap.security.CardDATA;
import soap.security.RoleDATA;

/**
 * Created by Guardeec on 12.02.16.
 */
public class Test_HR {
    private int cardId;
    private int roleId;

    @Before
    public void init(){
        try {
            CardDATA cardDATA = new CardDATA();
            cardDATA.setCardNumber("card");
            cardId = SecurityMethods.addCard(cardDATA).getCardId();

            RoleDATA roleDATA = new RoleDATA();
            roleDATA.setSystemRoleTitle("test");
            roleId = SecurityMethods.addRole(roleDATA).getSystemRoleId();
        }catch (NullPointerException ex){
            Assert.fail("HR_INIT");
        }
    }

    @Test
    public void test_EMPLOYEE(){
        //проверяем на поиск карт
        if (HRMethods.getCards(null).size()<1){
            Assert.fail("CARD_GET");
        }
        //проверяем на поиск ролей
        if (HRMethods.getRoles(null).size()<1){
            Assert.fail("ROLES_GET");
        }

        //проверяем на добавление пользователя
        EmployeeDATA employeeDATA = new EmployeeDATA();
        employeeDATA.setCardId(cardId);
        employeeDATA.setEmployeeName("test");
        employeeDATA.setSystemRoleId(roleId);
        employeeDATA = HRMethods.addEmployee(employeeDATA);
        if (employeeDATA.getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("EMPLOYEE_ADD");
        }

        //проверяем на изменение пользователя
        if (HRMethods.changeEmployee(employeeDATA).getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("EMPLOYEE_CHANGE");
        }

        //проверяем на получение
        if (HRMethods.getEmployee(new EmployeeDATA()).size()<1){
            Assert.fail("EMPLOYEE_GET");
        }

        //проверяем на удаление
        if (HRMethods.deleteEmployee(employeeDATA).getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("EMPLOYEE_DEL");
        }
    }

    @After
    public void clear(){
        CardDATA cardDATA = new CardDATA();
        cardDATA.setCardId(cardId);
        SecurityMethods.deleteCard(cardDATA);

        RoleDATA roleDATA = new RoleDATA();
        roleDATA.setSystemRoleId(roleId);
        SecurityMethods.deleteRole(roleDATA);
    }
}
