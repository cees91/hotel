package com.hotelcalifornia.hotel.services;

import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    GuestRepository guestRepository;

    public void addGuest(Guest g){guestRepository.save(g);}

    public void updateGuest(Guest guest){
        guestRepository.save(guest);
    }

    public List<Guest> getAll(){
        return guestRepository.findAll();
    }
}
