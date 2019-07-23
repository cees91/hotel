package com.hotelcalifornia.hotel.controllers;

import com.hotelcalifornia.hotel.models.Employee;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.repository.EmployeeRepository;
import com.hotelcalifornia.hotel.repository.GuestRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

public class EmployeeController extends UserController {


    public void createEmployee(Employee employee){
        EmployeeRepository.getInstance().create(employee);
    }




}
