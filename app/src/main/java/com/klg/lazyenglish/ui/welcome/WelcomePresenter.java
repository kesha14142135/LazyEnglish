package com.klg.lazyenglish.ui.welcome;

import android.content.Context;

import com.klg.lazyenglish.data.source.AppDataManager;
import com.klg.lazyenglish.data.source.DataManager;

/**
 * Created by sergejkozin on 10/8/17.
 */

public class WelcomePresenter implements WelcomeContract.Presenter {

    private WelcomeContract.View mView;
    private DataManager mManager;

    public WelcomePresenter(WelcomeContract.View view, Context context) {
        mView = view;
        mManager = AppDataManager.getInstance(context);
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void addWelcomeDone() {
        mManager.addWelcomeScreen(true);
        mView.openSettingsActivity();
    }
}
