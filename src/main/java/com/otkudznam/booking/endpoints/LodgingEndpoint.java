package com.otkudznam.booking.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.otkudznam.booking.model.GetLodgingRequest;
import com.otkudznam.booking.model.GetLodgingResponse;
import com.otkudznam.booking.repository.LodgingRepository;
@Endpoint
public class LodgingEndpoint {
	private static final String NAMESPACE_URI = "http://www.booking.com/sys";

	private LodgingRepository lodgingRepository;

	@Autowired
	public LodgingEndpoint(LodgingRepository lodgingRepository) {
		this.lodgingRepository = lodgingRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLodgingRequest")
	@ResponsePayload
	public GetLodgingResponse getLodging(@RequestPayload GetLodgingRequest request) {
		System.out.println("Obradjuje se");
		GetLodgingResponse response = new GetLodgingResponse();
		response.setLodgings(lodgingRepository.findAll());

		return response;
	}
}
