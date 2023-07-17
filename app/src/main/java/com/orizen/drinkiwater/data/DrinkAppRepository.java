package com.orizen.drinkiwater.data;

import android.content.Context;

import androidx.room.Room;

public class DrinkAppRepository {
    private final static String DATABASE_NAME = "drink-item-db";
    private static AppDatabase instance;

    private DrinkAppRepository(Context context){

    }

    public static synchronized  void create(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context,
                    AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
    }

    public static synchronized AppDatabase getInstance() {
        return
                instance;
    }
}
