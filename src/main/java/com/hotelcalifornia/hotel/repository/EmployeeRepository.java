package com.hotelcalifornia.hotel.repository;

import com.hotelcalifornia.hotel.Interfaces.Repository;
import com.hotelcalifornia.hotel.models.Employee;
import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.utils.EnvironmentSingleton;

import java.util.ArrayList;

public class EmployeeRepository implements Repository<Employee> {

    private static EmployeeRepository instance = null;
    private ArrayList<Employee> employees = new ArrayList<>();
    EnvironmentSingleton singleton = EnvironmentSingleton.getInstance();

    private EmployeeRepository() {
        //Read the CSV and bind data to employees

    }

    public static EmployeeRepository getInstance() {
        if (instance == null) {
            instance = new EmployeeRepository();
        }
        return instance;
    }

    @Override
    public void create(Employee employee) {
        employee = new Employee();
        employee.setUserName(employee.getUserName());
        employee.setPassword(employee.getPassword());
        employee.getUserId();
    }

    @Override
    public void update(Employee employee) {
        String id = employee.getUserId();
        UserRepository.findAndUpdate(id, employee);
    }

    @Override
    public void remove(String userId) {
        this.employees.remove(UserRepository.findUser(userId));
    }
}
