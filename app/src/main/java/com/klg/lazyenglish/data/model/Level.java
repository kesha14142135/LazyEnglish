package com.klg.lazyenglish.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sergejkozin on 10/19/17.
 */

public class Level implements Parcelable {

    private String mName;
    private String mDescription;
    private int mFlag;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Level createFromParcel(Parcel in) {
            return new Level(in);
        }

        public Level[] newArray(int size) {
            return new Level[size];
        }
    };

    public Level(String name, String description, int flag) {
        mName = name;
        mDescription = description;
        mFlag = flag;
    }

    public Level(Parcel in) {
        mName = in.readString();
        mDescription = in.readString();
        mFlag = in.readInt();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int isFlag() {
        return mFlag;
    }

    public void setFlag(int flag) {
        mFlag = flag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mDescription);
        parcel.writeInt(mFlag);
    }
}
