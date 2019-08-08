package com.hotelcalifornia.hotel.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee extends User {

    @Id
    private long id;

    public Employee(){

    }


}
