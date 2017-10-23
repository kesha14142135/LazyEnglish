package com.klg.lazyenglish.ui.welcome;

import com.klg.lazyenglish.base.BasePresenter;
import com.klg.lazyenglish.base.BaseView;

/**
 * Created by sergejkozin on 10/8/17.
 */

public interface WelcomeContract {

    interface View extends BaseView<WelcomeContract.Presenter> {

        void openSettingsActivity();
    }

    interface Presenter extends BasePresenter {

        void addWelcomeDone();
    }
}
