package com.klg.lazyenglish.ui.settings.number;

import android.content.Context;

import com.klg.lazyenglish.data.source.AppDataManager;
import com.klg.lazyenglish.data.source.DataManager;
import com.klg.lazyenglish.util.Setting;

/**
 * Created by sergejkozin on 10/16/17.
 */

public class WordsPresenter implements WordsContract.Presenter {

    private WordsContract.View mView;
    private DataManager mManager;

    public WordsPresenter(WordsContract.View view, Context context) {
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
    public void writeCountWords(int count) {
        mManager.addSetting(count, Setting.COUNT);
        mView.nextScreen();
    }
}
