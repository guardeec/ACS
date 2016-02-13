
package soap.security;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for generalParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="generalParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="generalDatetime" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="generalDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="generalEventTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="generalResultType" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="sourceClientAccountId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="sourceClientAccountLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceDeviceId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="sourceIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceMac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generalParams", propOrder = {
    "generalDatetime",
    "generalDescription",
    "generalEventTypeId",
    "generalResultType",
    "sourceClientAccountId",
    "sourceClientAccountLogin",
    "sourceDeviceId",
    "sourceIp",
    "sourceMac",
    "sourceTypeId"
})
@XmlSeeAlso({
    CardDATA.class,
    RoleDATA.class,
    DeviceDATA.class,
    RightDATA.class,
    AccountDATA.class
})
public abstract class GeneralParams {

    protected Long generalDatetime;
    protected String generalDescription;
    protected Integer generalEventTypeId;
    protected Boolean generalResultType;
    protected Integer sourceClientAccountId;
    protected String sourceClientAccountLogin;
    protected Integer sourceDeviceId;
    protected String sourceIp;
    protected String sourceMac;
    protected Integer sourceTypeId;

    /**
     * Gets the value of the generalDatetime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGeneralDatetime() {
        return generalDatetime;
    }

    /**
     * Sets the value of the generalDatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGeneralDatetime(Long value) {
        this.generalDatetime = value;
    }

    /**
     * Gets the value of the generalDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneralDescription() {
        return generalDescription;
    }

    /**
     * Sets the value of the generalDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneralDescription(String value) {
        this.generalDescription = value;
    }

    /**
     * Gets the value of the generalEventTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGeneralEventTypeId() {
        return generalEventTypeId;
    }

    /**
     * Sets the value of the generalEventTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGeneralEventTypeId(Integer value) {
        this.generalEventTypeId = value;
    }

    /**
     * Gets the value of the generalResultType property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGeneralResultType() {
        return generalResultType;
    }

    /**
     * Sets the value of the generalResultType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGeneralResultType(Boolean value) {
        this.generalResultType = value;
    }

    /**
     * Gets the value of the sourceClientAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSourceClientAccountId() {
        return sourceClientAccountId;
    }

    /**
     * Sets the value of the sourceClientAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSourceClientAccountId(Integer value) {
        this.sourceClientAccountId = value;
    }

    /**
     * Gets the value of the sourceClientAccountLogin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceClientAccountLogin() {
        return sourceClientAccountLogin;
    }

    /**
     * Sets the value of the sourceClientAccountLogin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceClientAccountLogin(String value) {
        this.sourceClientAccountLogin = value;
    }

    /**
     * Gets the value of the sourceDeviceId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSourceDeviceId() {
        return sourceDeviceId;
    }

    /**
     * Sets the value of the sourceDeviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSourceDeviceId(Integer value) {
        this.sourceDeviceId = value;
    }

    /**
     * Gets the value of the sourceIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceIp() {
        return sourceIp;
    }

    /**
     * Sets the value of the sourceIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceIp(String value) {
        this.sourceIp = value;
    }

    /**
     * Gets the value of the sourceMac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceMac() {
        return sourceMac;
    }

    /**
     * Sets the value of the sourceMac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceMac(String value) {
        this.sourceMac = value;
    }

    /**
     * Gets the value of the sourceTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSourceTypeId() {
        return sourceTypeId;
    }

    /**
     * Sets the value of the sourceTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSourceTypeId(Integer value) {
        this.sourceTypeId = value;
    }

}
