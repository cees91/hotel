package com.hotelcalifornia.hotel.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee extends User {

    @Id
    private long id;

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    private String authType = "admin";
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    private String emailAddress;




}
