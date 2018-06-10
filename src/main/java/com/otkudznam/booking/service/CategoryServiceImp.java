package com.otkudznam.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otkudznam.booking.model.Category;
import com.otkudznam.booking.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
    private CategoryRepository categoryRepository;
	
	 @Override
	    public List<Category> findAll() {
	        return categoryRepository.findAll();
	    }
	
	 @Override
	 public void saveOrUpdate(Category category){
		 categoryRepository.save(category);
	 }
	 
	 @Override 
	 public void delete(Category category){
		 categoryRepository.deleteById(category.getId());;
	 }
}
