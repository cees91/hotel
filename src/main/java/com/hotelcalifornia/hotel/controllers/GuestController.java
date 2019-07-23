package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.GuestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class GuestController extends UserController {

    static ArrayList<Guest> guests = new ArrayList<Guest>();


    //create guest account
    public void createGuest(Guest guest){
            GuestRepository.getInstance().create(guest);
    }

    /**
     *
     * @param guest
     * @throws Exception
     */


    public void updateGuest(Guest guest) {
        GuestRepository.getInstance().update(guest);
    }



}
