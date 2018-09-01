package com.otkudznam.booking.service;

import com.otkudznam.booking.model.Message;
import com.otkudznam.booking.model.UserType;

import java.util.List;

public interface MessageService {
    List<Message> findByReceiverIdAndReceivingUserType(Long receiverId, UserType receivingUserType);
    Message saveOrUpdate(Message message);
}
