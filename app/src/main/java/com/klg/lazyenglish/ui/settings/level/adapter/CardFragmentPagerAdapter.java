package com.klg.lazyenglish.ui.settings.level.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;

import com.klg.lazyenglish.data.model.Level;
import com.klg.lazyenglish.ui.settings.level.adapter.card.CardFragment;

import java.util.ArrayList;
import java.util.List;

public class CardFragmentPagerAdapter extends FragmentStatePagerAdapter implements CardAdapter {

    private List<CardFragment> mFragments;
    private float mBaseElevation;
    private List<Level> mLevels;

    public CardFragmentPagerAdapter(FragmentManager fm, float baseElevation, List<Level> levels) {
        super(fm);
        mFragments = new ArrayList<>();
        mBaseElevation = baseElevation;
        mLevels = levels;
        for (int i = 0; i < mLevels.size(); i++) {
            addCardFragment(new CardFragment());
        }
    }

    @Override
    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardView(int position) {
        return mFragments.get(position).getCardView();
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return CardFragment.getInstance(mLevels.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        mFragments.set(position, (CardFragment) fragment);
        return fragment;
    }

    private void addCardFragment(CardFragment fragment) {
        mFragments.add(fragment);
    }

}