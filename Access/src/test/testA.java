import generator.TechnicalMethods;
import org.junit.Assert;
import org.junit.Test;
import soap.technical.DeviceDATA;


/**
 * Created by Guardeec on 10.02.16.
 */
public class testA {

  private final String testParam = "aaaaaa";

  private DeviceDATA makeDevice(){
    DeviceDATA deviceDATA = new DeviceDATA();
    deviceDATA.setDeviceSpecification(testParam);
    deviceDATA.setDeviceIp(testParam);
    deviceDATA.setDeviceSecription(testParam);
    deviceDATA.setDeviceMac(testParam);
    deviceDATA.setDeviceCondition(true);
    return deviceDATA;
  }


  public void test_DeviceAdd(){
    DeviceDATA deviceDATA = makeDevice();
    deviceDATA = TechnicalMethods.addDevice(deviceDATA);

    if (deviceDATA.getGeneralDescription().compareTo("SUCCESS")!=0){
      Assert.fail();
    }

    deviceDATA = TechnicalMethods.deleteDevice(deviceDATA);
  }

  public void test_DeviceChange(){
    DeviceDATA deviceDATA = makeDevice();
    deviceDATA = TechnicalMethods.addDevice(deviceDATA);
    deviceDATA.setDeviceIp(testParam+"a");
    deviceDATA = TechnicalMethods.changeDevice(deviceDATA);

    if (deviceDATA.getGeneralDescription().compareTo("SUCCESS")!=0){
      Assert.fail();
    }

    deviceDATA = TechnicalMethods.deleteDevice(deviceDATA);
  }

  @Test
  public void test_DeviceGet(){
    DeviceDATA deviceDATA = new DeviceDATA();
    deviceDATA.setDeviceIp(null);
    deviceDATA.setDeviceSpecification(null);
    deviceDATA.setDeviceId(null);

    TechnicalMethods.getDevice(deviceDATA);

  }


  public void test_DeviceDelete(){
    DeviceDATA deviceDATA = makeDevice();
    deviceDATA = TechnicalMethods.addDevice(deviceDATA);
    deviceDATA = TechnicalMethods.deleteDevice(deviceDATA);

    if (deviceDATA.getGeneralDescription().compareTo("SUCCESS")!=0){
      Assert.fail();
    }
  }
}
