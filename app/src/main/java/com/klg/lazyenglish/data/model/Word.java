package com.klg.lazyenglish.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by sergejkozin on 10/9/17.
 */

public class Word extends RealmObject {

    @PrimaryKey
    @SerializedName("word_id")
    @Expose
    private long mId;
    @SerializedName("translate")
    @Expose
    private String mWordRus;
    @SerializedName("name")
    @Expose
    private String mWordEng;
    @SerializedName("transcription")
    @Expose
    private String mDescription;
    @SerializedName("photo_url")
    @Expose
    private String mUrl;
    @SerializedName("id_level")
    @Expose
    private int mType;

    private boolean mLearned;
    private Date mDateOfStudy;
    private int mNumberOfStudies;

    public Word() {
    }

    public Word(String wordRus, String wordEng, String description, String url, int type) {
        mWordRus = wordRus;
        mWordEng = wordEng;
        mDescription = description;
        mUrl = url;
        mType = type;
    }

    public String getWordRus() {
        return mWordRus;
    }

    public void setWordRus(String wordRus) {
        mWordRus = wordRus;
    }

    public String getWordEng() {
        return mWordEng;
    }

    public void setWordEng(String wordEng) {
        mWordEng = wordEng;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public boolean isLearned() {
        return mLearned;
    }

    public void setLearned(boolean learned) {
        mLearned = learned;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public Date getDateOfStudy() {
        return mDateOfStudy;
    }

    public void setDateOfStudy(Date dateOfStudy) {
        mDateOfStudy = dateOfStudy;
    }

    public int getNumberOfStudies() {
        return mNumberOfStudies;
    }

    public void setNumberOfStudies(int numberOfStudies) {
        mNumberOfStudies = numberOfStudies;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }
}
