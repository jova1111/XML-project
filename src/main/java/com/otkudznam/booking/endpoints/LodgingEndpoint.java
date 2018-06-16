package com.otkudznam.booking.endpoints;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.otkudznam.booking.model.GetLodgingRequest;
import com.otkudznam.booking.model.GetLodgingResponse;
import com.otkudznam.booking.repository.AgentRepository;
import com.otkudznam.booking.repository.CategoryRepository;
import com.otkudznam.booking.repository.FavourRepository;
import com.otkudznam.booking.repository.ImageUriRepository;
import com.otkudznam.booking.repository.LodgingRepository;
import com.otkudznam.booking.repository.LodgingTypeRepository;
import com.otkudznam.booking.repository.UserRepository;



//import com.otkudznam.booking.model.GetLodgingRequest;
//import com.otkudznam.booking.model.GetLodgingResponse;
//import com.otkudznam.booking.repositroy.LodgingRepository;

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
	
	@Autowired
	public LodgingEndpoint(LodgingRepository lodgingRepository,AgentRepository agentRepository,
			CategoryRepository categoryRepository,FavourRepository favourRepository,
			UserRepository userRepository,LodgingTypeRepository lodgingTypeRepository,
			ImageUriRepository imageUrlRepository) {
		this.lodgingRepository = lodgingRepository;
		this.agentRepository = agentRepository;
		this.categoryRepository = categoryRepository;
		this.favourRepository = favourRepository;
		this.userRepository = userRepository;
		this.lodgingTypeRepository = lodgingTypeRepository;
		this.imageUrlRepository = imageUrlRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLodgingRequest")
	@ResponsePayload
 //@Action("http://www.booking.com/sys/getLodgingRequest")
	public GetLodgingResponse getLodging(@RequestPayload GetLodgingRequest request) {
		System.out.println("Obradjuje se");
		GetLodgingResponse response = new GetLodgingResponse();
		response.setLodgings(lodgingRepository.findAll());
		response.setAgents(agentRepository.findAll());
		response.setCategories(categoryRepository.findAll());
		response.setLodgingTypes(lodgingTypeRepository.findAll());
		response.setUsers(userRepository.findAll());
		response.setImageUris(imageUrlRepository.findAll());
		response.setFavours(favourRepository.findAll());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveLodging")
	@ResponsePayload
 
	public GetLodgingResponse saveLodging(@RequestPayload GetLodgingRequest request) {
		System.out.println("Obradjuje se");
		GetLodgingResponse response = new GetLodgingResponse();
		imageUrlRepository.saveAll(request.getLodging().getImageUrls());
		lodgingRepository.save(request.getLodging());
		return response;
	}
}


