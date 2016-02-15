package soap;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Guardeec on 15.02.16.
 */
public class SoapURL {
    private static SoapURL ourInstance = new SoapURL();

    public static SoapURL getInstance() {
        return ourInstance;
    }

    private URL HR_URL;
    private URL RECEPTION_URL;
    private URL SECURITY_URL;
    private URL TECHNICAL_URL;

    private SoapURL() {
        try {
            this.HR_URL = new URL("http://localhost:8080/server.services/HRSOAP?wsdl");
            this.RECEPTION_URL = new URL("http://localhost:8080/server.services/ReceptionSOAP?wsdl");
            this.SECURITY_URL = new URL("http://localhost:8080/server.services/SecuritySOAP?wsdl");
            this.TECHNICAL_URL = new URL("http://localhost:8080/server.services/TechnicalSOAP?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public URL HR_URL() {
        return HR_URL;
    }

    public URL RECEPTION_URL() {
        return RECEPTION_URL;
    }

    public URL SECURITY_URL() {
        return SECURITY_URL;
    }

    public URL TECHNICAL_URL() {
        return TECHNICAL_URL;
    }
}
