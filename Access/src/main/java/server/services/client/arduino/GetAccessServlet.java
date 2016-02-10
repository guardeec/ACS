package server.services.client.arduino;

import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.client.arduino.GetAccessData;
import server.postgress.arduino.GetAccessDAO;
import server.postgress.arduino.GetAccessImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Kolomeec on 23.04.2015.
 */
public class GetAccessServlet extends HttpServlet {

    private final Gson gson = new Gson();
    private final ApplicationContext appContext = new ClassPathXmlApplicationContext("server/JDBC_config.xml");
    private final GetAccessImpl DAO = (GetAccessDAO) appContext.getBean("getAccess");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] message = (String[]) request.getParameterMap().get("message");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(DAO.Get(gson.fromJson(message[0], GetAccessData.class))));
    }
}
