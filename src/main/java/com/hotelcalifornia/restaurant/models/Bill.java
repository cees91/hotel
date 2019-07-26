package com.hotelcalifornia.restaurant.models;

import java.util.List;


/**
 * This POJO Bill class contains information about the costs for food and drink, as well as a list of what was
 * ordered
 */
public class Bill {

    private int billId;
    private float foodAmt;
    private float drinkAmt;
    private float taxRate;
    private float grandTotal;
    private List<Food> foods;
    private List<Drink> drinks;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
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
