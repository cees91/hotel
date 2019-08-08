package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;
@RestController
@RequestMapping
public class Login {
//    @Autowired
//    private SessionService session;
    @Autowired
    private UserService service;
    @GetMapping
    public boolean login(String email, String password) throws RuntimeException{
        boolean hasCorrectCredentials = service.login(email,password);
        if(hasCorrectCredentials){
//            session.add()
        }
        return true;
    }
}