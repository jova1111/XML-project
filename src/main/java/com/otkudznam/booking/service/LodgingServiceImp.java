package com.otkudznam.booking.service;

import com.otkudznam.booking.model.Favour;
import com.otkudznam.booking.model.Lodging;
import com.otkudznam.booking.model.Period;
import com.otkudznam.booking.repository.CategoryRepository;
import com.otkudznam.booking.repository.LodgingRepository;
import com.otkudznam.booking.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LodgingServiceImp implements LodgingService {
    @Autowired
    private LodgingRepository lodgingRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Lodging> find(String city, Date startDate, Date endDate, String[] facilities, String[] categories, String[] types) {
       List<Lodging> searchResults = lodgingRepository.findByLocationIgnoreCaseContaining(city);
       if (searchResults.isEmpty()) return null;
       searchResults = searchByPeriods(startDate, endDate, searchResults);
       if (facilities != null && facilities.length > 0) {
           searchResults = searchByFacilityIds(facilities, searchResults);
       }
        if (categories != null && categories.length > 0) {
            searchResults = searchByCategoryIds(categories, searchResults);
        }
        if (types != null && types.length > 0) {
            searchResults = searchByTypeIds(types, searchResults);
        }
        return searchResults;
    }

    private List<Lodging> searchByPeriods(Date startDate, Date endDate, List<Lodging> list) {
        ArrayList<Lodging> results = new ArrayList<>();
        for(Lodging lodging : list) {
            for(Period period : lodging.getPeriods()) {
                System.out.println(period.getDateFrom());
                if(DateUtil.isAfterOrSameDay(startDate, period.getDateFrom()) &&
                        DateUtil.isBeforeDay(startDate, period.getDateTo()) &&
                        DateUtil.isAfterDay(endDate, period.getDateFrom()) &&
                        DateUtil.isBeforeOrSameDay(endDate, period.getDateTo())) {
                    results.add(lodging);
                    break;
                }
            }
        }
        return results;
    }

    private List<Lodging> searchByCategoryIds(String[] categories, List<Lodging> list) {
        return list.stream()
                .filter(lodging -> Arrays.stream(categories).anyMatch(el ->
                    el.equals(lodging.getCategory().getId().toString()))
                )
                .collect(Collectors.toList());
    }

    private List<Lodging> searchByTypeIds(String[] types, List<Lodging> list) {
        return list.stream()
                .filter(lodging -> Arrays.stream(types).anyMatch(el ->
                    el.equals(lodging.getLodgingType().getId().toString()))
                )
                .collect(Collectors.toList());
    }

    private List<Lodging> searchByFacilityIds(String[] facilities, List<Lodging> list) {
        return list.stream()
                .filter(lodging ->
                    lodging.getFavours().stream()
                            .map(e-> e.getId().toString())
                            .collect(Collectors.toList()).containsAll(Arrays.asList(facilities))
                ).collect(Collectors.toList());
    }

    @Override
    public List<Lodging> findAll() {
        return lodgingRepository.findAll();
    }

    @Override
    public Optional<Lodging> findById(Long id) {
        return lodgingRepository.findById(id);
    }
}
