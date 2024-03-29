package com.hotelcalifornia.hotel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotelcalifornia.hotel.Enums.EUserType;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;

    private String userName;


    private String password;
    //private String passwordCheck;
    private String firstName;
    private String lastName;



    private String emailAddress;



    @Enumerated(EnumType.STRING)
    private EUserType userType;
    @OneToMany
    private List<Booking> bookingsOfUser;


    public List<Booking> getBookingsOfUser() {
        return bookingsOfUser;
    }

    public void setBookingsOfUser(List<Booking> bookingsOfUser) {
        this.bookingsOfUser = bookingsOfUser;

    }
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public EUserType getUserType() {
        return userType;
    }

    public void setUserType(EUserType userType) {
        this.userType = userType;
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

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;

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
