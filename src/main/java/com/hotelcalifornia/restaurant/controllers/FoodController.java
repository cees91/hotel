package com.hotelcalifornia.restaurant.controllers;


import com.hotelcalifornia.restaurant.models.Food;
import com.hotelcalifornia.restaurant.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @RequestMapping(value = "/food/add", method = RequestMethod.GET)
    public void addFood(Food food) {
        System.out.println("GET working buddy.");
        foodService.addFood(food);
    }





}
