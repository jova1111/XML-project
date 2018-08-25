package com.otkudznam.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otkudznam.booking.model.User;
import com.otkudznam.booking.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    @Override
    public void delete(User user){
    	userRepository.deleteById(user.getId());
    }
    
    @Override
    public List<User> findByRole(String role){
    	return userRepository.findByRole(role);
    }
}
