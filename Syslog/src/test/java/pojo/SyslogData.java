package pojo;

import pojo.client.admin.*;
import pojo.client.agent.UserClientSessionDATA;
import pojo.client.arduino.ConnectionErrorDATA;
import pojo.client.arduino.GetAccessData;
import pojo.client.arduino.LocalErrorDATA;
import pojo.client.arduino.UnuathorizedAccessDATA;

/**
 * Created by root on 29.10.15.
 */
public class SyslogData {
    public static final String URL_SYSLOG = "http://192.168.1.96:8080/Syslog%5Fwar/addLog";

    private static EmployeeDATA employeeDATA = new EmployeeDATA();
    private static GuestDATA guestDATA = new GuestDATA();
    private static AccountDATA accountDATA = new AccountDATA();
    private static CardDATA cardDATA = new CardDATA();
    private static RightDATA rightDATA = new RightDATA();
    private static RoleDATA roleDATA = new RoleDATA();
    private static DeviceDATA deviceDATA = new DeviceDATA();
    private static AdminClientSessionDATA adminClientSessionDATA = new AdminClientSessionDATA();

    private static ConnectionErrorDATA connectionErrorDATA = new ConnectionErrorDATA();
    private static LocalErrorDATA localErrorDATA = new LocalErrorDATA();
    private static GetAccessData roomDATA = new GetAccessData();
    private static UnuathorizedAccessDATA unuathorizedAccessDATA = new UnuathorizedAccessDATA();

    private static UserClientSessionDATA userClientSessionDATA = new UserClientSessionDATA();

    private static GeneralParams setGeneralAndSourceParams(GeneralParams object){
        java.util.Date date = new java.util.Date();
        object.setGeneralParams(null,date.getTime(),true,"THIS IS TEST");
        object.setSourceParams(null, "ip","mac",null,null,null);
        return object;
    }

    /*
    ClientAdmin
     */

    public static EmployeeDATA getEmployeeDATA() {
        employeeDATA = (EmployeeDATA) setGeneralAndSourceParams(employeeDATA);
        employeeDATA.setSpecificParams(0,"ghost",0,"ghost",0,"ghost_title",0);
        employeeDATA.setGeneralEventTypeId(server.postgres.containers.SyslogData.Event_Types.hr_dep.create);
        employeeDATA.setSourceTypeId(server.postgres.containers.SyslogData.Source_Types.adminClient);
        return employeeDATA;
    }

    public static GuestDATA getGuestDATA() {
        java.util.Date date = new java.util.Date();
        guestDATA = (GuestDATA) setGeneralAndSourceParams(guestDATA);
        guestDATA.setSpecificParams(0, "ghost", 0, date.getTime(), date.getTime());
        guestDATA.setGeneralEventTypeId(server.postgres.containers.SyslogData.Event_Types.rec_dep.create);
        guestDATA.setSourceTypeId(server.postgres.containers.SyslogData.Source_Types.adminClient);
        return guestDATA;
    }

    public static AccountDATA getAccountDATA() {
        accountDATA = (AccountDATA) setGeneralAndSourceParams(accountDATA);
        accountDATA.setSpecificParams(0,"ghost",0,"ghost","S",null);
        accountDATA.setGeneralEventTypeId(server.postgres.containers.SyslogData.Event_Types.sec_dep_acc.create);
        accountDATA.setSourceTypeId(server.postgres.containers.SyslogData.Source_Types.adminClient);
        return accountDATA;
    }

    public static CardDATA getCardDATA() {
        cardDATA = (CardDATA) setGeneralAndSourceParams(cardDATA);
        cardDATA.setSpecificParams(0,"123");
        cardDATA.setGeneralEventTypeId(server.postgres.containers.SyslogData.Event_Types.sec_dep_cards.create);
        cardDATA.setSourceTypeId(server.postgres.containers.SyslogData.Source_Types.adminClient);
        return cardDATA;
    }

    public static RightDATA getRightDATA() {
        rightDATA = (RightDATA) setGeneralAndSourceParams(rightDATA);
        rightDATA.setSpecificParams(0,"ghost",0,"ghost",true);
        rightDATA.setGeneralEventTypeId(server.postgres.containers.SyslogData.Event_Types.sec_dep_acs_r);
        rightDATA.setSourceTypeId(server.postgres.containers.SyslogData.Source_Types.adminClient);
        return rightDATA;
    }

    public static RoleDATA getRoleDATA() {
        roleDATA = (RoleDATA) setGeneralAndSourceParams(roleDATA);
        roleDATA.setSpecificParams(0,"ghost");
        roleDATA.setGeneralEventTypeId(server.postgres.containers.SyslogData.Event_Types.sec_dep_sys_r.create);
        roleDATA.setSourceTypeId(server.postgres.containers.SyslogData.Source_Types.adminClient);
        return roleDATA;
    }

    public static DeviceDATA getDeviceDATA() {
        deviceDATA = (DeviceDATA) setGeneralAndSourceParams(deviceDATA);
        deviceDATA.setSpecificParams(0,"0.0.0.0","00:00:00:00:00","ghost",true,"ghost");
        deviceDATA.setGeneralEventTypeId(server.postgres.containers.SyslogData.Event_Types.tech_dep.create);
        deviceDATA.setSourceTypeId(server.postgres.containers.SyslogData.Source_Types.adminClient);
        return deviceDATA;
    }

    public static AdminClientSessionDATA getAdminClientSessionDATA() {
        adminClientSessionDATA = (AdminClientSessionDATA) setGeneralAndSourceParams(adminClientSessionDATA);
        adminClientSessionDATA.setSpecificParams(0,"ghost","S");
        adminClientSessionDATA.setGeneralEventTypeId(server.postgres.containers.SyslogData.Event_Types.adm_cl_auth.login);
        adminClientSessionDATA.setSourceTypeId(server.postgres.containers.SyslogData.Source_Types.adminClient);
        return adminClientSessionDATA;
    }

    /*
    Arduino
     */
    public static ConnectionErrorDATA getConnectionErrorDATA() {
        connectionErrorDATA = (ConnectionErrorDATA) setGeneralAndSourceParams(connectionErrorDATA);
        connectionErrorDATA.setGeneralEventTypeId(server.postgres.containers.SyslogData.Event_Types.ard_conn_err);
        connectionErrorDATA.setSourceTypeId(server.postgres.containers.SyslogData.Source_Types.arduinoClient);
        return connectionErrorDATA;
    }

    public static LocalErrorDATA getLocalErrorDATA() {
        localErrorDATA = (LocalErrorDATA) setGeneralAndSourceParams(localErrorDATA);
        localErrorDATA.setGeneralEventTypeId(server.postgres.containers.SyslogData.Event_Types.ard_local_err.in_work);
        localErrorDATA.setSourceTypeId(server.postgres.containers.SyslogData.Source_Types.arduinoClient);
        return localErrorDATA;
    }

    public static GetAccessData getRoomDATA() {
        roomDATA = (GetAccessData) setGeneralAndSourceParams(roomDATA);
        roomDATA.setSpecificParams(0,"123",0,0,"test",0,"test",true,"guest","hi");
        roomDATA.setGeneralEventTypeId(server.postgres.containers.SyslogData.Event_Types.room_auth.login);
        roomDATA.setSourceTypeId(server.postgres.containers.SyslogData.Source_Types.arduinoClient);
        return roomDATA;
    }

    public static UnuathorizedAccessDATA getUnuathorizedAccessDATA() {
        unuathorizedAccessDATA = (UnuathorizedAccessDATA) setGeneralAndSourceParams(unuathorizedAccessDATA);
        unuathorizedAccessDATA.setGeneralEventTypeId(server.postgres.containers.SyslogData.Event_Types.ard_unauth);
        unuathorizedAccessDATA.setSourceTypeId(server.postgres.containers.SyslogData.Source_Types.arduinoClient);
        return unuathorizedAccessDATA;
    }

    public static UserClientSessionDATA getUserClientSessionDATA() {
        userClientSessionDATA = (UserClientSessionDATA) setGeneralAndSourceParams(userClientSessionDATA);
        userClientSessionDATA.setSpecificParams(0,"ghost",0,"ghostOS");
        userClientSessionDATA.setGeneralEventTypeId(server.postgres.containers.SyslogData.Event_Types.os_auth.login);
        userClientSessionDATA.setSourceTypeId(server.postgres.containers.SyslogData.Source_Types.hostAgent);
        return userClientSessionDATA;
    }
}
