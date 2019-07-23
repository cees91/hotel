package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.GuestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GuestController extends UserController {

    @RequestMapping(method = RequestMethod.POST, value="/create/guest")
    @ResponseBody
    //create guest account
    public void createGuest(Guest guest){
            GuestRepository.getInstance().create(guest);
    }

    /**
     *
     * @param guest
     *
     */

    @RequestMapping(method = RequestMethod.PUT, value="/update/guest")
    @ResponseBody
    //update guest account
    public void updateGuest(Guest guest) {
        GuestRepository.getInstance().update(guest);
    }

    @RequestMapping(method = RequestMethod.GET, value="/guest/allguest")
    @ResponseBody
    public List<Guest> getAllGuests() {
        return GuestRepository.getInstance().getAllGuests();
    }


}
