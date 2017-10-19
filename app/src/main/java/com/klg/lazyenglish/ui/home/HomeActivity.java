package com.klg.lazyenglish.ui.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.klg.lazyenglish.R;
import com.klg.lazyenglish.util.ActivityUtils;

import net.gotev.speech.Speech;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        HomeFragment homeFragment = (HomeFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frame_layout_base_home);
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    homeFragment, R.id.frame_layout_base_home);
        }
        new HomePresenter(homeFragment, this);
        Speech.init(this, getPackageName());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Speech.getInstance().shutdown();
    }
}
