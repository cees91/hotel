package com.hotelcalifornia.hotel.repository;

import com.hotelcalifornia.hotel.models.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findAll();
    Booking findById(long id);
}
