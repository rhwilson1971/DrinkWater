package com.orizen.drinkiwater.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.orizen.drinkiwater.data.entities.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    LiveData<User> getAll();

    @Query("SELECT * FROM users WHERE email LIKE :email LIMIT 1")
    LiveData<User> findByName(String email);

    @Update
    void updateUser(User user);

    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM users WHERE user_id = :id")
    void getUserById(int id);

    @Delete
    void deleteUser(User user);
}
