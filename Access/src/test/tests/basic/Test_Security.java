package tests.basic;

import generator.SecurityMethods;
import generator.TechnicalMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import soap.security.CardDATA;
import soap.security.RightDATA;
import soap.security.RoleDATA;
import soap.technical.DeviceDATA;

/**
 * Created by Guardeec on 12.02.16.
 */
public class Test_Security {

    private int deviceId;

    @Before
    public void init(){
        try {
            DeviceDATA deviceDATA = new DeviceDATA();
            deviceDATA.setDeviceSpecification("test");
            deviceDATA.setDeviceIp("test");
            deviceDATA = TechnicalMethods.addDevice(deviceDATA);
            deviceId = deviceDATA.getDeviceId();
        }catch (NullPointerException ex){
            Assert.fail("SECURITY_INIT");
        }
    }

    @Test
    public void test_ACCOUNT(){
        //прверяем на получений устройств
        if (SecurityMethods.getDevice(new soap.security.DeviceDATA()).size()<1){
            Assert.fail("DEVICE_GET");
        }

        //проверяем на добавление карт
        CardDATA cardDATA = new CardDATA();
        cardDATA.setCardNumber("test");
        cardDATA = SecurityMethods.addCard(cardDATA);
        if (cardDATA.getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("CARD_ADD");
        }

        //проверяем на получение карт
        try {
            if (SecurityMethods.getCard(new CardDATA()).size()<1){
                Assert.fail("CARD_GET");
            }
        }catch (NullPointerException ex){
            Assert.fail("CARD_GET");
        }

        //проверяем на удаление карт
        if (SecurityMethods.deleteCard(cardDATA).getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("CARD_DELETE");
        }

        //проверяем на добавление роли
        RoleDATA roleDATA = new RoleDATA();
        roleDATA.setSystemRoleTitle("test");
        roleDATA = SecurityMethods.addRole(roleDATA);
        if (roleDATA.getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("ROLE_ADD");
        }

        //проверяем на получение прав
        if (SecurityMethods.getRight(new RightDATA()).size()<1){
            Assert.fail("RIGHT_GET");
        }

        //проверяем на изменение прав
        RightDATA rightDATA = new RightDATA();
        rightDATA.setDeviceId(deviceId);
        rightDATA.setSystemRoleId(roleDATA.getSystemRoleId());
        rightDATA.setAccess(false);
        if (SecurityMethods.changeRight(rightDATA).getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("RIGHT_CHANGE");
        }

        //проверяем на изменение ролей
        if (SecurityMethods.changeRole(roleDATA).getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("ROLE_CHANGE");
        }

        //проверяем на получение ролей
        if (SecurityMethods.getRole(new RoleDATA()).size()<1){
            Assert.fail("ROLE_GET");
        }

        //проверяем на удаление ролей
        if (SecurityMethods.deleteRole(roleDATA).getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("ROLE_DELETE");
        }
    }

    @After
    public void clear(){
        DeviceDATA deviceDATA = new DeviceDATA();
        deviceDATA.setDeviceId(deviceId);
        TechnicalMethods.deleteDevice(deviceDATA);
    }
}
