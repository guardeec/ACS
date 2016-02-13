
package soap.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rightDATA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rightDATA">
 *   &lt;complexContent>
 *     &lt;extension base="{http://admin.client.services.server/}generalParams">
 *       &lt;sequence>
 *         &lt;element name="access" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="deviceId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="deviceSpecification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="systemRoleId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="systemRoleTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rightDATA", propOrder = {
    "access",
    "deviceId",
    "deviceSpecification",
    "systemRoleId",
    "systemRoleTitle"
})
public class RightDATA
    extends GeneralParams
{

    protected Boolean access;
    protected Integer deviceId;
    protected String deviceSpecification;
    protected Integer systemRoleId;
    protected String systemRoleTitle;

    /**
     * Gets the value of the access property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAccess() {
        return access;
    }

    /**
     * Sets the value of the access property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAccess(Boolean value) {
        this.access = value;
    }

    /**
     * Gets the value of the deviceId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * Sets the value of the deviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeviceId(Integer value) {
        this.deviceId = value;
    }

    /**
     * Gets the value of the deviceSpecification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceSpecification() {
        return deviceSpecification;
    }

    /**
     * Sets the value of the deviceSpecification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceSpecification(String value) {
        this.deviceSpecification = value;
    }

    /**
     * Gets the value of the systemRoleId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSystemRoleId() {
        return systemRoleId;
    }

    /**
     * Sets the value of the systemRoleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSystemRoleId(Integer value) {
        this.systemRoleId = value;
    }

    /**
     * Gets the value of the systemRoleTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemRoleTitle() {
        return systemRoleTitle;
    }

    /**
     * Sets the value of the systemRoleTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemRoleTitle(String value) {
        this.systemRoleTitle = value;
    }

}
