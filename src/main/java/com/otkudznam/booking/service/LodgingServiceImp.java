package com.otkudznam.booking.service;

import com.otkudznam.booking.model.Favour;
import com.otkudznam.booking.model.Lodging;
import com.otkudznam.booking.repository.CategoryRepository;
import com.otkudznam.booking.repository.LodgingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LodgingServiceImp implements LodgingService {
    @Autowired
    private LodgingRepository lodgingRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Lodging> find(String city, Date startDate, Date endDate, String[] facilities, String[] categories, String[] types) {
       List<Lodging> searchResults = lodgingRepository.findByLocationIgnoreCaseContainingAndFromDateBeforeAndToDateAfter(city, startDate, endDate);
       if(searchResults.isEmpty()) return null;
       if(facilities != null && facilities.length > 0) {
           searchResults = searchByFacilityIds(facilities, searchResults);
       }
        if(categories != null && categories.length > 0) {
            searchResults = searchByCategoryIds(categories, searchResults);
        }
        if(types != null && types.length > 0) {
            searchResults = searchByTypeIds(types, searchResults);
        }
        return searchResults;
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
