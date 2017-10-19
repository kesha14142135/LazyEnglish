package com.klg.lazyenglish.ui.settings.number;

import com.klg.lazyenglish.base.BasePresenter;
import com.klg.lazyenglish.base.BaseView;

/**
 * Created by sergejkozin on 10/16/17.
 */

public interface WordsContract {
    interface View extends BaseView<WordsContract.Presenter> {
        void nextScreen();
    }

    interface Presenter extends BasePresenter {
        void writeCountWords(int count);
    }
}
