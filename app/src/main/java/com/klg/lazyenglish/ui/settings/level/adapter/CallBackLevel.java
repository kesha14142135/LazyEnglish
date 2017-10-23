package com.klg.lazyenglish.ui.settings.level.adapter;

import com.klg.lazyenglish.data.model.Level;

/**
 * Created by sergejkozin on 10/19/17.
 */

public interface CallBackLevel {

    void showVideo(Level level);

    void showNextScreen(Level level);
}
