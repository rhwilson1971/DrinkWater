package com.orizen.drinkiwater.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.orizen.drinkiwater.data.converters.Converters;

import java.util.Date;

@Entity(tableName = "users")
public class User implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int userId;
    public String name;
    public String email;
    public String password;
    public Date dateAdded;
    public Date dateUpdated;
    public String displayName;

    public User() {

    }

    protected User(Parcel in) {
        userId = in.readInt();
        name = in.readString();
        email = in.readString();
        password = in.readString();
        dateAdded = Converters.fromTimestamp(in.readLong());
        dateUpdated = Converters.fromTimestamp(in.readLong());
        displayName = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(userId);
        parcel.writeString(email);
        parcel.writeString(password);
        parcel.writeLong(Converters.dateToTimestamp(dateAdded));
        parcel.writeLong(Converters.dateToTimestamp(dateUpdated));
        parcel.writeString(displayName);
    }

}
