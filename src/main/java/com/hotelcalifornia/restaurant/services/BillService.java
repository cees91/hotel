package com.hotelcalifornia.restaurant.services;

import com.hotelcalifornia.restaurant.models.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    public float calcFood(List<Food> foods){
        float sum = 0;
        for (Food food:
                foods) {
            sum += food.getPrice();
        }
        return sum;
    }

}
