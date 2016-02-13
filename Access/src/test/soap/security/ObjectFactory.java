
package soap.security;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap.security package. 
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

    private final static QName _SecurityMethods_QNAME = new QName("http://admin.client.services.server/", "securityMethods");
    private final static QName _SecurityMethodsResponse_QNAME = new QName("http://admin.client.services.server/", "securityMethodsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap.security
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SecurityMethods }
     * 
     */
    public SecurityMethods createSecurityMethods() {
        return new SecurityMethods();
    }

    /**
     * Create an instance of {@link SecurityMethodsResponse }
     * 
     */
    public SecurityMethodsResponse createSecurityMethodsResponse() {
        return new SecurityMethodsResponse();
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
     * Create an instance of {@link DeviceDATA }
     * 
     */
    public DeviceDATA createDeviceDATA() {
        return new DeviceDATA();
    }

    /**
     * Create an instance of {@link RightDATA }
     * 
     */
    public RightDATA createRightDATA() {
        return new RightDATA();
    }

    /**
     * Create an instance of {@link AccountDATA }
     * 
     */
    public AccountDATA createAccountDATA() {
        return new AccountDATA();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityMethods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://admin.client.services.server/", name = "securityMethods")
    public JAXBElement<SecurityMethods> createSecurityMethods(SecurityMethods value) {
        return new JAXBElement<SecurityMethods>(_SecurityMethods_QNAME, SecurityMethods.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityMethodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://admin.client.services.server/", name = "securityMethodsResponse")
    public JAXBElement<SecurityMethodsResponse> createSecurityMethodsResponse(SecurityMethodsResponse value) {
        return new JAXBElement<SecurityMethodsResponse>(_SecurityMethodsResponse_QNAME, SecurityMethodsResponse.class, null, value);
    }

}
