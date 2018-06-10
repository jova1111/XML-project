package com.otkudznam.booking.service;

import java.util.List;

import com.otkudznam.booking.model.LodgingType;

public interface LodgingTypeService {

	List<LodgingType> findAll();
	void saveOrUpdate(LodgingType lodgingType);
	void delete(LodgingType lodgingType);
}
