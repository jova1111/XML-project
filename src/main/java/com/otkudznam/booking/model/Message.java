package com.otkudznam.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @XmlAttribute(name = "id")
    protected Long id;

    @XmlAttribute(name = "reservation")
    @ManyToOne
    protected Reservations reservation;

    @XmlAttribute(name = "sender_id")
    protected Long senderId;

    @XmlAttribute(name = "receiver_id")
    protected Long receiverId;

    @XmlAttribute(name = "sender_username")
    protected String senderUsername;  // username korisnika koji salje poruku agentu

    @XmlAttribute(name = "receiving_user_type")
    protected UserType receivingUserType;

    @XmlAttribute(name = "sending_user_type")
    protected UserType sendingUserType;

    @XmlAttribute(name = "content")
    protected String content;

    @XmlAttribute(name = "seen")
    protected Boolean seen;

    @XmlAttribute(name = "date_sent")
    protected Date dateSent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reservations getReservation() {
        return reservation;
    }

    public void setReservation(Reservations reservation) {
        this.reservation = reservation;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public UserType getReceivingUserType() {
        return receivingUserType;
    }

    public void setReceivingUserType(UserType receivingUserType) {
        this.receivingUserType = receivingUserType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public UserType getSendingUserType() {
        return sendingUserType;
    }

    public void setSendingUserType(UserType sendingUserType) {
        this.sendingUserType = sendingUserType;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }
}

