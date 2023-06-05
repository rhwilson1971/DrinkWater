package com.orizen.drinkiwater.data;

import android.content.Context;

import androidx.room.Room;

public class DrinkAppRepository {
    private final static String DATABASE_NAME = "drink-item-db";
    private static AppDatabase instance;

    private DrinkAppRepository(Context context){

    }

    public static synchronized  AppDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return instance;
    }
}
