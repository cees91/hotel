package com.hotelcalifornia.hotel.services;


import com.hotelcalifornia.hotel.models.Session;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    private SessionRepository repo;

    public void add(Session session){
        repo.save(session);
    }
    public void deleteSession(long id){ repo.deleteById(id);}
}
