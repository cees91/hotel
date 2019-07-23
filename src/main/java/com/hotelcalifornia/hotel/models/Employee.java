package com.hotelcalifornia.hotel.models;


public class Employee extends User {

    private User user;

    public Employee(){}

    public Employee(User user, String employeeId) {
        this.setUserName(user.getUserName());
        this.setPassword(user.getPassword());
        this.setType("employee");
    }

}
