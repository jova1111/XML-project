package com.otkudznam.booking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.otkudznam.booking.model.Comment;
import com.otkudznam.booking.model.Lodging;
import com.otkudznam.booking.model.User;
import com.otkudznam.booking.service.CommentService;
import com.otkudznam.booking.service.LodgingService;
import com.otkudznam.booking.service.UserService;

@Controller
public class CommentController {
    @Autowired
    private LodgingService lodgingService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/secure/check_user_rating/{lodging_id}", method = RequestMethod.GET)
    public ResponseEntity checkIfUserRatedLodging(@PathVariable("lodging_id")Long lodgingId, HttpServletRequest request) {
        Optional<Lodging> lodging = lodgingService.findById(lodgingId);
        User publisher = userService.findByEmail((String) request.getAttribute("userEmail"));
        if(publisher == null || !lodging.isPresent()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Comment comment = commentService.findByPublisherAndLodging(publisher, lodging.get());
        if(comment != null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/comments/{lodging_id}", method = RequestMethod.GET)
	public ResponseEntity getComments(@PathVariable("lodging_id") Long lodgingId) {

		List<Comment> comments = commentService.findAll();
		ArrayList<Comment> temp = new ArrayList<Comment>();
		for (Comment com : comments) {
			if (com.getLodging().getId() == lodgingId) {
				temp.add(com);
			}

		}

		return new ResponseEntity(temp, HttpStatus.OK);
	}
}
