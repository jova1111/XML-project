package com.otkudznam.booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping(value="/welcome")
    private ResponseEntity welcome() {
        return new ResponseEntity("OK", HttpStatus.OK);
    }

}
