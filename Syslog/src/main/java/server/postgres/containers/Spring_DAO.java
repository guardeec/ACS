package server.postgres.containers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import server.postgres.jdbc.SetGeneralDAO;
import server.postgres.jdbc.SetGeneralImpl;
import server.postgres.jdbc.client.admin.*;
import server.postgres.jdbc.client.agent.EnterOrOutTheSystemDAO;
import server.postgres.jdbc.client.agent.EnterOtOutTheSystemImpl;
import server.postgres.jdbc.client.arduino.EnterOrOutTheRoomDAO;
import server.postgres.jdbc.client.arduino.EnterOtOutTheRoomImpl;

/**
 * Created by root on 23.10.15.
 */
public interface Spring_DAO {
    ApplicationContext appContext = new ClassPathXmlApplicationContext("JDBC_config.xml");
    SetGeneralImpl GENERAL_DAO                                           = (SetGeneralDAO) appContext.getBean("GENERAL_LOG");

    EmplyeeImpl EMPLOYEE_DAO                          = (EmployeeDAO) appContext.getBean("EMPLOYEE_LOG");
    GuestImpl GUEST_DAO                        = (GuestDAO) appContext.getBean("GUEST_LOG");
    AccountImpl ACCOUNT_DAO                     = (AccountDAO) appContext.getBean("ACCOUNT_LOG");
    CardImpl CARD_DAO                           = (CardDAO) appContext.getBean("CARD_LOG");
    RightImpl RIGHT_DAO                         = (RightDAO) appContext.getBean("RIGHT_LOG");
    RoleImpl ROLE_DAO                           = (RoleDAO) appContext.getBean("ROLE_LOG");
    DeviceImpl DEVICE_DAO                      = (DeviceDAO) appContext.getBean("DEVICE_LOG");
    EnterOrOutAdminImpl ENTER_OR_OUT_ADMIN_DAO           = (EnterOrOutAdminDAO) appContext.getBean("ENTEROROUTADMIN_LOG");

    EnterOtOutTheRoomImpl ENTER_OT_OUT_THE_ROOM_DAO    = (EnterOrOutTheRoomDAO) appContext.getBean("ENTEROROUTTHEROOM_LOG");
    //LocalErrorImpl LOCAL_ERROR_DAO                                              = (LocalErrorDAO) appContext.getBean("localError_addLog");
    //server.postgres.jdbc.client.arduino.UnauthorizedAccessImpl UNAUTHORIZED_ACCESS_DAO     = (server.postgres.jdbc.client.arduino.UnauthorizedAccessDAO) appContext.getBean("unauthorizedAccess_addLog");
    //ConnectionErrorImpl CONNECTION_ERROR_DAO                                    = (ConnectionErrorDAO) appContext.getBean("connectionError_addLog");

    EnterOtOutTheSystemImpl ENTER_OR_OUT_THE_SYSTEM_DAO       = (EnterOrOutTheSystemDAO) appContext.getBean("ENTEROROUTTHESYSTEM_LOG");

}
