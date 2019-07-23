package com.hotelcalifornia.hotel.models;


import com.hotelcalifornia.hotel.Enums.EUserType;

public class Employee extends User {

    private User user;

    public Employee(){}

    public Employee(User user) {
        this.setUserName(user.getUserName());
        this.setPassword(user.getPassword());
        this.setType(EUserType.Employee);
    }

}
