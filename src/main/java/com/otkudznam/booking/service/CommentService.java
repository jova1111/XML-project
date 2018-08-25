package com.otkudznam.booking.service;

import java.util.List;
import java.util.Optional;


import com.otkudznam.booking.model.Comment;

public interface CommentService {

	void saveOrUpdate(Comment comment);
	List<Comment> findAll();
	List<Comment> findByApproved(boolean approved);
	Optional<Comment> findById(Long id);
}
