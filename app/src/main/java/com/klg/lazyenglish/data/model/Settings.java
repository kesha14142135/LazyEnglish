package com.klg.lazyenglish.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sergejkozin on 8/29/17.
 */

public class Settings {

    @SerializedName("success")
    @Expose
    private int mSuccess;
    @SerializedName("message")
    @Expose
    private String mMessage;
    @SerializedName("fields")
    @Expose
    private List<String> mFields = null;

    public int getSuccess() {
        return mSuccess;
    }

    public void setSuccess(int success) {
        mSuccess = success;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public List<String> getFields() {
        return mFields;
    }

    public void setFields(List<String> fields) {
        mFields = fields;
    }
}
