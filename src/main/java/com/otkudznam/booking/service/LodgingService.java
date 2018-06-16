package com.otkudznam.booking.service;

import com.otkudznam.booking.model.Lodging;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LodgingService {
    List<Lodging> find(String city, Date startDate, Date endDate, String[] facilities, String[] categories, String[] types);
    List<Lodging> findAll();
    Optional<Lodging> findById(Long id);
}
