package com.hotelcalifornia.hotel.repository;

import com.hotelcalifornia.hotel.models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {


        List<Employee> findAll();

        Employee findById(long id);

        Employee findByUsername(String username);

        Employee findByLastname(String lastName);

}