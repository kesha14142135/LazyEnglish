package com.klg.lazyenglish.ui.settings.level;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.ui.home.HomeFragment;
import com.klg.lazyenglish.ui.home.HomePresenter;
import com.klg.lazyenglish.util.ActivityUtils;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_knowledge);

        LevelFragment levelFragment = (LevelFragment) getSupportFragmentManager()
                .findFragmentById(R.id.constraint_layout_level_base);
        if (levelFragment == null) {
            levelFragment = LevelFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    levelFragment, R.id.constraint_layout_level_base);
        }
        new LevelPresenter(levelFragment, this);
    }
}
