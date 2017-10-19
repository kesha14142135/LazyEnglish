package com.klg.lazyenglish.data.source.database;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.klg.lazyenglish.data.model.Word;

import java.util.List;

import io.realm.Realm;

/**
 * Created by sergejkozin on 9/23/17.
 */

public class DbAppHelper implements DbHelper {

    @Nullable
    private static DbAppHelper INSTANCE;

    private DbAppHelper(Context context) {

    }

    public static DbAppHelper getInstance(
            @NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DbAppHelper(context);
        }
        return INSTANCE;
    }

    @Override
    public void addWords(List<Word> words) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(transactionRealm -> transactionRealm.insertOrUpdate(words));
        realm.close();
    }
}
