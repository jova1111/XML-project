package com.otkudznam.booking.controller;

import com.otkudznam.booking.model.User;
import com.otkudznam.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.otkudznam.booking.model.Reservations;
import com.otkudznam.booking.service.ReservationService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ReservationsController {

	@Autowired
	ReservationService reservationService;

	@Autowired
	UserService userService;
	
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
	private ResponseEntity newReservation(@PathVariable("id")Long id, HttpServletRequest request) {
	 	Optional<Reservations> reservation = reservationService.findById(id);
		User user = userService.findByEmail(request.getAttribute("userEmail").toString());
	 	if(!reservation.get().getUser().getId().equals(user.getId())) {
	 		return new ResponseEntity("Not allowed.", HttpStatus.FORBIDDEN);
		}
	 	return new ResponseEntity(reservation.get(), HttpStatus.OK);
	 }

	@RequestMapping(value = "/secure/reservations", method = RequestMethod.GET)
	private ResponseEntity getMyReservations(HttpServletRequest request) {
		User u = userService.findByEmail(request.getAttribute("userEmail").toString());

		List<Reservations> reservations = reservationService.findAll();
		ArrayList<Reservations> temp = new ArrayList<Reservations>();
		for(int i=0; i < reservations.size(); i++){
			if(reservations.get(i).getUser().getId() == u.getId()){
				temp.add(reservations.get(i));
			}
		}
		return new ResponseEntity(temp, HttpStatus.OK);
	}
}
