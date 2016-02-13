
package soap.technical;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap.technical package. 
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

    private final static QName _TechnicalMethodsResponse_QNAME = new QName("http://admin.client.services.server/", "technicalMethodsResponse");
    private final static QName _TechnicalMethods_QNAME = new QName("http://admin.client.services.server/", "technicalMethods");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap.technical
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TechnicalMethodsResponse }
     * 
     */
    public TechnicalMethodsResponse createTechnicalMethodsResponse() {
        return new TechnicalMethodsResponse();
    }

    /**
     * Create an instance of {@link TechnicalMethods }
     * 
     */
    public TechnicalMethods createTechnicalMethods() {
        return new TechnicalMethods();
    }

    /**
     * Create an instance of {@link DeviceDATA }
     * 
     */
    public DeviceDATA createDeviceDATA() {
        return new DeviceDATA();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TechnicalMethodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://admin.client.services.server/", name = "technicalMethodsResponse")
    public JAXBElement<TechnicalMethodsResponse> createTechnicalMethodsResponse(TechnicalMethodsResponse value) {
        return new JAXBElement<TechnicalMethodsResponse>(_TechnicalMethodsResponse_QNAME, TechnicalMethodsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TechnicalMethods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://admin.client.services.server/", name = "technicalMethods")
    public JAXBElement<TechnicalMethods> createTechnicalMethods(TechnicalMethods value) {
        return new JAXBElement<TechnicalMethods>(_TechnicalMethods_QNAME, TechnicalMethods.class, null, value);
    }

}
