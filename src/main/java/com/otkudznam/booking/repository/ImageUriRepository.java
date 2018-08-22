package com.otkudznam.booking.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.otkudznam.booking.model.ImageUrl;

@Repository
public interface ImageUriRepository extends PagingAndSortingRepository<ImageUrl, Long>{

	List<ImageUrl> findAll();
} 
