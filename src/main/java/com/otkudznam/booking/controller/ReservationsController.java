package com.otkudznam.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.otkudznam.booking.model.Reservations;
import com.otkudznam.booking.service.ReservationService;

import java.util.Optional;

@RestController
public class ReservationsController {

	@Autowired
	ReservationService reservationService;
	
	 @RequestMapping(value="/newReservation", method = RequestMethod.POST)
	    private ResponseEntity newReservation(@RequestBody Reservations reservation) {
	      
	        reservationService.save(reservation);
	        return new ResponseEntity(HttpStatus.OK);
	 }
	 /*
	 @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
	    private ResponseEntity getById(@PathVariable("id")Long id) {
	        List<Reservations> reservations = reservationService.findAll();
	        for(int i=0; i < reservations.size(); i++){
	        	if(reservations.get(i).getUser().getId() == id){
	        		
	        	}
	        }
	        return new ResponseEntity(reservations, HttpStatus.OK);
	    }
	    */
 	@RequestMapping(value="/secure/reservations/{id}", method = RequestMethod.GET)
	private ResponseEntity newReservation(@PathVariable("id")Long id) {
	 	Optional<Reservations> reservation = reservationService.findById(id);
	 	return new ResponseEntity(reservation.get(), HttpStatus.OK);
	 }
}
