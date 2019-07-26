package com.hotelcalifornia.restaurant.repositories;

public class TableRepository {

    private static TableRepository instance = null;
    private TableRepository(){
        //defeate instantiation
    }

    public static TableRepository getInstance() {
        if(instance == null) {
            instance = new TableRepository();
        }
        return instance;
    }
}
