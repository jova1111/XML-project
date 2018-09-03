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
    public Message saveOrUpdate(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getByReciverId(String reciverId) {
        return messageRepository.getByReciverId(reciverId);
    }

    @Override
    public List<Message> getBySenderId(String senderId) {
        return messageRepository.getBySenderId(senderId);
    }
}
