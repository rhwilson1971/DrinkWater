package com.orizen.drinkiwater.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int userId;
    public String name;
    public String email;
    public String password;
    public Date dateAdded;
    public Date dateUpdated;
    public String displayName;
}
