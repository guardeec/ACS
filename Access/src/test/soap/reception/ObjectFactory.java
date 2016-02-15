
package soap.reception;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap.reception package. 
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

    private final static QName _ReceptionMethodsResponse_QNAME = new QName("http://admin.client.services.server/", "receptionMethodsResponse");
    private final static QName _ReceptionMethods_QNAME = new QName("http://admin.client.services.server/", "receptionMethods");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap.reception
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReceptionMethodsResponse }
     * 
     */
    public ReceptionMethodsResponse createReceptionMethodsResponse() {
        return new ReceptionMethodsResponse();
    }

    /**
     * Create an instance of {@link ReceptionMethods }
     * 
     */
    public ReceptionMethods createReceptionMethods() {
        return new ReceptionMethods();
    }

    /**
     * Create an instance of {@link CardDATA }
     * 
     */
    public CardDATA createCardDATA() {
        return new CardDATA();
    }

    /**
     * Create an instance of {@link GuestDATA }
     * 
     */
    public GuestDATA createGuestDATA() {
        return new GuestDATA();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceptionMethodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://admin.client.services.server/", name = "receptionMethodsResponse")
    public JAXBElement<ReceptionMethodsResponse> createReceptionMethodsResponse(ReceptionMethodsResponse value) {
        return new JAXBElement<ReceptionMethodsResponse>(_ReceptionMethodsResponse_QNAME, ReceptionMethodsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceptionMethods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://admin.client.services.server/", name = "receptionMethods")
    public JAXBElement<ReceptionMethods> createReceptionMethods(ReceptionMethods value) {
        return new JAXBElement<ReceptionMethods>(_ReceptionMethods_QNAME, ReceptionMethods.class, null, value);
    }

}
