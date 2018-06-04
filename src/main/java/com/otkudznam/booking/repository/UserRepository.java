package com.otkudznam.booking.repository;

import com.otkudznam.booking.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    List<User> findAll();

    User findByEmail(String email);
}
