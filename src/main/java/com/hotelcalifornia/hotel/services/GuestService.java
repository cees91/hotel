package com.hotelcalifornia.hotel.services;

import com.hotelcalifornia.hotel.exceptions.NotFoundException;
import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.GuestRepository;
import com.hotelcalifornia.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private UserRepository userRepository;


    public User getUser(String email, String password){
        return userRepository.findByEmailAddress(email);
    }
    public boolean checkCredentials(User user,String password){
        if(user != null){
            String passwordOfUser = user.getPassword();
            if(BCrypt.checkpw(password, user.getPassword())){
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
        userRepository.save(g);}

    public void updateGuest(Guest guest){
        userRepository.save(guest);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
}
