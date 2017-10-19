package com.klg.lazyenglish.ui.settings.download;

import android.content.Context;

import com.klg.lazyenglish.data.source.AppDataManager;
import com.klg.lazyenglish.data.source.DataManager;

/**
 * Created by sergejkozin on 10/16/17.
 */

public class DownloadPresenter implements DownloadContract.Presenter {

    private DownloadContract.View mView;
    private DataManager mManager;

    public DownloadPresenter(DownloadContract.View view, Context context) {
        mView = view;
        mManager = AppDataManager.getInstance(context);
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void downloadWords() {
        mView.showProgressBar(true);
        mView.showButtonDownload(false);
        mManager.downloadWords(new DataManager.Callback() {
            @Override
            public void onSuccess() {
                mView.showProgressBar(false);
                mView.nextScreen();
            }

            @Override
            public void onFailure() {
                mView.showProgressBar(false);
                mView.showButtonDownload(true);
            }
        });
    }
}
