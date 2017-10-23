package com.klg.lazyenglish.ui.settings.time;

import android.content.Context;

import com.klg.lazyenglish.data.source.AppDataManager;
import com.klg.lazyenglish.data.source.DataManager;
import com.klg.lazyenglish.util.Setting;

/**
 * Created by sergejkozin on 10/16/17.
 */

public class TimePresenter implements TimeContract.Presenter {

    private TimeContract.View mView;
    private DataManager mManager;
    private static final int TIME = -1;


    public TimePresenter(TimeContract.View view, Context context) {
        mView = view;
        view.setPresenter(this);
        mManager = AppDataManager.getInstance(context);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void writeTime(int hour, int minute) {
        mManager.addSetting(hour, Setting.TIME);
        mView.nextScreen();
    }

    @Override
    public void writeTimeSetting() {
        mManager.addSetting(TIME, Setting.TIME);
    }
}
