package com.klg.lazyenglish.data.source.api;

import com.klg.lazyenglish.data.model.Answer;
import com.klg.lazyenglish.data.model.Word;

import io.reactivex.Single;

/**
 * Created by sergejkozin on 9/23/17.
 */

public interface ApiHelper {

    Single<Answer<Word>> getWords();
}
