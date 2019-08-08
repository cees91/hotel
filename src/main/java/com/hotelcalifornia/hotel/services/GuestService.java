package com.hotelcalifornia.hotel.services;

import com.hotelcalifornia.hotel.exceptions.NotFoundException;
import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;


    public Guest getUser(String email, String password){
        return guestRepository.findByEmailAddress(email);
    }
    public boolean checkCredentials(User user){
        String password = user.getPassword();
        if(user != null){
            String passwordOfUser = user.getPassword();
            if(password.equals(passwordOfUser)){
                return true;
            } else {
                return false;
            }
        } else{
            throw new NotFoundException("No user with was found with the specified email");
        }
    }


    public void addGuest(Guest g){
        g.setPassword(BCrypt.hashpw(g.getPassword(), BCrypt.gensalt()));
        guestRepository.save(g);}

    public void updateGuest(Guest guest){
        guestRepository.save(guest);
    }

    public List<Guest> getAll(){
        return guestRepository.findAll();
    }
}
