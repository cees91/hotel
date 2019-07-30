package com.hotelcalifornia.restaurant.controllers;


import com.hotelcalifornia.restaurant.models.Food;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/food")
public class FoodController {

    @RequestMapping
    public void addFood(Food food) {


    }



}
