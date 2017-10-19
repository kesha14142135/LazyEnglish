package com.klg.lazyenglish.ui.splash;

import com.klg.lazyenglish.base.BasePresenter;
import com.klg.lazyenglish.base.BaseView;

/**
 * Created by sergejkozin on 9/28/17.
 */

public interface SplashContract {

    interface View extends BaseView<Presenter> {

        void openHomeActivity();

        void openWelcomeActivity();

        void openSetting(int step);

    }

    interface Presenter extends BasePresenter {

        void firstOpenApp();

    }

}
