package com.otkudznam.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.otkudznam.booking.model.Reservations;
import com.otkudznam.booking.service.ReservationService;

@RestController
public class ReservationsController {

	@Autowired
	ReservationService reservationService;
	
	 @RequestMapping(value="/newReservation", method = RequestMethod.POST)
	    private ResponseEntity newReservation(@RequestBody Reservations reservation) {
	      
	        reservationService.save(reservation);
	        return new ResponseEntity(HttpStatus.OK);
	 }
}
