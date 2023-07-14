package com.orizen.drinkiwater.ui.login;

import com.orizen.drinkiwater.data.entities.User;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayName;
    private User user;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(User user, String displayName) {
        this.user = user;
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }

    User getUser() { return user; }
}