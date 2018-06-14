package com.otkudznam.booking.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.otkudznam.booking.model.Lodging;

public interface LodgingRepository extends PagingAndSortingRepository<Lodging,Long> {
	
	List<Lodging> findAll();
}
