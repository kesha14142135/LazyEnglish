package com.klg.lazyenglish.data.source;

import com.klg.lazyenglish.util.Setting;

public interface DataManager {

    void addFirstOpenApp(Boolean flag);

    void addWelcomeScreen(Boolean flag);

    Boolean getFirstOpenApp();

    Boolean getWelcomeScreenOpen();

    void addSetting(int setting, Setting name);

    int getSetting(String name);

    int getSettingStep();

    void downloadWords(Callback callback);

    interface Callback {

        void onSuccess();

        void onFailure();
    }

    int getDownloadWords();
}
