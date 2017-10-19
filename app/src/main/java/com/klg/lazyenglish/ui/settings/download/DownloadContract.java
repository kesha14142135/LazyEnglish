package com.klg.lazyenglish.ui.settings.download;

import com.klg.lazyenglish.base.BasePresenter;
import com.klg.lazyenglish.base.BaseView;

/**
 * Created by sergejkozin on 10/16/17.
 */

public interface DownloadContract {
    interface View extends BaseView<DownloadContract.Presenter> {

        void nextScreen();

        void showError(String message);

        void showProgressBar(boolean flag);

        void showButtonDownload(boolean flag);
    }

    interface Presenter extends BasePresenter {
        void downloadWords();
    }
}
