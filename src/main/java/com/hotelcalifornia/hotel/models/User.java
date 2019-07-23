package com.hotelcalifornia.hotel.models;

import com.hotelcalifornia.hotel.Enums.EUserType;

import java.util.UUID;

public class User {

    private String userId;
    private String userName;
    private String password;

    private EUserType type;

    public User() {
    }

    public User(String userName, String password, EUserType type) {
        this.userName = userName;
        this.password = password;
        this.userId = UUID.randomUUID().toString();;
        this.type = type;
    }

    public User(String userId) {
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public EUserType getType() {
        return type;
    }

    public void setType(EUserType type) {
        this.type = type;
    }
}
