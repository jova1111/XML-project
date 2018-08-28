package com.otkudznam.booking.controller;

import com.otkudznam.booking.auth.TokenResponse;
import com.otkudznam.booking.model.User;
import com.otkudznam.booking.service.UserService;
import com.otkudznam.booking.util.DateUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/user", method = RequestMethod.POST)
    private ResponseEntity register(@RequestBody User user) {
        if(user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        userService.saveOrUpdate(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody User login) throws ServletException {

        String jwtToken = "";

        if (login.getEmail() == null || login.getPassword() == null) {
            return new ResponseEntity("Please fill in username and password", HttpStatus.UNAUTHORIZED);
        }

        String email = login.getEmail();
        String password = login.getPassword();

        User user = userService.findByEmail(email);

        if (user == null || !password.equals(user.getPassword())) {
            return new ResponseEntity("Given data is invalid.", HttpStatus.UNAUTHORIZED);
        }

        Date expirationDate = DateUtil.getDateFromNow(DateUtil.MONTH_IN_SECONDS);
        jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date()).setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        return new ResponseEntity(new TokenResponse(jwtToken, DateUtil.MONTH_IN_SECONDS), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/secure/test")
    public String test(HttpServletRequest request) {
        System.out.println(request.getAttribute("userEmail"));
        return "Hi.";
    }

}
