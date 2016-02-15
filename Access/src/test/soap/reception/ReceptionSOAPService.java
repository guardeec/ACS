
package soap.reception;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ReceptionSOAPService", targetNamespace = "http://admin.client.services.server/", wsdlLocation = "http://localhost:8080/server.services/ReceptionSOAP?wsdl")
public class ReceptionSOAPService
    extends Service
{

    private final static URL RECEPTIONSOAPSERVICE_WSDL_LOCATION;
    private final static WebServiceException RECEPTIONSOAPSERVICE_EXCEPTION;
    private final static QName RECEPTIONSOAPSERVICE_QNAME = new QName("http://admin.client.services.server/", "ReceptionSOAPService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/server.services/ReceptionSOAP?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RECEPTIONSOAPSERVICE_WSDL_LOCATION = url;
        RECEPTIONSOAPSERVICE_EXCEPTION = e;
    }

    public ReceptionSOAPService() {
        super(__getWsdlLocation(), RECEPTIONSOAPSERVICE_QNAME);
    }

    public ReceptionSOAPService(WebServiceFeature... features) {
        super(__getWsdlLocation(), RECEPTIONSOAPSERVICE_QNAME, features);
    }

    public ReceptionSOAPService(URL wsdlLocation) {
        super(wsdlLocation, RECEPTIONSOAPSERVICE_QNAME);
    }

    public ReceptionSOAPService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RECEPTIONSOAPSERVICE_QNAME, features);
    }

    public ReceptionSOAPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ReceptionSOAPService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ReceptionSOAP
     */
    @WebEndpoint(name = "ReceptionSOAPPort")
    public ReceptionSOAP getReceptionSOAPPort() {
        return super.getPort(new QName("http://admin.client.services.server/", "ReceptionSOAPPort"), ReceptionSOAP.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ReceptionSOAP
     */
    @WebEndpoint(name = "ReceptionSOAPPort")
    public ReceptionSOAP getReceptionSOAPPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://admin.client.services.server/", "ReceptionSOAPPort"), ReceptionSOAP.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RECEPTIONSOAPSERVICE_EXCEPTION!= null) {
            throw RECEPTIONSOAPSERVICE_EXCEPTION;
        }
        return RECEPTIONSOAPSERVICE_WSDL_LOCATION;
    }

}
