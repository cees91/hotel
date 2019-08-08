
        package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.exceptions.NotAllowedException;
import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.Session;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.services.GuestService;
import com.hotelcalifornia.hotel.services.SessionService;
import com.hotelcalifornia.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;
@RestController
@RequestMapping
public class Login {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private GuestService service;
    @PostMapping
    public Guest login(@RequestBody Guest guest) throws RuntimeException{
        String email = guest.getEmailAddress();
        String password = guest.getPassword();
        Guest user = service.getUser(email, password);
        boolean hasCorrectCredentials = service.checkCredentials(user);
        if(hasCorrectCredentials){
            Session session = new Session();
            session.setEmail(user.getEmailAddress());
            sessionService.add(session);
            return user;
        } else{
            throw new NotAllowedException("Wrong password or username");
        }
    }
    @DeleteMapping
    public void logout(long id) throws RuntimeException{
        sessionService.deleteSession(id);
    }
}

