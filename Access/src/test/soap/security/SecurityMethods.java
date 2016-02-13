
package soap.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for securityMethods complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="securityMethods">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://admin.client.services.server/}accountDATA" minOccurs="0"/>
 *         &lt;element name="arg2" type="{http://admin.client.services.server/}cardDATA" minOccurs="0"/>
 *         &lt;element name="arg3" type="{http://admin.client.services.server/}deviceDATA" minOccurs="0"/>
 *         &lt;element name="arg4" type="{http://admin.client.services.server/}rightDATA" minOccurs="0"/>
 *         &lt;element name="arg5" type="{http://admin.client.services.server/}roleDATA" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "securityMethods", propOrder = {
    "arg0",
    "arg1",
    "arg2",
    "arg3",
    "arg4",
    "arg5"
})
public class SecurityMethods {

    protected String arg0;
    protected AccountDATA arg1;
    protected CardDATA arg2;
    protected DeviceDATA arg3;
    protected RightDATA arg4;
    protected RoleDATA arg5;

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
     *     {@link AccountDATA }
     *     
     */
    public AccountDATA getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountDATA }
     *     
     */
    public void setArg1(AccountDATA value) {
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

    /**
     * Gets the value of the arg3 property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceDATA }
     *     
     */
    public DeviceDATA getArg3() {
        return arg3;
    }

    /**
     * Sets the value of the arg3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceDATA }
     *     
     */
    public void setArg3(DeviceDATA value) {
        this.arg3 = value;
    }

    /**
     * Gets the value of the arg4 property.
     * 
     * @return
     *     possible object is
     *     {@link RightDATA }
     *     
     */
    public RightDATA getArg4() {
        return arg4;
    }

    /**
     * Sets the value of the arg4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link RightDATA }
     *     
     */
    public void setArg4(RightDATA value) {
        this.arg4 = value;
    }

    /**
     * Gets the value of the arg5 property.
     * 
     * @return
     *     possible object is
     *     {@link RoleDATA }
     *     
     */
    public RoleDATA getArg5() {
        return arg5;
    }

    /**
     * Sets the value of the arg5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoleDATA }
     *     
     */
    public void setArg5(RoleDATA value) {
        this.arg5 = value;
    }

}
