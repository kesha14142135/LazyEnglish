package com.klg.lazyenglish.ui.settings.level;

import com.klg.lazyenglish.base.BasePresenter;
import com.klg.lazyenglish.base.BaseView;
import com.klg.lazyenglish.data.model.Level;

import java.util.List;


/**
 * Created by sergejkozin on 10/16/17.
 */

public interface LevelContract {
    interface View extends BaseView<LevelContract.Presenter> {

        void nextScreen();

    }

    interface Presenter extends BasePresenter {

        void writeLevel(Level level);

        List<Level> getLevels();
    }
}
