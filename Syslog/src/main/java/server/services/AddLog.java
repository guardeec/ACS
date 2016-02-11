package server.services;

import server.postgres.containers.Spring_DAO;
import com.google.gson.Gson;
import pojo.client.admin.*;
import pojo.client.arduino.ConnectionErrorDATA;
import pojo.client.arduino.GetAccessData;
import pojo.client.arduino.LocalErrorDATA;
import pojo.client.arduino.UnuathorizedAccessDATA;
import pojo.client.agent.UserClientSessionDATA;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 28.10.15.
 */
public class AddLog extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String object = req.getReader().readLine();
        String objectType = req.getHeader("ObjectType");
        Gson gson = new Gson();

        Integer eventId;

        /*
        Admin Client
         */
        if (objectType.compareTo(EmployeeDATA.class.getName())==0){
            EmployeeDATA employee = gson.fromJson(object, EmployeeDATA.class);
            employee.setSourceIp(req.getRemoteAddr());
            eventId = Spring_DAO.GENERAL_DAO.log(employee);
            if (eventId!=null){
                employee.setGeneralEventTypeId(eventId);
                object = Spring_DAO.EMPLOYEE_DAO.log(employee);
            }
        }
        if (objectType.compareTo(GuestDATA.class.getName())==0){
            GuestDATA guest = gson.fromJson(object, GuestDATA.class);
            guest.setSourceIp(req.getRemoteAddr());
            eventId = Spring_DAO.GENERAL_DAO.log(guest);
            if (eventId!=null){
                guest.setGeneralEventTypeId(eventId);
                object = Spring_DAO.GUEST_DAO.log(guest);
            }
        }
        if (objectType.compareTo(AccountDATA.class.getName())==0){
            AccountDATA account = gson.fromJson(object, AccountDATA.class);
            account.setSourceIp(req.getRemoteAddr());
            eventId = Spring_DAO.GENERAL_DAO.log(account);
            if (eventId!=null){
                account.setGeneralEventTypeId(eventId);
                object = Spring_DAO.ACCOUNT_DAO.log(account);
            }
        }
        if (objectType.compareTo(CardDATA.class.getName())==0){
            CardDATA card = gson.fromJson(object, CardDATA.class);
            card.setSourceIp(req.getRemoteAddr());
            eventId = Spring_DAO.GENERAL_DAO.log(card);
            if (eventId!=null){
                card.setGeneralEventTypeId(eventId);
                object = Spring_DAO.CARD_DAO.log(card);
            }
        }
        if (objectType.compareTo(RightDATA.class.getName())==0){
            RightDATA right = gson.fromJson(object, RightDATA.class);
            right.setSourceIp(req.getRemoteAddr());
            eventId = Spring_DAO.GENERAL_DAO.log(right);
            if (eventId!=null){
                right.setGeneralEventTypeId(eventId);
                object = Spring_DAO.RIGHT_DAO.log(right);
            }
        }
        if (objectType.compareTo(RoleDATA.class.getName())==0){
            RoleDATA role = gson.fromJson(object, RoleDATA.class);
            role.setSourceIp(req.getRemoteAddr());
            eventId = Spring_DAO.GENERAL_DAO.log(role);
            if (eventId!=null){
                role.setGeneralEventTypeId(eventId);
                object = Spring_DAO.ROLE_DAO.log(role);
            }
        }
        if (objectType.compareTo(DeviceDATA.class.getName())==0){
            DeviceDATA device = gson.fromJson(object, DeviceDATA.class);
            device.setSourceIp(req.getRemoteAddr());
            eventId = Spring_DAO.GENERAL_DAO.log(device);
            if (eventId!=null){
                device.setGeneralEventTypeId(eventId);
                object = Spring_DAO.DEVICE_DAO.log(device);
            }
        }
        if (objectType.compareTo(AdminClientSessionDATA.class.getName())==0){
            AdminClientSessionDATA session = gson.fromJson(object, AdminClientSessionDATA.class);
            session.setSourceIp(req.getRemoteAddr());
            eventId = Spring_DAO.GENERAL_DAO.log(session);
            if (eventId!=null){
                session.setGeneralEventTypeId(eventId);
                object = Spring_DAO.ENTER_OR_OUT_ADMIN_DAO.log(session);
            }
        }

        /*
        Arduino Client
         */
        if (objectType.compareTo(LocalErrorDATA.class.getName())==0){
            LocalErrorDATA localError = gson.fromJson(object, LocalErrorDATA.class);
            localError.setSourceIp(req.getRemoteAddr());
            eventId = Spring_DAO.GENERAL_DAO.log(localError);
            if (eventId!=null){
                object="Success";
            }
        }
        if (objectType.compareTo(ConnectionErrorDATA.class.getName())==0){
            ConnectionErrorDATA connectionError = gson.fromJson(object, ConnectionErrorDATA.class);
            connectionError.setSourceIp(req.getRemoteAddr());
            eventId = Spring_DAO.GENERAL_DAO.log(connectionError);
            if (eventId!=null){
                object="Success";
            }
        }
        if (objectType.compareTo(GetAccessData.class.getName())==0){
            GetAccessData room = gson.fromJson(object, GetAccessData.class);
            room.setSourceIp(req.getRemoteAddr());
            eventId = Spring_DAO.GENERAL_DAO.log(room);
            if (eventId!=null){
                room.setGeneralEventTypeId(eventId);
                object = Spring_DAO.ENTER_OT_OUT_THE_ROOM_DAO.log(room);
            }
        }
        if (objectType.compareTo(UnuathorizedAccessDATA.class.getName())==0){
            UnuathorizedAccessDATA fail = gson.fromJson(object, UnuathorizedAccessDATA.class);
            fail.setSourceIp(req.getRemoteAddr());
            eventId = Spring_DAO.GENERAL_DAO.log(fail);
            if (eventId!=null){
                object="Success";
            }
        }

        /*
        User client
         */
        if (objectType.compareTo(UserClientSessionDATA.class.getName())==0){
            UserClientSessionDATA session = gson.fromJson(object, UserClientSessionDATA.class);
            session.setSourceIp(req.getRemoteAddr());
            eventId = Spring_DAO.GENERAL_DAO.log(session);
            if (eventId!=null){
                session.setGeneralEventTypeId(eventId);
                object = Spring_DAO.ENTER_OR_OUT_THE_SYSTEM_DAO.log(session);
            }
        }

        /*
        Ответ
         */
        if (object.contains("Success")){
            resp.addHeader("Status", "OK");
        }else {
            resp.addHeader("Status", "FAIL");
        }
    }
}
