package com.otkudznam.booking.repository;

import com.otkudznam.booking.model.Lodging;
import com.otkudznam.booking.model.Period;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface LodgingRepository extends PagingAndSortingRepository<Lodging, Long> {
    List<Lodging> findAll();
    Optional<Lodging> findById(Long id);
    List<Lodging> findByLocationIgnoreCaseContaining(String city);
    @Query("select r from Lodging r where r.name = ?1")
    Lodging findDate(String lodgingName);
	
    
}
