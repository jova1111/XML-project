//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.09.04 at 05:18:36 AM CEST 
//


package com.booking.sys;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="period" type="{http://www.booking.com/sys}Period"/>
 *         &lt;element name="lodgingName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "period",
    "lodgingName"
})
@XmlRootElement(name = "setPeriodRequest")
public class SetPeriodRequest {

    @XmlElement(required = true)
    protected Period period;
    @XmlElement(required = true)
    protected String lodgingName;

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
     * Gets the value of the lodgingName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLodgingName() {
        return lodgingName;
    }

    /**
     * Sets the value of the lodgingName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLodgingName(String value) {
        this.lodgingName = value;
    }

}
