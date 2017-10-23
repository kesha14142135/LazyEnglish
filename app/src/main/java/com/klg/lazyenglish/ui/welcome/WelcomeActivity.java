package com.klg.lazyenglish.ui.welcome;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.ui.settings.download.DownloadActivity;
import com.klg.lazyenglish.ui.welcome.adapter.WelcomePagerAdapter;
import com.merhold.extensiblepageindicator.ExtensiblePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity implements WelcomeContract.View, ViewPager.OnPageChangeListener {
    //ui element
    @BindView(R.id.button_skip)
    Button mButtonSkip;
    @BindView(R.id.button_next)
    Button mButtonNext;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    //component
    private WelcomeContract.Presenter mPresenter;
    private final int COUNT_PAGE = 5;
    private final int STEP = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        ButterKnife.bind(this);
        mPresenter = new WelcomePresenter(this, this);
        updateViewDependencies();
    }

    @OnClick(R.id.button_next)
    public void onClickNext(View view) {
        int current = getItem(+STEP);
        if (current < COUNT_PAGE) {
            mViewPager.setCurrentItem(current);
        } else {
            mPresenter.addWelcomeDone();
        }
    }

    @OnClick(R.id.button_skip)
    public void onClickSkip(View view) {
        mPresenter.addWelcomeDone();
    }

    @Override
    public void setPresenter(WelcomeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void openSettingsActivity() {
        startActivity(new Intent(this, DownloadActivity.class));
        finish();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        pageSelected(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void updateViewDependencies() {
        WelcomePagerAdapter welcomePagerAdapter;
        welcomePagerAdapter = new WelcomePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(welcomePagerAdapter);
        mViewPager.addOnPageChangeListener(this);
        ExtensiblePageIndicator pagerIndicator = findViewById(R.id.page_indicator);
        pagerIndicator.initViewPager(mViewPager);
    }

    private int getItem(int i) {
        return mViewPager.getCurrentItem() + i;
    }

    private void pageSelected(int position) {
        if (position == COUNT_PAGE - STEP) {
            mButtonNext.setText(getString(R.string.start));
            mButtonSkip.setVisibility(View.GONE);
        } else {
            mButtonNext.setText(getString(R.string.next));
            mButtonSkip.setVisibility(View.VISIBLE);
        }
    }
}
