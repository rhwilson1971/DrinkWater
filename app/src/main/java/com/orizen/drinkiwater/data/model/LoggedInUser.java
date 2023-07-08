package com.orizen.drinkiwater.data.model;

import androidx.lifecycle.LiveData;

import com.orizen.drinkiwater.data.entities.User;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private final String displayName;

    private final User dbUser;

    public LoggedInUser(User dbUser) {
        this.displayName = dbUser.displayName;
        this.dbUser = dbUser;
    }

    public String getDisplayName() {
        return displayName;
    }
}