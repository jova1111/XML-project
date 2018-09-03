package com.otkudznam.booking.service;

import com.otkudznam.booking.model.Message;
import com.otkudznam.booking.model.UserType;

import java.util.List;

public interface MessageService {
    Message saveOrUpdate(Message message);
    List<Message> getByReciverId(String reciverId);
    List<Message> getBySenderId(String senderId);
}
