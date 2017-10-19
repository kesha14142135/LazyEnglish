package com.klg.lazyenglish.ui.settings.number;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.data.model.Word;
import com.klg.lazyenglish.ui.settings.level.LevelFragment;
import com.klg.lazyenglish.ui.settings.level.LevelPresenter;
import com.klg.lazyenglish.util.ActivityUtils;

public class WordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_words);

        WordsFragment wordsFragment = (WordsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.constraint_layout_word_base);
        if (wordsFragment == null) {
            wordsFragment = WordsFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    wordsFragment, R.id.constraint_layout_word_base);
        }
        new WordsPresenter(wordsFragment, this);
    }
}
