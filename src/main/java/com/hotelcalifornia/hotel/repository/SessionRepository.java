package com.hotelcalifornia.hotel.repository;


import com.hotelcalifornia.hotel.models.Session;
import com.hotelcalifornia.hotel.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
}
