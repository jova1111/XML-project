package com.otkudznam.booking.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.otkudznam.booking.model.ImageUrl;

public interface ImageUriRepository extends PagingAndSortingRepository<ImageUrl, Long>{

	List<ImageUrl> findAll();
} 
