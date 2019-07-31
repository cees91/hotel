package com.hotelcalifornia.hotel.models;


import com.hotelcalifornia.hotel.Enums.EUserType;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee extends User {

    @Id
    private long id;

    public Employee(){}

//    public Employee(User user) {
//        this.setUserName(user.getUserName());
//        this.setPassword(user.getPassword());
//        this.setType(EUserType.Employee);
//        this.setId(user.getId());
//    }


}
