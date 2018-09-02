package com.otkudznam.booking.service;

import com.otkudznam.booking.model.Message;
import com.otkudznam.booking.model.UserType;
import com.otkudznam.booking.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImp implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> findByReceiverIdAndReceivingUserType(Long receiverId, UserType receivingUserType) {
        return messageRepository.findByReceiverIdAndReceivingUserType(receiverId, receivingUserType);
    }

    @Override
    public List<Message> findBySenderIdAndSendingUserType(Long senderId, UserType sendingUserType) {
        return messageRepository.findBySenderIdAndSendingUserType(senderId, sendingUserType);
    }

    @Override
    public Message saveOrUpdate(Message message) {
        return messageRepository.save(message);
    }
}
