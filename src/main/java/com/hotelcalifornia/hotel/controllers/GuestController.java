package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.repository.GuestRepository;

import java.util.ArrayList;


public class GuestController extends UserController {

    static ArrayList<Guest> guests = new ArrayList<>();

    //create guest account
    public void createGuest(Guest guest){
            GuestRepository.getInstance().create(guest);
    }

    // update guest account
}
