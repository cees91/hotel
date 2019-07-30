package com.hotelcalifornia.hotel.models;

import com.hotelcalifornia.hotel.Enums.EUserType;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private long Id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private EUserType type;


    public User() {

    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(long id){
        this.Id = Id;
    }

    public long getId() {
        return Id;
    }

    public EUserType getType() {
        return type;
    }

    public void setType(EUserType type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
