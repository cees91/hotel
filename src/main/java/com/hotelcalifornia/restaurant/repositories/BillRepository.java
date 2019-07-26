package com.hotelcalifornia.restaurant.repositories;

import com.hotelcalifornia.restaurant.models.Bill;

public class BillRepository {
    private static BillRepository instance = new BillRepository();

    public static BillRepository getInstance() {
        if (instance == null) {
            return instance = new BillRepository();
        }
        return instance;
    }
    private BillRepository() {
    }
}
