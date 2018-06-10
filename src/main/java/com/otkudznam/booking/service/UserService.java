package com.otkudznam.booking.service;

import com.otkudznam.booking.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    void saveOrUpdate(User user);
    List<User> findAll();
    User findByEmail(String email);
    void delete(User user);
}
