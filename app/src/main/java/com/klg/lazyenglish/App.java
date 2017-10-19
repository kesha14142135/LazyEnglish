package com.klg.lazyenglish;

import android.app.Application;

import net.gotev.speech.Speech;

import io.realm.Realm;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
