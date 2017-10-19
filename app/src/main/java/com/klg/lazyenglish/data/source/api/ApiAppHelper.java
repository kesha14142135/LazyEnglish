package com.klg.lazyenglish.data.source.api;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.klg.lazyenglish.data.model.Answer;
import com.klg.lazyenglish.data.model.Word;
import com.klg.lazyenglish.data.source.api.retrofit.ApiManager;
import com.klg.lazyenglish.util.rx.SchedulerProvider;

import io.reactivex.Single;

/**
 * Created by sergejkozin on 9/23/17.
 */

public class ApiAppHelper implements ApiHelper {

    @Nullable
    private static ApiAppHelper INSTANCE;
    private ApiManager mManager;
    private SchedulerProvider mScheduler;

    private ApiAppHelper(SchedulerProvider scheduler, Context context) {
        mManager = ApiManager.getInstance();
        mScheduler = scheduler;
    }

    public static ApiAppHelper getInstance(
            @NonNull SchedulerProvider scheduler,
            @NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ApiAppHelper(scheduler, context);
        }
        return INSTANCE;
    }

    @Override
    public Single<Answer<Word>> getWords() {
        return mManager.getService().getWords()
                .subscribeOn(mScheduler.io())
                .observeOn(mScheduler.computation());
    }
}
