package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.models.Employee;
import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.UserRepository;
import java.util.ArrayList;


/**
 * This is the User controller.
 * It can be used to find users, show a list of users and delete or create users.
 */
public class UserController {


    ArrayList<User> users = new ArrayList<>();
    ArrayList<Guest> guests = GuestController.guests;

    ArrayList<Employee> employees = EmployeeController.employees;


    public ArrayList<User> fillUserlist(ArrayList<Guest> guests, ArrayList<Employee> employees) {
        users.addAll(guests);
        users.addAll(employees);
        return users;
    }


    public User findUser(String userId) {
        return UserRepository.findUser(userId);
    }


    public void deleteUser(String userId) {
            UserRepository.getInstance().remove(userId);
    }

    public void resetPassword(String userId) {
            UserRepository.getInstance().resetPassword(userId);
    }

}
