package com.orizen.drinkiwater.data;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.orizen.drinkiwater.data.entities.User;
import com.orizen.drinkiwater.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication

            LiveData<User> user = null;
            LiveData<User> foundUser = null;

            if(null != DrinkAppRepository.getInstance()) {
                user = DrinkAppRepository.getInstance().userDao().findByName(username);

                if (user.getValue() != null) {




                    DrinkAppRepository.getInstance().userDao().findByUserAndPassword(username, password);
                    if (foundUser.getValue() == null ){
                        return new Result.Error(new IOException("Invalid credentials", null));
                    }
                }
            }

            if(null == user.getValue()) {
                return new Result.Error(new IOException("User not found!", null));
            } else if( foundUser.getValue() == null ) {
                return new Result.Error(new IOException("Invalid credentials", null));
            } else {
                LoggedInUser successUser = new LoggedInUser(foundUser.getValue());
                return new Result.Success<>(successUser);
            }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }

    public LoginDataSource() {

    }
}