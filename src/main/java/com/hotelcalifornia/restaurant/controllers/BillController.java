package com.hotelcalifornia.restaurant.controllers;


import com.hotelcalifornia.restaurant.models.Food;

import java.util.List;

public class BillController {

    public float calcFood(List<Food> foods){
        float sum = 0;
        for (Food food:
                foods) {
            sum += food.getPrice();
        }
        return sum;
    }
}
