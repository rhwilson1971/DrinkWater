package com.orizen.drinkiwater.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.orizen.drinkiwater.data.entities.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    LiveData<User> getAll();

    @Query("SELECT * FROM users WHERE email LIKE :email LIMIT 1")
    LiveData<User> findByName(String email);

    @Query("SELECT * FROM users WHERE email = :email AND password =:password AND name=:userName")
    LiveData<User> findByUser(String userName, String email, String password);

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    LiveData<User> findByUserAndPassword(String email, String password);

    @Update
    void updateUser(User user);

    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM users WHERE userId = :id")
    List<User> getUserById(int id);

    @Delete
    void deleteUser(User user);
}
