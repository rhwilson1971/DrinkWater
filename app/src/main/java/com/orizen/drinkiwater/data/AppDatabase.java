package com.orizen.drinkiwater.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.orizen.drinkiwater.data.entities.DrinkItem;
import com.orizen.drinkiwater.data.entities.GoalItem;
import com.orizen.drinkiwater.data.entities.User;

@Database(entities = {User.class, DrinkItem.class, GoalItem.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract DrinkItemDao drinkItemDao();
    public abstract GoalItemDao goalItemDao();
}
