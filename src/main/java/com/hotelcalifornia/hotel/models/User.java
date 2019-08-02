package com.hotelcalifornia.hotel.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
/**
 * with this Inheritance tag the table should add a column that saves
 * what class this entity is, so for example, a Guest would have "Guest" in that column
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;
    @NotNull
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Booking> bookingsOfUser;

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
