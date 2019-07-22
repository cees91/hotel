package com.hotelcalifornia.hotel.repository;

import com.hotelcalifornia.hotel.Interfaces.Repository;
import com.hotelcalifornia.hotel.models.Employee;

import java.util.ArrayList;

public class EmployeeRepository implements Repository<Employee> {

    private static EmployeeRepository instance = null;
    private ArrayList<Employee> employees = new ArrayList<>();

    private EmployeeRepository() {
        //Read the CSV and bind data to bookedRooms

    }

    public static EmployeeRepository getInstance() {
        if (instance == null) {
            instance = new EmployeeRepository();
        }
        return instance;
    }

    @Override
    public void create(Employee employee) {

    }

    @Override
    public void update(int userId) {

    }

    @Override
    public void remove(int userId) {

    }
}
