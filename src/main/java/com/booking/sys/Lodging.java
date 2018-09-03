//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.09.03 at 06:43:24 PM CEST 
//


package com.booking.sys;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Lodging complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Lodging">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="imageUrls" type="{http://www.booking.com/sys}ImageUrl" maxOccurs="unbounded"/>
 *         &lt;element name="lodgingType" type="{http://www.booking.com/sys}LodgingType"/>
 *         &lt;element name="category" type="{http://www.booking.com/sys}Category"/>
 *         &lt;element name="agent" type="{http://www.booking.com/sys}Agent"/>
 *         &lt;element name="comments" type="{http://www.booking.com/sys}Comment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="favours" type="{http://www.booking.com/sys}Favour" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="periods" type="{http://www.booking.com/sys}Period" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="guestNumber" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="price" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="rating" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="occupancy" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Lodging", propOrder = {
    "imageUrls",
    "lodgingType",
    "category",
    "agent",
    "comments",
    "favours",
    "location",
    "periods"
})
public class Lodging {

    @XmlElement(required = true)
    protected List<ImageUrl> imageUrls;
    @XmlElement(required = true)
    protected LodgingType lodgingType;
    @XmlElement(required = true)
    protected Category category;
    @XmlElement(required = true)
    protected Agent agent;
    protected List<Comment> comments;
    protected List<Favour> favours;
    @XmlElement(required = true)
    protected String location;
    @XmlElement(required = true)
    protected List<Period> periods;
    @XmlAttribute(name = "guestNumber")
    protected Integer guestNumber;
    @XmlAttribute(name = "price")
    protected Double price;
    @XmlAttribute(name = "rating")
    protected Double rating;
    @XmlAttribute(name = "occupancy")
    protected Boolean occupancy;
    @XmlAttribute(name = "id")
    protected Long id;
    @XmlAttribute(name = "description")
    protected String description;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the value of the imageUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the imageUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImageUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImageUrl }
     * 
     * 
     */
    public List<ImageUrl> getImageUrls() {
        if (imageUrls == null) {
            imageUrls = new ArrayList<ImageUrl>();
        }
        return this.imageUrls;
    }

    /**
     * Gets the value of the lodgingType property.
     * 
     * @return
     *     possible object is
     *     {@link LodgingType }
     *     
     */
    public LodgingType getLodgingType() {
        return lodgingType;
    }

    /**
     * Sets the value of the lodgingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LodgingType }
     *     
     */
    public void setLodgingType(LodgingType value) {
        this.lodgingType = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link Category }
     *     
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link Category }
     *     
     */
    public void setCategory(Category value) {
        this.category = value;
    }

    /**
     * Gets the value of the agent property.
     * 
     * @return
     *     possible object is
     *     {@link Agent }
     *     
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * Sets the value of the agent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Agent }
     *     
     */
    public void setAgent(Agent value) {
        this.agent = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Comment }
     * 
     * 
     */
    public List<Comment> getComments() {
        if (comments == null) {
            comments = new ArrayList<Comment>();
        }
        return this.comments;
    }

    /**
     * Gets the value of the favours property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the favours property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFavours().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Favour }
     * 
     * 
     */
    public List<Favour> getFavours() {
        if (favours == null) {
            favours = new ArrayList<Favour>();
        }
        return this.favours;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the periods property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the periods property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeriods().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Period }
     * 
     * 
     */
    public List<Period> getPeriods() {
        if (periods == null) {
            periods = new ArrayList<Period>();
        }
        return this.periods;
    }

    /**
     * Gets the value of the guestNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGuestNumber() {
        return guestNumber;
    }

    /**
     * Sets the value of the guestNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGuestNumber(Integer value) {
        this.guestNumber = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPrice(Double value) {
        this.price = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRating(Double value) {
        this.rating = value;
    }

    /**
     * Gets the value of the occupancy property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOccupancy() {
        return occupancy;
    }

    /**
     * Sets the value of the occupancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOccupancy(Boolean value) {
        this.occupancy = value;
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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
