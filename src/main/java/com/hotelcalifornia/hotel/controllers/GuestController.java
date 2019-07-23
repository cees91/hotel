package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.GuestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class GuestController extends UserController {

    static ArrayList<Guest> guests = new ArrayList<Guest>();

  //  @RequestMapping (method = RequestMethod.POST, value="/create/guest")

    @PostMapping
    //create guest account
    public void createGuest(@RequestBody Guest guest){
            GuestRepository.getInstance().create(guest);
    }

    /**
     *
     * @param userId
     * @throws Exception
     */
 //   @RequestMapping (method = RequestMethod.PUT, value="/update/guest")
    // update guest account
    @ResponseBody
    public void updateGuest(@RequestBody int userId) throws Exception {

        GuestRepository.getInstance().update(userId);

    }



}
