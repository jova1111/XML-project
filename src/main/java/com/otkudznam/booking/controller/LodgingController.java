package com.otkudznam.booking.controller;

import com.otkudznam.booking.model.Lodging;
import com.otkudznam.booking.service.LodgingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class LodgingController {
    @Autowired
    LodgingService lodgingService;

    @RequestMapping(value = "/lodging", method = RequestMethod.GET)
    private ResponseEntity index() {
        List<Lodging> allLodgings = lodgingService.findAll();
        return new ResponseEntity(allLodgings, HttpStatus.OK);
    }

    @RequestMapping(value = "/lodging/{id}", method = RequestMethod.GET)
    private ResponseEntity getById(@PathVariable("id")Long id) {
        Optional<Lodging> lodging = lodgingService.findById(id);
        return new ResponseEntity(lodging.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/lodging/search", method = RequestMethod.GET)
    private ResponseEntity search(
            @RequestParam("city")String city,
            @RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
            @RequestParam(value = "facilities", required = false)String[] facilities,
            @RequestParam(value = "categories", required = false)String[] categories,
            @RequestParam(value = "types", required = false)String[] types) {
        List<Lodging> lodgings = lodgingService.find(city, startDate, endDate, facilities, categories, types);
        lodgings.forEach(e-> System.out.println(e.getLocation()));
        return new ResponseEntity(lodgings, HttpStatus.OK);
    }
}
