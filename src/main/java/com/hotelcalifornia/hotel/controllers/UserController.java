package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.models.Employee;
import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {


    ArrayList<User> users = new ArrayList<>();
    ArrayList<Guest> guests = GuestController.guests;

    ArrayList<Employee> employees = EmployeeController.employees;


    public ArrayList<User> fillUserlist(ArrayList<Guest> guests, ArrayList<Employee> employees) {
        users.addAll(guests);
        users.addAll(employees);
        return users;
    }


    public int findUser(@RequestParam int userId) throws Exception {
        return UserRepository.getInstance().findUserIndexById(userId);
    }


    public String deleteUser(@RequestParam int userId) {
        try {
            UserRepository.getInstance().remove(userId);
        } catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User succesfully deleted! (id = " + userId + ")";

    }

    public void resetPassword(int userId) {
        try {
            UserRepository.getInstance().resetPassword(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String generateRandomPassword() {
        final int LENGTH = 8;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789";
        String password = new Random().ints(LENGTH, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());

        return password;
    }
}
