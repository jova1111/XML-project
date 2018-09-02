package com.otkudznam.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.otkudznam.booking.model.Period;



public interface PeriodService {
	ArrayList<Period> saveAll(List<Period> periods);

	Optional<Period> findById(Long id);

	void save(Period period);
}
