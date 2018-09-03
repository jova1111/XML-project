package com.otkudznam.booking.repository;

import java.util.List;
import java.util.Optional;

import com.otkudznam.booking.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.otkudznam.booking.model.Comment;
import com.otkudznam.booking.model.Lodging;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

	List<Comment> findAll();
	List<Comment> findByApproved(boolean approved);
	Optional<Comment> findById(Long id);
	List<Comment> findByLodging(Lodging lodging);
	Comment findByPublisherAndLodging(User publisher, Lodging lodging);
}
