package com.klg.lazyenglish.ui.welcome;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.ui.home.HomeActivity;
import com.klg.lazyenglish.ui.settings.download.DownloadActivity;
import com.klg.lazyenglish.ui.welcome.adapter.WelcomePagerAdapter;
import com.merhold.extensiblepageindicator.ExtensiblePageIndicator;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener, WelcomeContract.View {

    private WelcomeContract.Presenter mPresenter;
    private Button mButtonSkip, mButtonNext;
    private ViewPager mViewPager;
    private final int COUNT_PAGE = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        mPresenter = new WelcomePresenter(this, this);
        updateViewDependencies();

    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            if (position == COUNT_PAGE - 1) {
                mButtonNext.setText(getString(R.string.start));
                mButtonSkip.setVisibility(View.GONE);
            } else {
                mButtonNext.setText(getString(R.string.next));
                mButtonSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_next: {
                nextScreen();
                break;
            }
            case R.id.button_skip: {
                openSettingsActivity();
                break;
            }
        }
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

    private void updateViewDependencies() {
        WelcomePagerAdapter welcomePagerAdapter;
        mViewPager = findViewById(R.id.view_pager);
        mButtonSkip = findViewById(R.id.button_skip);
        mButtonNext = findViewById(R.id.button_next);
        welcomePagerAdapter = new WelcomePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(welcomePagerAdapter);
        mViewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        mButtonSkip.setOnClickListener(this);
        mButtonNext.setOnClickListener(this);
        ExtensiblePageIndicator pagerIndicator = findViewById(R.id.page_indicator);
        pagerIndicator.initViewPager(mViewPager);

    }

    private int getItem(int i) {
        return mViewPager.getCurrentItem() + i;
    }

    private void nextScreen() {
        int current = getItem(+1);
        if (current < COUNT_PAGE) {
            mViewPager.setCurrentItem(current);
        } else {
            mPresenter.addWelcomeDone();
        }
    }
}
