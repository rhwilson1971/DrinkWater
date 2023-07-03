package com.orizen.drinkiwater.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "goal_items")
public class GoalItem {
    @PrimaryKey(autoGenerate = true)
    public int goalItemId;
    public int userId;
    public float amount;
    public int duration; // in hours
    public Date added;
    public Date updated;
}
