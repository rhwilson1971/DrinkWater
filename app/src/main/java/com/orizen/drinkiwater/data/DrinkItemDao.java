package com.orizen.drinkiwater.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.orizen.drinkiwater.data.entities.DrinkItem;

import java.util.List;

@Dao
public interface DrinkItemDao {
    @Query("SELECT * FROM drink_items where user_id = :user_id")
    LiveData<List<DrinkItem>> getAll(Integer user_id);

    @Query("SELECT * FROM drink_items where drink_item_id = :drinkItemId")
    LiveData<DrinkItem> getDrinkItemById(Integer drinkItemId);

    @Insert
    void insert(DrinkItem drinkItem);

    @Delete
    void delete(DrinkItem drinkItem);

    @Update
    void update(DrinkItem drinkItem);
}
