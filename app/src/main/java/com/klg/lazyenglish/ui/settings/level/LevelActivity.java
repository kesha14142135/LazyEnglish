package com.klg.lazyenglish.ui.settings.level;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.data.model.Level;
import com.klg.lazyenglish.ui.settings.level.adapter.CallBackLevel;
import com.klg.lazyenglish.util.ActivityUtils;

public class LevelActivity extends AppCompatActivity implements CallBackLevel {
    private LevelFragment mLevelFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_knowledge);

        mLevelFragment = (LevelFragment) getSupportFragmentManager()
                .findFragmentById(R.id.constraint_layout_level_base);
        if (mLevelFragment == null) {
            mLevelFragment = LevelFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    mLevelFragment, R.id.constraint_layout_level_base);
        }
        new LevelPresenter(mLevelFragment, this);
    }

    @Override
    public void showVideo(Level level) {
        mLevelFragment.showVideo(level);
    }

    @Override
    public void showNextScreen(Level level) {
        mLevelFragment.showNextScreen(level);
    }
}
