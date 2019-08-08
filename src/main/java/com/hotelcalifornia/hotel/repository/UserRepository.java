package com.hotelcalifornia.hotel.repository;

import com.hotelcalifornia.hotel.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
    User findById(long id);
    User findByUserName(String username);
//    User findByEmailAddress(String email);
}
