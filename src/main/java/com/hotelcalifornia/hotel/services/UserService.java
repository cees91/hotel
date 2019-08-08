package com.hotelcalifornia.hotel.services;

import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByUsername(String username){
        return userRepository.findByUserName(username);
    }

    public User findById(long id){
        return userRepository.findById(id);
    }

    public void addUser(User u){userRepository.save(u);}

    public void deleteUser(User u) {
        userRepository.delete(u);
    }

    public void deleteUserById(long id){
        userRepository.deleteById(id);
    }


    public void updateUser(User user){
        userRepository.save(user);
    }

    public String resetPassword (long id){
        User userForReset = userRepository.findById(id);
        userForReset.setPassword(generateRandomPassword());

        return "Your new password is: " + userForReset.getPassword();
    }

    private String generateRandomPassword() {
        final int LENGTH = 8;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789";
        String password = new Random().ints(LENGTH, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());

        return password;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
}

