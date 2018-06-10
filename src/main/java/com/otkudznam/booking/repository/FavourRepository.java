package com.otkudznam.booking.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.otkudznam.booking.model.Favour;

public interface FavourRepository extends PagingAndSortingRepository<Favour, Long>{
	
	List<Favour> findAll();

}
