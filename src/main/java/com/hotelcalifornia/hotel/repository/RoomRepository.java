package com.hotelcalifornia.hotel.repository;

import com.hotelcalifornia.hotel.models.Booking;
import com.hotelcalifornia.hotel.models.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.OneToMany;
import java.util.ArrayList;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    ArrayList<Room> findAll();
}
