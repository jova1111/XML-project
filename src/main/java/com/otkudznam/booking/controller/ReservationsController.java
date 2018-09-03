package com.otkudznam.booking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.otkudznam.booking.model.Reservations;
import com.otkudznam.booking.model.User;
import com.otkudznam.booking.service.PeriodService;
import com.otkudznam.booking.service.ReservationService;
import com.otkudznam.booking.service.UserService;

@RestController
public class ReservationsController {

	@Autowired
	ReservationService reservationService;

	@Autowired
	UserService userService;
	
	@Autowired
	PeriodService periodService;

 	@RequestMapping(value="/secure/reservations/{id}", method = RequestMethod.GET)
	private ResponseEntity newReservation(@PathVariable("id")Long id, HttpServletRequest request) {
	 	Optional<Reservations> reservation = reservationService.findById(id);
		User user = userService.findByEmail(request.getAttribute("userEmail").toString());
	 	if(!reservation.get().getUser().getEmail().equals(user.getEmail())) {
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
			if(reservations.get(i).getUser().getEmail() == u.getEmail()){
				temp.add(reservations.get(i));
			}
		}
		return new ResponseEntity(temp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delreservation/{id}", method = RequestMethod.DELETE)
	private ResponseEntity deleteReservations(@PathVariable("id")Long id) {
		Reservations reservation =reservationService.findById(id).get();
		reservation.getPeriod().setReserved(false);
		periodService.save(reservation.getPeriod());
		reservationService.delete(reservation);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value ="/newreservation", method = RequestMethod.POST)
	private ResponseEntity newReserv(@RequestBody Reservations reservation) {
	 	System.out.println("UNISO");
	 	reservation.getPeriod().setReserved(true);
	 	periodService.save(reservation.getPeriod());
	 	
        reservationService.save(reservation);
        return new ResponseEntity(HttpStatus.OK);
	}
}