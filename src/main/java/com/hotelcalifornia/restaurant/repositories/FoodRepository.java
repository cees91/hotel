package com.hotelcalifornia.restaurant.repositories;

import com.hotelcalifornia.restaurant.models.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

    List<Food> findAll();
    Food findById(long id);
    Food save(Food food);
    void deleteById(long id);

}
