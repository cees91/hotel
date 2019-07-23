package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.models.Employee;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.EmployeeRepository;
import com.hotelcalifornia.hotel.repository.GuestRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

public class EmployeeController extends UserController {

    public static ArrayList<Employee> employees;

    @PostMapping
    public void createEmployee(@RequestBody Employee employee){
        EmployeeRepository.getInstance().create(employee);
    }




}
