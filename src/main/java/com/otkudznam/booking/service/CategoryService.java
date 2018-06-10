package com.otkudznam.booking.service;

import java.util.List;

import com.otkudznam.booking.model.Category;

public interface CategoryService {

	List<Category> findAll();
	void saveOrUpdate(Category category);
	void delete(Category category);
}
