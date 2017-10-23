package com.klg.lazyenglish.ui.settings.level.adapter.card;

import com.klg.lazyenglish.base.BasePresenter;
import com.klg.lazyenglish.base.BaseView;


/**
 * Created by sergejkozin on 10/22/17.
 */

public interface CardContract {
    interface View extends BaseView<CardContract.Presenter> {

        void updateData(int countVideo);
    }

    interface Presenter extends BasePresenter {

        void checkUpdate();

        int getCountVideo();
    }
}
