package com.hotelcalifornia.hotel.repository;

import com.hotelcalifornia.hotel.models.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuestRepository extends CrudRepository<Guest, Long> {

    List<Guest> findAll();
    Guest findById(long id);
    Guest findByUserName(String username);
    Guest findByLastName(String lastName);
}
