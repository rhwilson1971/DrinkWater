package com.orizen.drinkiwater.data;

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

            if(null != DrinkAppRepository.getInstance()) {
                user = DrinkAppRepository.getInstance().userDao().findByName(username);

                if (user != null) {

                    user = DrinkAppRepository.getInstance().userDao().findByUserAndPassword(username, password);

                    if (user == null ){
                        return new Result.Error(new IOException("Invalid credentials", null));
                    }
                }
            }

            if(null == user) {
                return new Result.Error(new IOException("User not found!", null));
            } else {
                LoggedInUser successUser = new LoggedInUser(user.getValue());
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