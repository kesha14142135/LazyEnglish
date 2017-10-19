package com.klg.lazyenglish.data.source.database;

import com.klg.lazyenglish.data.model.Word;

import java.util.List;

/**
 * Created by sergejkozin on 9/23/17.
 */

public interface DbHelper {
    void addWords(List<Word> words);
}
