package com.otkudznam.booking.service;

import java.util.List;
import java.util.Optional;

import com.otkudznam.booking.model.Reservations;

public interface ReservationService {
		List<Reservations> findAll();
	    Optional<Reservations> findById(Long id);
	    Reservations save(Reservations reservation);
}
