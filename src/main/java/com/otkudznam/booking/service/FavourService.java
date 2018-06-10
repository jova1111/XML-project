package com.otkudznam.booking.service;

import java.util.List;

import com.otkudznam.booking.model.Favour;

public interface FavourService {

	List<Favour> findAll();
	void saveOrUpdate(Favour lodgingType);
	void delete(Favour lodgingType);
	
}
