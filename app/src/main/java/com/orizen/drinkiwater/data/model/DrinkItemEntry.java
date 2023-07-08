package com.orizen.drinkiwater.data.model;

import java.util.ArrayList;

public class DrinkItemEntry {

    private Float amount;

    private String drinkName;

    private int id;

    public DrinkItemEntry(int id, String drinkName, float amount){
        this.id = id;
        this.amount = amount;
        this.drinkName = drinkName;
    }

    public int getId() { return id; }
    public String getDrinkName() { return drinkName; }
    public Float getAmount() { return amount; }

    public static ArrayList<DrinkItemEntry> getDummyContent() {
        ArrayList<DrinkItemEntry> drinkItems = new ArrayList<DrinkItemEntry>();
        drinkItems.add(new DrinkItemEntry(1, "Water", 4.0f));
        drinkItems.add(new DrinkItemEntry(1, "Water", 8.0f));
        drinkItems.add(new DrinkItemEntry(1, "Water", 8.0f));
        drinkItems.add(new DrinkItemEntry(1, "Water", 16.0f));
        drinkItems.add(new DrinkItemEntry(1, "Water", 4.0f));

        return drinkItems;


    }
}
