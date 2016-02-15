
package soap.hr;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap.hr package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HRMethods_QNAME = new QName("http://admin.client.services.server/", "HRMethods");
    private final static QName _HRMethodsResponse_QNAME = new QName("http://admin.client.services.server/", "HRMethodsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap.hr
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HRMethods }
     * 
     */
    public HRMethods createHRMethods() {
        return new HRMethods();
    }

    /**
     * Create an instance of {@link HRMethodsResponse }
     * 
     */
    public HRMethodsResponse createHRMethodsResponse() {
        return new HRMethodsResponse();
    }

    /**
     * Create an instance of {@link CardDATA }
     * 
     */
    public CardDATA createCardDATA() {
        return new CardDATA();
    }

    /**
     * Create an instance of {@link RoleDATA }
     * 
     */
    public RoleDATA createRoleDATA() {
        return new RoleDATA();
    }

    /**
     * Create an instance of {@link EmployeeDATA }
     * 
     */
    public EmployeeDATA createEmployeeDATA() {
        return new EmployeeDATA();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HRMethods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://admin.client.services.server/", name = "HRMethods")
    public JAXBElement<HRMethods> createHRMethods(HRMethods value) {
        return new JAXBElement<HRMethods>(_HRMethods_QNAME, HRMethods.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HRMethodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://admin.client.services.server/", name = "HRMethodsResponse")
    public JAXBElement<HRMethodsResponse> createHRMethodsResponse(HRMethodsResponse value) {
        return new JAXBElement<HRMethodsResponse>(_HRMethodsResponse_QNAME, HRMethodsResponse.class, null, value);
    }

}
