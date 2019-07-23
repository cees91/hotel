package com.hotelcalifornia.hotel.repository;

import com.hotelcalifornia.hotel.Interfaces.Repository;
import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.utils.EnvironmentSingleton;

import java.util.ArrayList;

public class GuestRepository implements Repository <Guest> {

    private static GuestRepository instance = null;
    private ArrayList<Guest> guests = new ArrayList<>();
    EnvironmentSingleton singleton = EnvironmentSingleton.getInstance();

    private GuestRepository() {
        //Read the CSV and bind data to guests

    }

    public static GuestRepository getInstance() {
        if (instance == null) {
            instance = new GuestRepository();
        }
        return instance;
    }

    @Override
    public void create(Guest guest) {
        guest = new Guest();
        guest.setFirstName(guest.getFirstName());
        guest.setLastName(guest.getLastName());
        guest.setAddress(guest.getAddress());
        guest.setHouseNumber(guest.getHouseNumber());
        guest.setCity(guest.getCity());
        guest.setCountry(guest.getCountry());
        guest.setEmailAddress(guest.getEmailAddress());
        guest.setPhoneNumber(guest.getPhoneNumber());
        guest.setPostcode(guest.getPostcode());
        guest.setUserName(guest.getUserName());
        guest.setPassword(guest.getPassword());
        guest.getUserId();
        guests.add(guest);
    }

    @Override
    public void update(Guest guest) {
        String id = guest.getUserId();
        UserRepository.findAndUpdate(id, guest);
    }

    @Override
    public void remove(String userId) {
        guests.remove(UserRepository.findUser(userId));
    }
}
