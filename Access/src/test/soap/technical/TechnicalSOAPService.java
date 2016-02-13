
package soap.technical;

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
@WebServiceClient(name = "TechnicalSOAPService", targetNamespace = "http://admin.client.services.server/", wsdlLocation = "http://192.168.1.96:8080/Access%5Fwar/server.services/TechnicalSOAP?wsdl")
public class TechnicalSOAPService
    extends Service
{

    private final static URL TECHNICALSOAPSERVICE_WSDL_LOCATION;
    private final static WebServiceException TECHNICALSOAPSERVICE_EXCEPTION;
    private final static QName TECHNICALSOAPSERVICE_QNAME = new QName("http://admin.client.services.server/", "TechnicalSOAPService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.1.96:8080/Access%5Fwar/server.services/TechnicalSOAP?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TECHNICALSOAPSERVICE_WSDL_LOCATION = url;
        TECHNICALSOAPSERVICE_EXCEPTION = e;
    }

    public TechnicalSOAPService() {
        super(__getWsdlLocation(), TECHNICALSOAPSERVICE_QNAME);
    }

    public TechnicalSOAPService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TECHNICALSOAPSERVICE_QNAME, features);
    }

    public TechnicalSOAPService(URL wsdlLocation) {
        super(wsdlLocation, TECHNICALSOAPSERVICE_QNAME);
    }

    public TechnicalSOAPService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TECHNICALSOAPSERVICE_QNAME, features);
    }

    public TechnicalSOAPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TechnicalSOAPService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TechnicalSOAP
     */
    @WebEndpoint(name = "TechnicalSOAPPort")
    public TechnicalSOAP getTechnicalSOAPPort() {
        return super.getPort(new QName("http://admin.client.services.server/", "TechnicalSOAPPort"), TechnicalSOAP.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TechnicalSOAP
     */
    @WebEndpoint(name = "TechnicalSOAPPort")
    public TechnicalSOAP getTechnicalSOAPPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://admin.client.services.server/", "TechnicalSOAPPort"), TechnicalSOAP.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TECHNICALSOAPSERVICE_EXCEPTION!= null) {
            throw TECHNICALSOAPSERVICE_EXCEPTION;
        }
        return TECHNICALSOAPSERVICE_WSDL_LOCATION;
    }

}
