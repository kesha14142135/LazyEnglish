package com.klg.lazyenglish.ui.settings.level.adapter.card;

import android.content.Context;

import com.klg.lazyenglish.data.source.AppDataManager;
import com.klg.lazyenglish.data.source.DataManager;

/**
 * Created by sergejkozin on 10/22/17.
 */

public class CardPresenter implements CardContract.Presenter {
    private CardContract.View mView;
    private DataManager mManager;

    public CardPresenter(CardContract.View view, Context context) {
        mView = view;
        mManager = AppDataManager.getInstance(context);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void checkUpdate() {
        mView.updateData(
                mManager.getCountShowVideo());
    }

    @Override
    public int getCountVideo() {
        return mManager.getCountShowVideo();
    }
}
