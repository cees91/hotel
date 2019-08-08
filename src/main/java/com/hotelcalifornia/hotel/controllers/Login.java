
        package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.exceptions.NotAllowedException;
import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.Session;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.services.GuestService;
import com.hotelcalifornia.hotel.services.SessionService;
import com.hotelcalifornia.hotel.services.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;
import java.util.UUID;

        @RestController
@RequestMapping("/api/login")
public class Login {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private GuestService service;
    @PostMapping
    public UUID login(@RequestBody Guest guest) throws RuntimeException{
        String email = guest.getEmailAddress();
        String password = guest.getPassword();
        Guest user = service.getUser(email, password);
        boolean hasCorrectCredentials = service.checkCredentials(user, password);
        if(hasCorrectCredentials){
            Session session = sessionService.findByEmail(email);

            if(session == null) {
                session = new Session();
                session.setEmail(user.getEmailAddress());
                sessionService.add(session,user);
            }
            System.out.println("succesfully logged in");
            Hibernate.initialize(user.getBookingsOfUser());
            return session.getUuid();
        } else{
            throw new NotAllowedException("Wrong password or username");
        }
    }
    @GetMapping
    public User getUser(@RequestParam UUID uuid){
        return sessionService.getUser(uuid);
    }
    @DeleteMapping
    public void logout(@RequestParam UUID uuid) throws RuntimeException{
        sessionService.deleteSession(uuid);
    }
}
