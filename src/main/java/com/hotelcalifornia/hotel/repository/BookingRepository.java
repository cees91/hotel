package com.hotelcalifornia.hotel.repository;


import com.hotelcalifornia.hotel.exceptions.EmptyRepoException;
import com.hotelcalifornia.hotel.exceptions.NotFoundException;
import com.hotelcalifornia.hotel.models.Booking;
import com.hotelcalifornia.hotel.utils.EnvironmentSingleton;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findAll();
}
