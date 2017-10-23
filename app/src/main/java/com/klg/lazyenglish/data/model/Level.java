package com.klg.lazyenglish.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sergejkozin on 10/19/17.
 */

public class Level implements Parcelable {

    private int mId;
    private String mName;
    private int mCountWords;
    private int mIndex;
    private int mCountVideo;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Level createFromParcel(Parcel in) {
            return new Level(in);
        }

        public Level[] newArray(int size) {
            return new Level[size];
        }
    };

    public Level(int id, String name, int countWords, int index, int countVideo) {
        mId = id;
        mName = name;
        mCountWords = countWords;
        mIndex = index;
        mCountVideo = countVideo;
    }

    public Level(Parcel in) {
        mId = in.readInt();
        mCountVideo = in.readInt();
        mName = in.readString();
        mCountWords = in.readInt();
        mIndex = in.readInt();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getCountWords() {
        return mCountWords;
    }

    public void setCountWords(int countWords) {
        mCountWords = countWords;
    }

    public int getIndex() {
        return mIndex;
    }

    public void setIndex(int flag) {
        mIndex = flag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mId);
        parcel.writeInt(mCountVideo);
        parcel.writeString(mName);
        parcel.writeInt(mCountWords);
        parcel.writeInt(mIndex);
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getCountVideo() {
        return mCountVideo;
    }

    public void setCountVideo(int countVideo) {
        mCountVideo = countVideo;
    }
}
