package com.otkudznam.booking.service;

import java.util.List;

import com.otkudznam.booking.model.User;

public interface UserService {

    void saveOrUpdate(User user);
    List<User> findAll();
    User findByEmail(String email);
    void delete(User user);
    List<User> findByRole(String role);
}
