package tests.basic;

import generator.TechnicalMethods;
import org.junit.Assert;
import org.junit.Test;
import soap.technical.DeviceDATA;

/**
 * Created by Guardeec on 12.02.16.
 */
public class Test_Technical {

    @Test
    public void test_DEVICE(){
        DeviceDATA deviceDATA = new DeviceDATA();
        deviceDATA.setDeviceIp("test");
        deviceDATA.setDeviceSpecification("test");

        //проверяем на добавление
        deviceDATA = TechnicalMethods.addDevice(deviceDATA);
        if (deviceDATA.getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("DEVICE_ADD");
        }

        //проверяем на изменение
        if (TechnicalMethods.changeDevice(deviceDATA).getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("DEVICE_CHANGE");
        }

        //проверяем на поиск
        if (TechnicalMethods.getDevice(new DeviceDATA()).size()<1){
            Assert.fail("DEVICE_GET");
        }

        //проверяем на удаление
        if (TechnicalMethods.deleteDevice(deviceDATA).getGeneralDescription().compareTo("SUCCESS")!=0){
            Assert.fail("DEVICE_DELETE");
        }
    }
}
