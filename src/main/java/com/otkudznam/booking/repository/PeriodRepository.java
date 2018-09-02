package com.otkudznam.booking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.otkudznam.booking.model.Period;



@Repository
public interface PeriodRepository extends PagingAndSortingRepository<Period,Long> {
	
	

}
