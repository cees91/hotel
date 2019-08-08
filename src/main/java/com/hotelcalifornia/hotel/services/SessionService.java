package com.hotelcalifornia.hotel.services;


import com.hotelcalifornia.hotel.models.Session;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.SessionRepository;
import com.hotelcalifornia.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionService {

    @Autowired
    private SessionRepository repo;
    public void add(Session session, User user){
        UUID uuid = UUID.randomUUID();
        session.setUuid(uuid);
        session.setUser(user);
        repo.save(session);
    }
    public User getUser(UUID uuid){
        User user =null;
        try {
            Session sessions = repo.findByUuid(uuid);
            user = sessions.getUser();
        } catch(Exception ex){
            System.out.println(ex + ex.getMessage());
        }
        return user;
    }
    public void deleteSession(UUID uuid){
        Session session = repo.findByUuid(uuid);
        repo.deleteById(session.getId());
    }
    public Session findByEmail(String email){
        return repo.findByEmail(email);}
}
