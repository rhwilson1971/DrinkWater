package com.orizen.drinkiwater.data.model;

import androidx.lifecycle.LiveData;

import com.orizen.drinkiwater.data.entities.User;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String displayName;

    private LiveData<User> user;

    public LoggedInUser(String userId, String displayName, LiveData<User> dbUser) {
        this.userId = userId;
        this.displayName = displayName;
        this.user = dbUser;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }
}