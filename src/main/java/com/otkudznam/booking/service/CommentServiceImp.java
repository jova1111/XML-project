package com.otkudznam.booking.service;

import java.util.List;
import java.util.Optional;

import com.otkudznam.booking.model.Lodging;
import com.otkudznam.booking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otkudznam.booking.model.Comment;
import com.otkudznam.booking.repository.CommentRepository;

@Service
public class CommentServiceImp implements CommentService{

	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public List<Comment> findAll() {
		// TODO Auto-generated method stub
		return commentRepository.findAll();
	}

	@Override
	public List<Comment> findByApproved(boolean approved) {
		// TODO Auto-generated method stub
		return commentRepository.findByApproved(approved);
	}

	@Override
	public void saveOrUpdate(Comment comment) {
		// TODO Auto-generated method stub
		commentRepository.save(comment);
	}

	@Override
	public Optional<Comment> findById(Long id) {
		// TODO Auto-generated method stub
		return commentRepository.findById(id);
	}

	@Override
	public Comment findByPublisherAndLodging(User publisher, Lodging lodging) {
		return commentRepository.findByPublisherAndLodging(publisher, lodging);
	}

}
