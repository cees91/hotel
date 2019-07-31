package com.hotelcalifornia.restaurant.services;

import com.hotelcalifornia.restaurant.models.Food;
import com.hotelcalifornia.restaurant.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepo;

    //add food
    public void addFood(Food food) {
        try {
            foodRepo.save(food);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Food cannot be added");
        }

    }
    //delete food
    public void deleteFood(long id) {
        try {
            foodRepo.deleteById(id);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Food unsuccesfully deleted");
        }
    }



}
