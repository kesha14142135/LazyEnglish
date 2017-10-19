package com.klg.lazyenglish.ui.settings.level;

import android.content.Context;

import com.klg.lazyenglish.data.source.AppDataManager;
import com.klg.lazyenglish.data.source.DataManager;
import com.klg.lazyenglish.util.Setting;

/**
 * Created by sergejkozin on 10/16/17.
 */

public class LevelPresenter implements LevelContract.Presenter {

    private LevelContract.View mView;
    private DataManager mManager;

    public LevelPresenter(LevelContract.View view, Context context) {
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
    public void writeLevel(int level) {
        mManager.addSetting(level, Setting.LEVEL);
        mView.nextScreen();
    }
}
