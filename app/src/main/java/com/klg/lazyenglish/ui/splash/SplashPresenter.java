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
    private Context mContext;

    SplashPresenter(@NonNull SplashContract.View splashView,
                    Context context) {
        mView = splashView;
        mContext = context;
        mView.setPresenter(this);
        mManager = AppDataManager.getInstance(mContext);
    }

    @Override
    public void subscribe() {
        if (mManager == null)
            mManager = AppDataManager.getInstance(mContext);
    }

    @Override
    public void unsubscribe() {
        mManager = null;
    }

    @Override
    public void firstOpenApp() {
        if (mManager.getSettingStep() == 3) {
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
