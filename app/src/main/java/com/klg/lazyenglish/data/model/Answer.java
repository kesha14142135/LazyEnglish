package com.klg.lazyenglish.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sergejkozin on 9/4/17.
 */

public class Answer<T> {

    @SerializedName("settings")
    @Expose
    private Settings mSettings;

    @SerializedName("data")
    @Expose
    private List<T> mData = null;

    public Settings getSettings() {
        return mSettings;
    }

    public void setSettings(Settings settings) {
        mSettings = settings;
    }

    public List<T> getData() {
        return mData;
    }

    public void setData(List<T> data) {
        mData = data;
    }
}
