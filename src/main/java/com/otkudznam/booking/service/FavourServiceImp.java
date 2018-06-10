package com.otkudznam.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otkudznam.booking.model.Favour;
import com.otkudznam.booking.repository.FavourRepository;

@Service
public class FavourServiceImp implements FavourService{
	
	@Autowired
    private FavourRepository favourRepository;
	
	 @Override
	    public List<Favour> findAll() {
	        return favourRepository.findAll();
	    }
	
	 @Override
	 public void saveOrUpdate(Favour category){
		 favourRepository.save(category);
	 }
	 
	 @Override 
	 public void delete(Favour category){
		 favourRepository.deleteById(category.getId());;
	 }

}
