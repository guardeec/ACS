
package soap.reception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for receptionMethods complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="receptionMethods">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://admin.client.services.server/}guestDATA" minOccurs="0"/>
 *         &lt;element name="arg2" type="{http://admin.client.services.server/}cardDATA" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "receptionMethods", propOrder = {
    "arg0",
    "arg1",
    "arg2"
})
public class ReceptionMethods {

    protected String arg0;
    protected GuestDATA arg1;
    protected CardDATA arg2;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg0(String value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     * @return
     *     possible object is
     *     {@link GuestDATA }
     *     
     */
    public GuestDATA getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuestDATA }
     *     
     */
    public void setArg1(GuestDATA value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     * 
     * @return
     *     possible object is
     *     {@link CardDATA }
     *     
     */
    public CardDATA getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardDATA }
     *     
     */
    public void setArg2(CardDATA value) {
        this.arg2 = value;
    }

}
