package com.hotelcalifornia.restaurant.services;

import com.hotelcalifornia.restaurant.models.Food;
import com.hotelcalifornia.restaurant.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepo;


    //get food?
    //add food
    void addFood(Food food) {

    }
    //delete food


}
