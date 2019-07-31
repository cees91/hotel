package com.hotelcalifornia.restaurant.models;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Table {

    @Id
    @GeneratedValue
    private int id;
    private int capacity;

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
