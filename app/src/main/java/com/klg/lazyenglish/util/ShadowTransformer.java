package com.klg.lazyenglish.util;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;

import com.klg.lazyenglish.ui.settings.level.adapter.CardAdapter;

public class ShadowTransformer implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer {

    private ViewPager viewPager;
    private CardAdapter cardAdapter;
    private float lastOffset;
    private boolean scalingEnabled;

    public ShadowTransformer(ViewPager viewPager, CardAdapter adapter) {
        this.viewPager = viewPager;
        viewPager.addOnPageChangeListener(this);
        cardAdapter = adapter;
    }

    public void enableScaling(boolean enable) {
        if (scalingEnabled && !enable) {
            CardView currentCard = cardAdapter.getCardView(viewPager.getCurrentItem());
            if (currentCard != null) {
                currentCard.animate().scaleY(1);
                currentCard.animate().scaleX(1);
            }
        } else if (!scalingEnabled && enable) {
            CardView currentCard = cardAdapter.getCardView(viewPager.getCurrentItem());
            if (currentCard != null) {
                currentCard.animate().scaleY(1.1f);
                currentCard.animate().scaleX(1.1f);
            }
        }
        scalingEnabled = enable;
    }

    @Override
    public void transformPage(View page, float position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int realCurrentPosition;
        int nextPosition;
        float baseElevation = cardAdapter.getBaseElevation();
        float realOffset;
        boolean goingLeft = lastOffset > positionOffset;

        if (goingLeft) {
            realCurrentPosition = position + 1;
            nextPosition = position;
            realOffset = 1 - positionOffset;
        } else {
            nextPosition = position + 1;
            realCurrentPosition = position;
            realOffset = positionOffset;
        }

        if (nextPosition > cardAdapter.getCount() - 1
                || realCurrentPosition > cardAdapter.getCount() - 1) {
            return;
        }

        CardView currentCard = cardAdapter.getCardView(realCurrentPosition);

        if (currentCard != null) {
            if (scalingEnabled) {
                currentCard.setScaleX((float) (1 + 0.1 * (1 - realOffset)));
                currentCard.setScaleY((float) (1 + 0.1 * (1 - realOffset)));
            }
            currentCard.setCardElevation((baseElevation + baseElevation
                    * (CardAdapter.MAX_ELEVATION_FACTOR - 1) * (1 - realOffset)));
        }

        CardView nextCard = cardAdapter.getCardView(nextPosition);

        if (nextCard != null) {
            if (scalingEnabled) {
                nextCard.setScaleX((float) (1 + 0.1 * (realOffset)));
                nextCard.setScaleY((float) (1 + 0.1 * (realOffset)));
            }
            nextCard.setCardElevation((baseElevation + baseElevation
                    * (CardAdapter.MAX_ELEVATION_FACTOR - 1) * (realOffset)));
        }
        lastOffset = positionOffset;
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}