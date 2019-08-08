package com.hotelcalifornia.hotel.services;

import com.hotelcalifornia.hotel.models.Employee;
import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee){
        employee.setPassword(BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt()));
        employeeRepository.save(employee);}


    public void updateEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
}
