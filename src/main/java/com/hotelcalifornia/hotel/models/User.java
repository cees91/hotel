package com.hotelcalifornia.hotel.models;

import com.hotelcalifornia.hotel.Enums.EUserType;
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
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.ORDINAL)
    private EUserType type;
    @OneToMany
    private List<Booking> bookingsOfUser;

    public User() {

    }

    public List<Booking> getBookingsOfUser() {
        return bookingsOfUser;
    }

    public void setBookingsOfUser(List<Booking> bookingsOfUser) {
        this.bookingsOfUser = bookingsOfUser;

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
