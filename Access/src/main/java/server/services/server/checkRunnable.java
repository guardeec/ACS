package server.services.server;

import javax.servlet.http.HttpServlet;

/**
 * Created by root on 12.08.15.
 */
public class checkRunnable extends HttpServlet {
    /*
    private final ApplicationContext appContext = new ClassPathXmlApplicationContext("server/JDBC_config.xml");
    private final CheckRunnableImpl authorisationDB = (CheckRunnableImpl) appContext.getBean("CheckRunnableDAO");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map reqMap = request.getParameterMap();
        Map<String, Boolean> message = authorisationDB.check();
        message.put("Server", true);

        PrintWriter out = response.getWriter();
        out.println(message.entrySet());
    }
    */
}
