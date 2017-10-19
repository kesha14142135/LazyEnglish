package com.klg.lazyenglish.ui.settings.time;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.ui.settings.level.LevelFragment;
import com.klg.lazyenglish.ui.settings.level.LevelPresenter;
import com.klg.lazyenglish.util.ActivityUtils;

public class TimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        TimeFragment timeFragment = (TimeFragment) getSupportFragmentManager()
                .findFragmentById(R.id.constraint_layout_time_base);
        if (timeFragment == null) {
            timeFragment = TimeFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    timeFragment, R.id.constraint_layout_time_base);
        }
        new TimePresenter(timeFragment, this);
    }
}
