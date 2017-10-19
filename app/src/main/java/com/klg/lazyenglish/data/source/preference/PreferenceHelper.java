package com.klg.lazyenglish.data.source.preference;

import com.klg.lazyenglish.util.Setting;

/**
 * Created by sergejkozin on 9/22/17.
 */

public interface PreferenceHelper {

    void setFlagForWelcomeScreen(Boolean flag);

    Boolean getFlagForWelcomeScreen();

    void setFlagFirstOpenApp(Boolean flag);

    Boolean getFlagFirstOpenApp();

    void setSetting(int setting, Setting name);

    int getSetting(String name);

    void setStepSettings(int setting);

    int getStepSettings();
}
