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

                user =
                        DrinkAppRepository.getInstance().userDao().findByName(username);
            }

            if(null == user) {
                return new Result.Error(new IOException("Error logging in", null));
            } else {
                LoggedInUser fakeUser =
                        new LoggedInUser(
                                user.getValue().Email,
                                user.getValue().displayName,
                                user);

                return new Result.Success<>(fakeUser);
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