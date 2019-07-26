package com.hotelcalifornia.hotel.repository;

import com.hotelcalifornia.hotel.Interfaces.Repository;
import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.utils.EnvironmentSingleton;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface GuestRepository extends CrudRepository<Guest, Long> {

    List<Guest> findAll();
    Guest findById(long id);
    Guest findByUsername(String username);
    Guest findByLastname(String lastName);

//    public void create(Guest newGuest) {
//        Guest guest = new Guest();
//        guest.setFirstName(newGuest.getFirstName());
//        guest.setLastName(newGuest.getLastName());
//        guest.setAddress(newGuest.getAddress());
//        guest.setHouseNumber(newGuest.getHouseNumber());
//        guest.setCity(newGuest.getCity());
//        guest.setCountry(newGuest.getCountry());
//        guest.setEmailAddress(newGuest.getEmailAddress());
//        guest.setPhoneNumber(newGuest.getPhoneNumber());
//        guest.setPostcode(newGuest.getPostcode());
//        guest.setUserName(newGuest.getUserName());
//        guest.setPassword(newGuest.getPassword());
//        guest.setUserId(newGuest.getUserId());
//        guests.add(guest);
//    }
//
//
//    public void update(Guest guest) {
//        String id = guest.getUserId();
//        UserRepository.findAndUpdate(id, guest);
//    }
//
//    public void remove(String userId) {
//        guests.remove(UserRepository.findUser(userId));
//    }
//
//    public List<Guest> getAllGuests() {
//        return guests;
//    }
}
