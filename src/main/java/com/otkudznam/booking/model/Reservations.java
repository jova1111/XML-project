//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.09.02 at 08:18:16 PM CEST 
//


package com.otkudznam.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Reservations complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Reservations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lodging" type="{http://www.booking.com/sys}Lodging"/>
 *         &lt;element name="user" type="{http://www.booking.com/sys}User"/>
 *         &lt;element name="period" type="{http://www.booking.com/sys}Period"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Activated" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reservations", propOrder = {
    "lodging",
    "user",
    "period"
})
@Entity
public class Reservations {
	@XmlAttribute(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
    @XmlElement(required = true)
    @ManyToOne
    protected Lodging lodging;
    @XmlElement(required = true)
    @ManyToOne
    protected User user;
    @XmlElement(required = true)
    @OneToOne
    protected Period period;
    @XmlAttribute(name = "Activated")
    protected Boolean activated;

    /**
     * Gets the value of the lodging property.
     * 
     * @return
     *     possible object is
     *     {@link Lodging }
     *     
     */
    public Lodging getLodging() {
        return lodging;
    }

    /**
     * Sets the value of the lodging property.
     * 
     * @param value
     *     allowed object is
     *     {@link Lodging }
     *     
     */
    public void setLodging(Lodging value) {
        this.lodging = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link Period }
     *     
     */
    public Period getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link Period }
     *     
     */
    public void setPeriod(Period value) {
        this.period = value;
    }

    /**
     * Gets the value of the activated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActivated() {
        return activated;
    }

    /**
     * Sets the value of the activated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActivated(Boolean value) {
        this.activated = value;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActivated() {
		return activated;
	}

    
}
