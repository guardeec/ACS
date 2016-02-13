
package soap.hr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for employeeDATA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="employeeDATA">
 *   &lt;complexContent>
 *     &lt;extension base="{http://admin.client.services.server/}generalParams">
 *       &lt;sequence>
 *         &lt;element name="cardId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="employeeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="employeeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="employeeStateDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="employeeStateId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "employeeDATA", propOrder = {
    "cardId",
    "employeeId",
    "employeeName",
    "employeeStateDescription",
    "employeeStateId",
    "systemRoleId",
    "systemRoleTitle"
})
public class EmployeeDATA
    extends GeneralParams
{

    protected Integer cardId;
    protected Integer employeeId;
    protected String employeeName;
    protected String employeeStateDescription;
    protected Integer employeeStateId;
    protected Integer systemRoleId;
    protected String systemRoleTitle;

    /**
     * Gets the value of the cardId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCardId() {
        return cardId;
    }

    /**
     * Sets the value of the cardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCardId(Integer value) {
        this.cardId = value;
    }

    /**
     * Gets the value of the employeeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the value of the employeeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEmployeeId(Integer value) {
        this.employeeId = value;
    }

    /**
     * Gets the value of the employeeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Sets the value of the employeeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeName(String value) {
        this.employeeName = value;
    }

    /**
     * Gets the value of the employeeStateDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeStateDescription() {
        return employeeStateDescription;
    }

    /**
     * Sets the value of the employeeStateDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeStateDescription(String value) {
        this.employeeStateDescription = value;
    }

    /**
     * Gets the value of the employeeStateId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEmployeeStateId() {
        return employeeStateId;
    }

    /**
     * Sets the value of the employeeStateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEmployeeStateId(Integer value) {
        this.employeeStateId = value;
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
