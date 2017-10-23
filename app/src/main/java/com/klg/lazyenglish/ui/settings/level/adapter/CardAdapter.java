package com.klg.lazyenglish.ui.settings.level.adapter;

import android.support.v7.widget.CardView;

public interface CardAdapter {

    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardView(int position);

    int getCount();
}