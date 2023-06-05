package com.orizen.drinkiwater.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "drink_items")
public class DrinkItem {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "drink_item_id" )
    public int drinkItemId;

    @ColumnInfo(name = "user_id")
    public Integer UserId;

    @ColumnInfo(name = "drink_name")
    public String Name;

    @ColumnInfo(name = "drink_amount")
    public Float Amount;

    @ColumnInfo(name = "drink_measure")
    public String Measure;

    @ColumnInfo(name="date_added")
    public Date dateAdded;

    @ColumnInfo(name="date_updated")
    public Date dateUpdated;
}
