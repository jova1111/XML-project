package com.otkudznam.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otkudznam.booking.model.LodgingType;
import com.otkudznam.booking.repository.LodgingTypeRepository;

@Service
public class LodgingTypeServiceImp implements LodgingTypeService{

	@Autowired
    private LodgingTypeRepository lodgingTepeRepository;
	
	 @Override
	    public List<LodgingType> findAll() {
	        return lodgingTepeRepository.findAll();
	    }
	
	 @Override
	 public void saveOrUpdate(LodgingType category){
		 lodgingTepeRepository.save(category);
	 }
	 
	 @Override 
	 public void delete(LodgingType category){
		 lodgingTepeRepository.deleteById(category.getId());;
	 }
}
