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
import java.util.Date;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

   /* @RequestMapping(value="/secure/messages/user/received", method = RequestMethod.GET)
    public ResponseEntity getAllReceivedUserMessages(HttpServletRequest request) {
        String email = (String) request.getAttribute("userEmail");
        User user = userService.findByEmail(email);
        List<Message> messages = messageService.findByReceiverIdAndReceivingUserType(user.getId(), UserType.REGULAR);
        return new ResponseEntity(messages, HttpStatus.OK);
    }

    @RequestMapping(value="/secure/messages/user/sent", method = RequestMethod.GET)
    public ResponseEntity getAllSentUserMessages(HttpServletRequest request) {
        String email = (String) request.getAttribute("userEmail");
        User user = userService.findByEmail(email);
        List<Message> messages = messageService.findBySenderIdAndSendingUserType(user.getId(), UserType.REGULAR);
        return new ResponseEntity(messages, HttpStatus.OK);
    }
*/
    /*@RequestMapping(value="/secure/messages/user/{agentId}/send", method = RequestMethod.POST)
    public ResponseEntity sendMessageToAgent(HttpServletRequest request,
                                             @PathVariable("agentId") Long agentId,
                                             @RequestBody Message message) {
        if(message.getContent().isEmpty()) {
            return new ResponseEntity("Message content must not be empty.", HttpStatus.BAD_REQUEST);
        }
        String email = (String) request.getAttribute("userEmail");
        User user = userService.findByEmail(email);
        message.setReceiverId(agentId);
        message.setSenderId(user.getId());
        message.setSendingUserType(UserType.REGULAR);
        message.setReceivingUserType(UserType.AGENT);
        message.setSenderUsername(user.getFullName());
        message.setDateSent(new Date());
        messageService.saveOrUpdate(message);
        return new ResponseEntity(HttpStatus.OK);
    }
*/
}
