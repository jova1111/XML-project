package com.otkudznam.booking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.otkudznam.booking.model.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long>{

	List<Category> findAll();

}
