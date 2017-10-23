package com.klg.lazyenglish.data.source.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.klg.lazyenglish.data.constant.PrefConstants;
import com.klg.lazyenglish.util.Setting;

/**
 * Created by sergejkozin on 9/2/17.
 */

public class PreferenceAppHelper implements PreferenceHelper {

    @Nullable
    private static PreferenceAppHelper INSTANCE;

    private SharedPreferences mPreference;

    public static PreferenceAppHelper getInstance(
            @NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new PreferenceAppHelper(context);
        }
        return INSTANCE;
    }

    private PreferenceAppHelper(Context context) {
        mPreference = context.getSharedPreferences(PrefConstants.BASE, Context.MODE_PRIVATE);
    }

    @Override
    public void setFlagForWelcomeScreen(Boolean flag) {
        SharedPreferences.Editor editor = mPreference.edit();
        editor.putBoolean(PrefConstants.WELCOME_SCREEN, flag);
        editor.apply();
    }

    @Override
    public Boolean getFlagForWelcomeScreen() {
        return mPreference.getBoolean(PrefConstants.WELCOME_SCREEN, false);
    }

    @Override
    public void setFlagFirstOpenApp(Boolean flag) {
        SharedPreferences.Editor editor = mPreference.edit();
        editor.putBoolean(PrefConstants.FIRST_OPEN, flag);
        editor.apply();
    }

    @Override
    public Boolean getFlagFirstOpenApp() {
        return mPreference.getBoolean(PrefConstants.FIRST_OPEN, false);
    }

    @Override
    public void setSetting(int setting, Setting name) {
        SharedPreferences.Editor editor = mPreference.edit();
        editor.putInt(String.valueOf(name), 0);
        editor.apply();
    }

    @Override
    public int getSetting(String name) {
        return mPreference.getInt(name, 0);
    }

    @Override
    public void setStepSettings(int setting) {
        SharedPreferences.Editor editor = mPreference.edit();
        editor.putInt(PrefConstants.STEP, setting);
        editor.apply();
    }

    @Override
    public int getStepSettings() {
        return mPreference.getInt(PrefConstants.STEP, 0);
    }
}
