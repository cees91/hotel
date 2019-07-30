package com.hotelcalifornia.restaurant.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Drink {

    @Id
    private long drinkId;
    private String type;
    private String name;
    private String brand;
    private float price;
    private int quantity;

    public long getid() {
        return drinkId;
    }

    public void setid(long id) {
        this.drinkId = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
