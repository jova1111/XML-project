package com.otkudznam.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otkudznam.booking.model.Reservations;
import com.otkudznam.booking.repository.ReservationRepository;

@Service
public class ReservationServiceImp implements ReservationService {
   
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
    public List<Reservations> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservations> findById(Long id) {
        return reservationRepository.findById(id);
    }

	@Override
	public Reservations save(Reservations reservation) {
		// TODO Auto-generated method stub
		return reservationRepository.save(reservation);
	}
}
