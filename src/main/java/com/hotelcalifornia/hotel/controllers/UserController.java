package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.models.Employee;
import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.services.EmployeeService;
import com.hotelcalifornia.hotel.services.GuestService;
import com.hotelcalifornia.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * This is the User controller.
 * It can be used to find users, show a list of users and delete or create users.
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private GuestService guestService;


    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> fillUserlist(ArrayList<Guest> guests, ArrayList<Employee> employees) {
        users.addAll(guests);
        users.addAll(employees);
        return users;
    }

    /**
     * Finds user accounts
     * @param id or username
     */

    @RequestMapping(method=RequestMethod.GET, value="/find/{id}")
    public User findUserById(@RequestParam long id) {
        return userService.findById(id);
    }

    @RequestMapping(method=RequestMethod.GET, value="/find/{username}")
    public User findUserByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }


    /**
     * Deletes user accounts
     * @param id or user
     */

    @RequestMapping(method = RequestMethod.DELETE, value="/delete")
    public void deleteUserById(long id) {
            userService.deleteUserById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/delete")
    public void deleteUser(User user) {
        userService.deleteUser(user);
    }


    /**
     * Resets password
     * @param id
     */

    @RequestMapping(method = RequestMethod.PUT, value="/resetpassword")
    public void resetPassword(@RequestParam long id) {
            userService.resetPassword(id);
    }

    /**
     * Creates accounts
     * @param user, guest, employee
     */

    @RequestMapping(method = RequestMethod.POST, value="/create")
    //create user account
    public void create(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, value="/create/guest")
    //create user account
    public void create(@RequestBody Guest guest){
        guestService.addGuest(guest);
    }

    @RequestMapping(method = RequestMethod.POST, value="/create/employee")
    //create user account
    public void create(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    /**
     * Updates user accounts
     * @param user
     */
    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @PutMapping("/update/guest")
    public void updateGuest(@RequestBody Guest guest) {
        guestService.updateGuest(guest);
    }

    @PutMapping("/update/employee")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    /**
     * Updates GETs lists of users, guests or employees
     *
     */

    @RequestMapping(method = RequestMethod.GET, value="/allguests")
    public List<Guest> getAllGuests() {
        return guestService.getAll();
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="/allemployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }
}
