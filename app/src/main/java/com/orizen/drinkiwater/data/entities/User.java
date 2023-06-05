package com.orizen.drinkiwater.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    public int userId;

    @ColumnInfo(name = "name")
    public String Name;

    @ColumnInfo(name = "email")
    public String Email;

    @ColumnInfo(name = "password")
    public String Password;

    @ColumnInfo(name="date_added")
    public Date dateAdded;

    @ColumnInfo(name="date_updated")
    public Date dateUpdated;

    @ColumnInfo(name="display_name")
    public String displayName;
}
