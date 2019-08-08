package com.hotelcalifornia.hotel.repository;


import com.hotelcalifornia.hotel.models.Session;
import com.hotelcalifornia.hotel.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
    Session findByEmail(String email);
    Session findByUuid(UUID uuid);
    void deleteByUuid(UUID uuid);
}
