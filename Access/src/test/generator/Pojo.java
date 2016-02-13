package generator;

import soap.hr.EmployeeDATA;
import soap.reception.GuestDATA;
import soap.security.AccountDATA;
import soap.security.CardDATA;
import soap.security.RightDATA;
import soap.security.RoleDATA;
import soap.technical.DeviceDATA;

/**
 * Created by Guardeec on 12.02.16.
 */
public class Pojo {
    private static DeviceDATA deviceDATA = new DeviceDATA();
    private static AccountDATA accountDATA = new AccountDATA();
    private static CardDATA cardDATA = new CardDATA();
    private static EmployeeDATA employeeDATA = new EmployeeDATA();
    private static GuestDATA guestDATA = new GuestDATA();
    private static RightDATA rightDATA = new RightDATA();
    private static RoleDATA roleDATA = new RoleDATA();

    public static DeviceDATA getDevice(){
        deviceDATA.setDeviceCondition(true);
        deviceDATA.setDeviceIp("111");
        deviceDATA.setDeviceMac("mac");
        deviceDATA.setDeviceSecription("test");
        deviceDATA.setDeviceSpecification("test");
        return deviceDATA;
    }
}
