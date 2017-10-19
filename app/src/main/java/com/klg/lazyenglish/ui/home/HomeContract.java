package com.klg.lazyenglish.ui.home;

import com.klg.lazyenglish.base.BasePresenter;
import com.klg.lazyenglish.base.BaseView;
import com.klg.lazyenglish.data.model.Word;

import java.util.List;

/**
 * Created by sergejkozin on 10/9/17.
 */

public interface HomeContract {
    interface View extends BaseView<HomeContract.Presenter> {
        void showWordsForeignLanguage(List<Word> words);

        void showWordsNativeLanguage(List<Word> words);
    }

    interface Presenter extends BasePresenter {
        void getWords(boolean newWords);

        void setWordChanged(boolean learnLanguages, Word word);

        void getLearnedWords(List<Word> words);
    }
}
