package com.klg.lazyenglish.ui.settings.download;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.ui.settings.level.LevelFragment;
import com.klg.lazyenglish.ui.settings.level.LevelPresenter;
import com.klg.lazyenglish.util.ActivityUtils;

public class DownloadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        DownloadFragment downloadFragment = (DownloadFragment) getSupportFragmentManager()
                .findFragmentById(R.id.constraint_layout_download_base);
        if (downloadFragment == null) {
            downloadFragment = DownloadFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    downloadFragment, R.id.constraint_layout_download_base);
        }
        new DownloadPresenter(downloadFragment, this);
    }
}
