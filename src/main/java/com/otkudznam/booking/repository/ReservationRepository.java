package com.otkudznam.booking.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.otkudznam.booking.model.Lodging;
import com.otkudznam.booking.model.Reservations;

@Repository
public interface ReservationRepository  extends PagingAndSortingRepository<Reservations, Long>{
		List<Reservations> findAll();
	    Optional<Reservations> findById(Long id);
		List<Reservations> findByLodging(Lodging lodging);
}
