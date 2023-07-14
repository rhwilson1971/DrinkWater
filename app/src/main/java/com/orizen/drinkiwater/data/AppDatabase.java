package com.orizen.drinkiwater.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.orizen.drinkiwater.data.converters.Converters;
import com.orizen.drinkiwater.data.entities.DrinkItem;
import com.orizen.drinkiwater.data.entities.GoalItem;
import com.orizen.drinkiwater.data.entities.User;

@Database(entities = {User.class, DrinkItem.class, GoalItem.class}, version=1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract DrinkItemDao drinkItemDao();
    public abstract GoalItemDao goalItemDao();
}
