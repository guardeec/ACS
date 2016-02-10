package server.services.server;

import javax.servlet.http.HttpServlet;

/**
 * Created by root on 12.08.15.
 */
public class getAdminType extends HttpServlet {
    /*
    private final ApplicationContext appContext = new ClassPathXmlApplicationContext("server/JDBC_config.xml");
    private final server.postgress.server.interfaces.GetAdminTypeImpl authorisationDB = (java.server.postgress.server.interfaces.GetAdminTypeImpl) appContext.getBean("GetAdminTypeDAO");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map reqMap = request.getParameterMap();
        String[] adminName = (String[]) reqMap.get("adminName");
        String[] adminPasswordHash = (String[]) reqMap.get("adminPasswordHash");

        Map<String, Boolean> message = authorisationDB.get(adminName[0], adminPasswordHash[0]);

        PrintWriter out = response.getWriter();
        out.println(message.entrySet());
    }
    */
}
