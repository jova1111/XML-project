//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2018.09.03 at 05:38:43 PM CEST
//


package com.otkudznam.booking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Message complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Message">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reservation" type="{http://www.booking.com/sys}Reservations"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="senderId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="reciverId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="content" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dateSent" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Message", propOrder = {
    "reservation"
})
@Entity
public class Message {

    @XmlElement(required = true)
    @ManyToOne
    protected Reservations reservation;
    @XmlAttribute(name = "id")
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)

    protected Long id;
    @XmlAttribute(name = "senderId")
    protected String senderId;
    @XmlAttribute(name = "reciverId")
    protected String reciverId;
    @XmlAttribute(name = "content")
    protected String content;
    @XmlAttribute(name = "dateSent")
    @XmlSchemaType(name = "date")
    protected Date dateSent;

    /**
     * Gets the value of the reservation property.
     *
     * @return
     *     possible object is
     *     {@link Reservations }
     *
     */
    public Reservations getReservation() {
        return reservation;
    }

    /**
     * Sets the value of the reservation property.
     *
     * @param value
     *     allowed object is
     *     {@link Reservations }
     *
     */
    public void setReservation(Reservations value) {
        this.reservation = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the senderId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSenderId() {
        return senderId;
    }

    /**
     * Sets the value of the senderId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSenderId(String value) {
        this.senderId = value;
    }

    /**
     * Gets the value of the reciverId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReciverId() {
        return reciverId;
    }

    /**
     * Sets the value of the reciverId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReciverId(String value) {
        this.reciverId = value;
    }

    /**
     * Gets the value of the content property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    /**
     * Gets the value of the content property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the dateSent property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public Date getDateSent() {
        return dateSent;
    }

    /**
     * Sets the value of the dateSent property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDateSent(Date value) {
        this.dateSent = value;
    }
}
