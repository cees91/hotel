package com.hotelcalifornia.hotel.Interfaces;

import java.util.List;

public interface Repository <T> {

    void create(T item);

    void update(T item);

    void remove(String id);

    //List<T> query(T specification);

}



