package com.klg.lazyenglish.data.source;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.klg.lazyenglish.data.constant.ManagerConstants;
import com.klg.lazyenglish.data.model.Answer;
import com.klg.lazyenglish.data.model.Word;
import com.klg.lazyenglish.data.source.api.ApiAppHelper;
import com.klg.lazyenglish.data.source.database.DbAppHelper;
import com.klg.lazyenglish.data.source.preference.PreferenceAppHelper;
import com.klg.lazyenglish.util.Setting;
import com.klg.lazyenglish.util.rx.AppSchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class AppDataManager implements DataManager {

    @Nullable
    private static AppDataManager INSTANCE;

    private ApiAppHelper mApiHelper;
    private DbAppHelper mDbHelper;
    private PreferenceAppHelper mPrefHelper;
    private AppSchedulerProvider mSheduler;
    private final CompositeDisposable mDisposables = new CompositeDisposable();

    private AppDataManager(Context context) {
        mSheduler = new AppSchedulerProvider();
        mApiHelper = ApiAppHelper.getInstance(mSheduler, context);
        mDbHelper = DbAppHelper.getInstance(context);
        mPrefHelper = PreferenceAppHelper.getInstance(context);
    }

    public static AppDataManager getInstance(
            @NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new AppDataManager(context);
        }
        return INSTANCE;
    }

    @Override
    public void addFirstOpenApp(Boolean flag) {
        mPrefHelper.setFlagFirstOpenApp(flag);
    }

    @Override
    public void addWelcomeScreen(Boolean flag) {
        mPrefHelper.setFlagForWelcomeScreen(flag);
    }

    @Override
    public Boolean getFirstOpenApp() {
        return mPrefHelper.getFlagFirstOpenApp();
    }

    @Override
    public Boolean getWelcomeScreenOpen() {
        return mPrefHelper.getFlagForWelcomeScreen();
    }

    @Override
    public void addSetting(int setting, Setting name) {
        mPrefHelper.setSetting(setting, name);
        mPrefHelper.setStepSettings(
                mPrefHelper.getStepSettings() + 1);
    }

    @Override
    public int getSetting(String name) {
        return mPrefHelper.getStepSettings();
    }

    @Override
    public int getSettingStep() {
        return mPrefHelper.getStepSettings();
    }

    @Override
    public void downloadWords(Callback callback) {
        mApiHelper.getWords()
                .map(this::getWords)
                .observeOn(mSheduler.ui())
                .subscribe(
                        words -> {
                            mDbHelper.addWords(words);
                           // mPrefHelper.setStepSettings(1);
                            callback.onSuccess();
                        },
                        error -> callback.onFailure());
    }

    private List<Word> getWords(Answer<Word> wordAnswer) {
        List<Word> words = new ArrayList<>();
        if (wordAnswer.getSettings().getSuccess() == ManagerConstants.SUCCESS) {
            words = wordAnswer.getData();
        } else {
            rx.Observable.error(new Throwable(ManagerConstants.ERROR_ADD_USER_SERVER));
        }
        return words;
    }

    @Override
    public int getDownloadWords() {
        return 0;
    }
}
