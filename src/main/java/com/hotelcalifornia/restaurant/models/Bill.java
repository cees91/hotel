package com.hotelcalifornia.restaurant.models;

import org.hibernate.annotations.CollectionType;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * This POJO Bill class contains information about the costs for food and drink, as well as a list of what was
 * ordered
 */
@Entity
public class Bill {
    @Id
    @GeneratedValue
    private long id;
    private float foodAmt;
    private float drinkAmt;
    private float taxRate;
    private float grandTotal;

    @ElementCollection
    private List<Food> foods;
    @ElementCollection
    private List<Drink> drinks;

    public long getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public float getFoodAmt() {
        return foodAmt;
    }

    public void setFoodAmt(float foodAmt) {
        this.foodAmt = foodAmt;
    }

    public float getDrinkAmt() {
        return drinkAmt;
    }

    public void setDrinkAmt(float drinkAmt) {
        this.drinkAmt = drinkAmt;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    public float getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(float grandTotal) {
        this.grandTotal = grandTotal;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }
}
