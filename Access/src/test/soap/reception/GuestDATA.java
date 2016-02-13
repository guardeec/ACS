
package soap.reception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for guestDATA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="guestDATA">
 *   &lt;complexContent>
 *     &lt;extension base="{http://admin.client.services.server/}generalParams">
 *       &lt;sequence>
 *         &lt;element name="cardId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="guestId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="guestName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeEnd" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="timeStart" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guestDATA", propOrder = {
    "cardId",
    "guestId",
    "guestName",
    "timeEnd",
    "timeStart"
})
public class GuestDATA
    extends GeneralParams
{

    protected Integer cardId;
    protected Integer guestId;
    protected String guestName;
    protected Long timeEnd;
    protected Long timeStart;

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
     * Gets the value of the guestId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGuestId() {
        return guestId;
    }

    /**
     * Sets the value of the guestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGuestId(Integer value) {
        this.guestId = value;
    }

    /**
     * Gets the value of the guestName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * Sets the value of the guestName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestName(String value) {
        this.guestName = value;
    }

    /**
     * Gets the value of the timeEnd property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTimeEnd() {
        return timeEnd;
    }

    /**
     * Sets the value of the timeEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTimeEnd(Long value) {
        this.timeEnd = value;
    }

    /**
     * Gets the value of the timeStart property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTimeStart() {
        return timeStart;
    }

    /**
     * Sets the value of the timeStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTimeStart(Long value) {
        this.timeStart = value;
    }

}
