package com.klg.lazyenglish.data.source.api.retrofit;

import com.klg.lazyenglish.data.model.Answer;
import com.klg.lazyenglish.data.model.Word;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface DataApi {

    @GET("get_words")
    Single<Answer<Word>> getWords();
}
