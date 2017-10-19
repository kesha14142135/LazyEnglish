package com.klg.lazyenglish.ui.welcome.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.klg.lazyenglish.ui.welcome.fragment.SlideFiveFragment;
import com.klg.lazyenglish.ui.welcome.fragment.SlideFourFragment;
import com.klg.lazyenglish.ui.welcome.fragment.SlideOneFragment;
import com.klg.lazyenglish.ui.welcome.fragment.SlideThreeFragment;
import com.klg.lazyenglish.ui.welcome.fragment.SlideTwoFragment;

import java.util.ArrayList;
import java.util.List;

public class WelcomePagerAdapter extends FragmentPagerAdapter {

    private List<android.support.v4.app.Fragment> mFragments;

    public WelcomePagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = addFragmentsToSwipe();
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    private List<Fragment> addFragmentsToSwipe() {
        List<Fragment> fragment = new ArrayList<>();
        fragment.add(SlideOneFragment.newInstance());
        fragment.add(SlideTwoFragment.newInstance());
        fragment.add(SlideThreeFragment.newInstance());
        fragment.add(SlideFourFragment.newInstance());
        fragment.add(SlideFiveFragment.newInstance());
        return fragment;
    }
}