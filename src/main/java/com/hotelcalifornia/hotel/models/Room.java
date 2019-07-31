package com.hotelcalifornia.hotel.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hotelcalifornia.hotel.Enums.EBedType;
import com.hotelcalifornia.hotel.Enums.ERoomType;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="rooms")

public class Room {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int roomNumber;
    private int floor;
    private ERoomType type;
    private int adults;
    private int children;
    private EBedType bedType;
    private boolean isDisabled;
    private boolean isAvailable;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern = "dd/MM/yyyy")

    private LocalDate endDate;
    private double price;

    //default constructor for testing purposes
    public Room() { }


    @ManyToMany
    private Set<Booking> bookings;


    public long getId() {
    return id;
}

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public ERoomType getType() {
        return type;
    }

    public void setType(ERoomType type) {
        this.type = type;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public EBedType getBedType() {
        return bedType;
    }

    public void setBedType(EBedType bedType) {
        this.bedType = bedType;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
