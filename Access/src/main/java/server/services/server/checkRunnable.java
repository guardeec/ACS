package server.services.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import server.postgress.server.interfaces.CheckRunnableImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by root on 12.08.15.
 */
public class checkRunnable extends HttpServlet {

    private final ApplicationContext appContext = new ClassPathXmlApplicationContext("server/JDBC_config.xml");
    private final CheckRunnableImpl authorisationDB = (CheckRunnableImpl) appContext.getBean("checkRunnable");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean connection = authorisationDB.check();
        PrintWriter out = response.getWriter();
        out.println(connection.toString());
    }

}
