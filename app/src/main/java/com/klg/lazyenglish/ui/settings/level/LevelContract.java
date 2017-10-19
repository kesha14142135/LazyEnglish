package com.klg.lazyenglish.ui.settings.level;

import com.klg.lazyenglish.base.BasePresenter;
import com.klg.lazyenglish.base.BaseView;


/**
 * Created by sergejkozin on 10/16/17.
 */

public interface LevelContract {
    interface View extends BaseView<LevelContract.Presenter> {
        void nextScreen();

    }

    interface Presenter extends BasePresenter {
        void writeLevel(int level);
    }
}
