
package soap.technical;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deviceDATA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deviceDATA">
 *   &lt;complexContent>
 *     &lt;extension base="{http://admin.client.services.server/}generalParams">
 *       &lt;sequence>
 *         &lt;element name="deviceCondition" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="deviceId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="deviceIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deviceMac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deviceSecription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deviceSpecification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deviceDATA", propOrder = {
    "deviceCondition",
    "deviceId",
    "deviceIp",
    "deviceMac",
    "deviceSecription",
    "deviceSpecification"
})
public class DeviceDATA
    extends GeneralParams
{

    protected Boolean deviceCondition;
    protected Integer deviceId;
    protected String deviceIp;
    protected String deviceMac;
    protected String deviceSecription;
    protected String deviceSpecification;

    /**
     * Gets the value of the deviceCondition property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeviceCondition() {
        return deviceCondition;
    }

    /**
     * Sets the value of the deviceCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeviceCondition(Boolean value) {
        this.deviceCondition = value;
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
     * Gets the value of the deviceIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceIp() {
        return deviceIp;
    }

    /**
     * Sets the value of the deviceIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceIp(String value) {
        this.deviceIp = value;
    }

    /**
     * Gets the value of the deviceMac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceMac() {
        return deviceMac;
    }

    /**
     * Sets the value of the deviceMac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceMac(String value) {
        this.deviceMac = value;
    }

    /**
     * Gets the value of the deviceSecription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceSecription() {
        return deviceSecription;
    }

    /**
     * Sets the value of the deviceSecription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceSecription(String value) {
        this.deviceSecription = value;
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

}
