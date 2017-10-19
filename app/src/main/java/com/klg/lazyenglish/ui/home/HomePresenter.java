package com.klg.lazyenglish.ui.home;

import android.content.Context;

import com.klg.lazyenglish.data.model.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergejkozin on 10/9/17.
 */

public class HomePresenter implements HomeContract.Presenter {

    private Context mContext;
    private HomeContract.View mView;


    public HomePresenter(HomeContract.View view, Context context) {
        mView = view;
        mContext = context;
        view.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void getWords(boolean newWords) {
        List<Word> mWords = new ArrayList<>();
        mWords.add(new Word("Бег", "Run", "[run]", "http://www.iconsfind.com/wp-content/uploads/2015/10/20151012_561bae7012ec4-210x210.png",0));
        mWords.add(new Word("Описание, еще какое то слово и вдруг этих слов будит миллион или еще какая то дичь", "Description", "[description]", "http://simpleicon.com/wp-content/uploads/note-2.png",1));
        mWords.add(new Word("Обьект", "Object", "[object]", "http://dreamatico.com/data_images/run/run-6.jpg",2));
        mWords.add(new Word("Клас", "Class", "[class]", "http://dreamatico.com/data_images/run/run-6.jpg",3));
        mWords.add(new Word("Собака", "Dog", "[dog]", "http://www.iconninja.com/files/676/464/947/bulldog-dog-pet-icon.png",0));
        mWords.add(new Word("Кот", "Cat", "[run]", "http://downloadicons.net/sites/default/files/cat-clean-icon-83643.png",1));
        mWords.add(new Word("Олень", "Olen", "[description]", "http://how2educate.com/wp-content/uploads/2012/08/courses_description.jpg",2));
        mWords.add(new Word("Ягуар", "Jaguar", "[object]", "http://dreamatico.com/data_images/run/run-6.jpg",3));
        mWords.add(new Word("Шизик", "Shithik", "[class]", "http://dreamatico.com/data_images/run/run-6.jpg",0));
        mWords.add(new Word("Капля", "Kaply", "[dog]", "https://i.pinimg.com/736x/2d/c7/02/2dc702f5a9fb9311819136a3821dd057--drawings-of-dogs-drawings-in-pencil.jpg",1));
        mView.showWordsForeignLanguage(mWords);
    }

    @Override
    public void setWordChanged(boolean learnLanguages, Word word) {

    }

    @Override
    public void getLearnedWords(List<Word> words) {

    }
}
