package com.klg.lazyenglish.ui.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.klg.lazyenglish.ui.home.HomeActivity;
import com.klg.lazyenglish.R;
import com.klg.lazyenglish.ui.settings.download.DownloadActivity;
import com.klg.lazyenglish.ui.settings.level.LevelActivity;
import com.klg.lazyenglish.ui.settings.number.WordsActivity;
import com.klg.lazyenglish.ui.settings.time.TimeActivity;
import com.klg.lazyenglish.ui.welcome.WelcomeActivity;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {

    private SplashContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mPresenter = new SplashPresenter(this, this);
        mPresenter.firstOpenApp();
    }

    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }

    @Override
    public void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void openWelcomeActivity() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void openSetting(int step) {
        Intent intent;
        if (step == 0) {
            intent = new Intent(this, DownloadActivity.class);
        } else if (step == 1) {
            intent = new Intent(this, LevelActivity.class);
        } else if (step == 2) {
            intent = new Intent(this, WordsActivity.class);
        } else {
            intent = new Intent(this, TimeActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
