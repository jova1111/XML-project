package com.otkudznam.booking.endpoints;



import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.addressing.server.annotation.Action;

import com.otkudznam.booking.model.GetLodgingRequest;
import com.otkudznam.booking.model.GetLodgingResponse;
import com.otkudznam.booking.model.ImageUrl;
import com.otkudznam.booking.model.Lodging;
import com.otkudznam.booking.model.Period;
import com.otkudznam.booking.model.Reservations;
import com.otkudznam.booking.model.SetPeriodRequest;
import com.otkudznam.booking.model.SetReservation;
import com.otkudznam.booking.repository.AgentRepository;
import com.otkudznam.booking.repository.CategoryRepository;
import com.otkudznam.booking.repository.FavourRepository;
import com.otkudznam.booking.repository.ImageUriRepository;
import com.otkudznam.booking.repository.LodgingRepository;
import com.otkudznam.booking.repository.LodgingTypeRepository;
import com.otkudznam.booking.repository.PeriodRepository;
import com.otkudznam.booking.repository.ReservationRepository;
import com.otkudznam.booking.repository.UserRepository;


@Endpoint
public class LodgingEndpoint {
	private static final String NAMESPACE_URI = "http://www.otkudznam.com/booking/model";

	private LodgingRepository lodgingRepository;
	private AgentRepository agentRepository;
	private CategoryRepository categoryRepository;
	private FavourRepository favourRepository;
	private UserRepository userRepository;
	private LodgingTypeRepository lodgingTypeRepository;
	private ImageUriRepository imageUrlRepository;
	private PeriodRepository periodRepsoitory;
	private ReservationRepository reservationRepository;
	@Autowired
	public LodgingEndpoint(LodgingRepository lodgingRepository,AgentRepository agentRepository,
			CategoryRepository categoryRepository,FavourRepository favourRepository,
			UserRepository userRepository,LodgingTypeRepository lodgingTypeRepository,
			ImageUriRepository imageUrlRepository, PeriodRepository periodRepository,
			ReservationRepository reservationRepository) {
		this.lodgingRepository = lodgingRepository;
		this.agentRepository = agentRepository;
		this.categoryRepository = categoryRepository;
		this.favourRepository = favourRepository;
		this.userRepository = userRepository;
		this.lodgingTypeRepository = lodgingTypeRepository;
		this.imageUrlRepository = imageUrlRepository;
		this.periodRepsoitory = periodRepository;
		this.reservationRepository = reservationRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLodgingRequest")
	@ResponsePayload
	@Action("http://www.booking.com/sys/getLodgingRequest")
	public GetLodgingResponse getLodging(@RequestPayload GetLodgingRequest request) {
	/*	System.out.println("Obradjuje se");
		GetLodgingResponse response = new GetLodgingResponse();
		response.setLodgings(lodgingRepository.findAll());
		response.setAgents(agentRepository.findAll());
		response.setCategories(categoryRepository.findAll());
		response.setLodgingTypes(lodgingTypeRepository.findAll());
		response.setUsers(userRepository.findAll());
		response.setImageUris(imageUrlRepository.findAll());
		response.setFavours(favourRepository.findAll());
		return response;
		*/
		System.out.println("Obradjuje se cuvanje");
		GetLodgingResponse response = new GetLodgingResponse();
		imageUrlRepository.saveAll(request.getLodging().getImageUrls());
		//lodgingRepository.save(request.getLodging());
		System.out.println("Periodi:" + request.getLodging().getPeriods());
		ArrayList<Period> periods = Lists.newArrayList(periodRepsoitory.saveAll(request.getLodging().getPeriods()));
		ArrayList<ImageUrl> images = Lists.newArrayList(imageUrlRepository.saveAll(request.getLodging().getImageUrls()));
		Lodging l = request.getLodging();
		l.setPeriods(periods);
		l.setImageUrls(images);
		lodgingRepository.save(l);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveLodging")
	@ResponsePayload
	@Action("http://www.booking.com/sys/saveLodging")
	public GetLodgingResponse saveLodging(@RequestPayload GetLodgingRequest request) {
		System.out.println("Obradjuje se cuvanje");
		GetLodgingResponse response = new GetLodgingResponse();
		//imageUrlRepository.saveAll(request.getLodging().getImageUrls());
		System.out.println("Periodi:" + request.getLodging().getPeriods());
		periodRepsoitory.saveAll(request.getLodging().getPeriods());
		//lodgingRepository.save(request.getLodging());
		
		return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "setPeriodRequest")
	@ResponsePayload
	@Action("http://www.booking.com/sys/updatePeriod")
	public void updatePeriod(@RequestPayload SetPeriodRequest request) {
		//Period period = periodRepsoitory.findPeriod(request.getPeriod());
		System.out.println("IDEMOOOO");
		//ArrayList<Period> periods = Lists.newArrayList(periodRepsoitory.findAll());
		Period period = new Period();
		Period tempPeriod = request.getPeriod();
		Lodging lodging = lodgingRepository.findDate(request.getLodgingName());
		for(Period p : lodging.getPeriods()){
			if(p.getDateFrom().compareTo(tempPeriod.getDateFrom())==0 && p.getDateTo().compareTo(tempPeriod.getDateTo())==0){
				System.out.println("Ima taki");
				period = p;
				break;
			}
		}
		period.setReserved(true);
		periodRepsoitory.save(period);
		
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "setReservation")
	@ResponsePayload
	@Action("http://www.booking.com/sys/updateReservation")
	public void updateReservation(@RequestPayload SetReservation request) {
		Lodging lodging = lodgingRepository.findDate(request.getLodgingName());
		Reservations reservation = request.getReservation();
		Reservations tempReservation = new Reservations();
		List<Reservations> reservations = reservationRepository.findAll();
		System.out.println(reservations);
		for(Reservations r : reservations){
			Period p = r.getPeriod();
			if(p.getDateFrom().compareTo(reservation.getPeriod().getDateFrom())==0 && p.getDateTo().compareTo(reservation.getPeriod().getDateTo())==0 && reservation.getLodging().getName().equals(r.getLodging().getName())){
				System.out.println("Ima taki");
				tempReservation = r;
				break;
			}
		}
		
		tempReservation.setActivated(true);
		reservationRepository.save(tempReservation);
	}
}


