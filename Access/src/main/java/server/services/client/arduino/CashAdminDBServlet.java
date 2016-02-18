package server.services.client.arduino;

import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.client.arduino.CashAdminDBData;
import server.postgress.arduino.CashAdminDBImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by root on 12.08.15.
 */
public class CashAdminDBServlet extends HttpServlet {

    private final Gson gson = new Gson();
    private final ApplicationContext appContext = new ClassPathXmlApplicationContext("server/JDBC_config.xml");
    private final CashAdminDBImpl adminDB = (CashAdminDBImpl) appContext.getBean("cashAdminDB");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] message = request.getParameterMap().get("message");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(adminDB.get(gson.fromJson(message[0], CashAdminDBData.class))));
    }
}
