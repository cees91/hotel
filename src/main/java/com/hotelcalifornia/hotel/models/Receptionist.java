package com.hotelcalifornia.hotel.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Receptionist extends Employee {

    @Id
    private long id;
}


