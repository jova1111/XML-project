package com.otkudznam.booking.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.otkudznam.booking.model.LodgingType;

@Repository
public interface LodgingTypeRepository extends PagingAndSortingRepository<LodgingType, Long>{

	List<LodgingType> findAll();
	
}