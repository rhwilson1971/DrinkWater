package com.orizen.drinkiwater.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.orizen.drinkiwater.data.entities.User;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser implements Parcelable {

    private String displayName;

    private User dbUser;

    public LoggedInUser(){

    }

    public LoggedInUser(User dbUser) {
        this.displayName = dbUser.displayName;
        this.dbUser = dbUser;
    }

    protected LoggedInUser(Parcel in) {
        displayName = in.readString();
        dbUser = in.readParcelable(User.class.getClassLoader());
    }

    public static final Creator<LoggedInUser> CREATOR = new Creator<LoggedInUser>() {
        @Override
        public LoggedInUser createFromParcel(Parcel in) {
            return new LoggedInUser(in);
        }

        @Override
        public LoggedInUser[] newArray(int size) {
            return new LoggedInUser[size];
        }
    };

    public String getDisplayName() {
        return displayName;
    }

    public User getDbUser() { return dbUser; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(displayName);
        dbUser.writeToParcel(parcel, i);
    }
}