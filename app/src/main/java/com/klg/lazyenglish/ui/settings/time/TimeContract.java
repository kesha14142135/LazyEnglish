package com.klg.lazyenglish.ui.settings.time;

import com.klg.lazyenglish.base.BasePresenter;
import com.klg.lazyenglish.base.BaseView;
import com.klg.lazyenglish.ui.settings.number.WordsContract;

/**
 * Created by sergejkozin on 10/16/17.
 */

public interface TimeContract {
    interface View extends BaseView<TimeContract.Presenter> {
        void nextScreen();
    }

    interface Presenter extends BasePresenter {
        void writeTime(int time);
    }
}
