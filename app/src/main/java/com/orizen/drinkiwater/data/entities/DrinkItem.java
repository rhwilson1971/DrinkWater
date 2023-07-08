package com.orizen.drinkiwater.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "drink_items")
public class DrinkItem {
    @PrimaryKey(autoGenerate = true)
    public int drinkItemId;
    public Integer userId;
    public String name;
    public Float amount;
    public String measure;
    public Date added;
    public Date updated;
}
