package com.hotelcalifornia.hotel.repository;

import com.hotelcalifornia.hotel.Interfaces.Repository;
import com.hotelcalifornia.hotel.models.Employee;
import com.hotelcalifornia.hotel.models.Guest;
import com.hotelcalifornia.hotel.models.User;
import com.hotelcalifornia.hotel.utils.EnvironmentSingleton;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{


        List<Employee> findAll();
        Employee findById(long id);
        Employee findByUsername(String username);
        Employee findByLastname(String lastName);




//    public void create(Employee newEmployee) {
//        Employee employee = new Employee();
//        employee.setUserName(newEmployee.getUserName());
//        employee.setPassword(newEmployee.getPassword());
//        employee.getUserId();
//    }
//
//    public void update(Employee employee) {
//        String id = employee.getUserId();
//        UserRepository.findAndUpdate(id, employee);
//    }
//
//
//    public void remove(String userId) {
//        this.employees.remove(UserRepository.findUser(userId));
//    }
//
//    public List<Employee> getAllEmployees() {
//        return employees;
//    }
}
