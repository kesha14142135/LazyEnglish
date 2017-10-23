package com.klg.lazyenglish.ui.settings.download;

import android.content.Context;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.data.source.AppDataManager;
import com.klg.lazyenglish.data.source.DataManager;
import com.klg.lazyenglish.util.NetworkUtils;

/**
 * Created by sergejkozin on 10/16/17.
 */

public class DownloadPresenter implements DownloadContract.Presenter {

    private DownloadContract.View mView;
    private DataManager mManager;
    private Context mContext;

    public DownloadPresenter(DownloadContract.View view, Context context) {
        mView = view;
        mManager = AppDataManager.getInstance(context);
        mView.setPresenter(this);
        mContext = context;
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
        if (NetworkUtils.isNetworkConnected(mContext)) {
            download();
        } else {
            mView.showError(mContext.getString(R.string.error_internet));
            mView.showButtonDownload(true);
        }
    }

    private void download() {
        mManager.downloadWords(new DataManager.Callback() {
            @Override
            public void onSuccess() {
                mView.showProgressBar(false);
                mView.nextScreen();
            }

            @Override
            public void onFailure() {
                mView.showProgressBar(false);
                mView.showError(mContext.getString(R.string.error_download));
                mView.showButtonDownload(true);
            }
        });
    }
}
