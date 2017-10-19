package com.klg.lazyenglish.ui.splash;

import android.content.Context;
import android.support.annotation.NonNull;

import com.klg.lazyenglish.data.source.AppDataManager;

/**
 * Created by sergejkozin on 9/28/17.
 */

public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View mView;
    private AppDataManager mManager;

    SplashPresenter(@NonNull SplashContract.View splashView,
                    Context context) {
        mView = splashView;
        mView.setPresenter(this);
        mManager = AppDataManager.getInstance(context);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void firstOpenApp() {
        if (mManager.getSettingStep() == 4) {
            mView.openHomeActivity();
        } else {
            if (mManager.getWelcomeScreenOpen()) {
                mView.openSetting(mManager.getSettingStep());
            } else {
                mView.openWelcomeActivity();
            }
        }
    }
}
