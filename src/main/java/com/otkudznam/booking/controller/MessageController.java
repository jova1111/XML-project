package com.otkudznam.booking.controller;

import com.otkudznam.booking.model.Message;
import com.otkudznam.booking.model.User;
import com.otkudznam.booking.model.UserType;
import com.otkudznam.booking.service.MessageService;
import com.otkudznam.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/secure/messages/user", method = RequestMethod.GET)
    public ResponseEntity getAllUserMessages(HttpServletRequest request) {
        String email = (String) request.getAttribute("userEmail");
        User user = userService.findByEmail(email);
        List<Message> messages = messageService.findByReceiverIdAndReceivingUserType(user.getId(), UserType.REGULAR);
        return new ResponseEntity(messages, HttpStatus.OK);
    }

    @RequestMapping(value="/secure/messages/user/{agentId}/send", method = RequestMethod.POST)
    public ResponseEntity sendMessageToAgent(HttpServletRequest request,
                                             @PathVariable("agentId") Long agentId,
                                             @RequestBody Message message) {
        String email = (String) request.getAttribute("userEmail");
        User user = userService.findByEmail(email);
        message.setReceiverId(agentId);
        message.setSenderId(user.getId());
        message.setReceivingUserType(UserType.AGENT);
        message.setSenderUsername(user.getFullName());
        messageService.saveOrUpdate(message);
        return new ResponseEntity(HttpStatus.OK);
    }

}
