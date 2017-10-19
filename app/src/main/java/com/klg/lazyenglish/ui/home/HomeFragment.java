package com.klg.lazyenglish.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.data.model.Word;
import com.klg.lazyenglish.ui.home.adapter.SwipeStackLearnLanguageAdapter;
import com.klg.lazyenglish.ui.home.adapter.SwipeStackNativeLanguageAdapter;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.SwipeDirection;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeContract.View, CardStackView.CardEventListener, View.OnClickListener {

    //
    private List<Word> mWords;
    private CardStackView mCardStack;
    private HomeContract.Presenter mPresenter;
    private Context mContext;
    private boolean mRepeatTodayWords = true;
    private boolean mRepeatWordsForeignLanguage = true;
    private ArrayAdapter<Word> mAdapter;
    //ui
    private Button mButtonRepeatNewWords;
    private Button mButtonRepeatNewWordsRus;
    private Button mButtonRepeatWords;
    private Button mButtonRepeatWordsRus;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        updateViewDependencies(view);
        mWords = new ArrayList<>();
        mPresenter.getWords(mRepeatTodayWords);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onCardDragging(float percentX, float percentY) {

    }

    @Override
    public void onCardSwiped(SwipeDirection direction) {
        if (direction.name().equals(mContext.getString(R.string.left_swipe))) {
            mWords.add(mAdapter.getItem(mCardStack.getTopIndex() - 1));
        } else if (direction.name().equals(mContext.getString(R.string.right_swipe))) {
            if (mAdapter.getCount() == mCardStack.getTopIndex()) {
                showActions();
            }
            mPresenter.setWordChanged(mRepeatWordsForeignLanguage,
                    mAdapter.getItem(mCardStack.getTopIndex() - 1));
        }
        if (mCardStack.getTopIndex() == mAdapter.getCount() - 1 ||
                mAdapter.getCount() == mCardStack.getTopIndex()) {
            paginate();
            mWords.clear();
        }
    }

    private void showActions() {
        mButtonRepeatNewWords.setVisibility(View.VISIBLE);
        mButtonRepeatNewWordsRus.setVisibility(View.VISIBLE);
        mButtonRepeatWords.setVisibility(View.VISIBLE);
        mButtonRepeatWordsRus.setVisibility(View.VISIBLE);
    }

    private void hideActions() {
        mButtonRepeatNewWords.setVisibility(View.GONE);
        mButtonRepeatNewWordsRus.setVisibility(View.GONE);
        mButtonRepeatWords.setVisibility(View.GONE);
        mButtonRepeatWordsRus.setVisibility(View.GONE);
    }

    @Override
    public void onCardReversed() {

    }

    @Override
    public void onCardMovedToOrigin() {

    }

    @Override
    public void onCardClicked(int index) {

    }


    @Override
    public void showWordsForeignLanguage(List<Word> words) {
        mAdapter = new SwipeStackLearnLanguageAdapter(getContext());
        mAdapter.addAll(words);
        mCardStack.setAdapter(mAdapter);
        mCardStack.setVisibility(View.VISIBLE);
        hideActions();
    }

    @Override
    public void showWordsNativeLanguage(List<Word> words) {
        mAdapter = new SwipeStackNativeLanguageAdapter(getContext());
        mAdapter.addAll(words);
        mCardStack.setAdapter(mAdapter);
        mCardStack.setVisibility(View.VISIBLE);
        hideActions();
    }

    private void updateViewDependencies(View view) {
        mCardStack = view.findViewById(R.id.activity_main_card_stack_view);
        mCardStack.setCardEventListener(this);
        mButtonRepeatNewWords = view.findViewById(R.id.button_repeat_new_word);
        mButtonRepeatNewWords.setOnClickListener(this);
        mButtonRepeatNewWordsRus = view.findViewById(R.id.button_repeat_new_word_rus);
        mButtonRepeatNewWordsRus.setOnClickListener(this);
        mButtonRepeatWords = view.findViewById(R.id.button_repeat_word);
        mButtonRepeatWords.setOnClickListener(this);
        mButtonRepeatWordsRus = view.findViewById(R.id.button_repeat_word_rus);
        mButtonRepeatWordsRus.setOnClickListener(this);

    }

    private void paginate() {
        mCardStack.setPaginationReserved();
        mAdapter.addAll(mWords);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_repeat_new_word: {
                mRepeatTodayWords = false;
                mRepeatWordsForeignLanguage = true;
                break;
            }
            case R.id.button_repeat_new_word_rus: {
                mRepeatTodayWords = false;
                mRepeatWordsForeignLanguage = false;
                break;
            }
            case R.id.button_repeat_word: {
                mRepeatTodayWords = true;
                mRepeatWordsForeignLanguage = true;
                break;
            }
            case R.id.button_repeat_word_rus: {
                mRepeatTodayWords = true;
                mRepeatWordsForeignLanguage = false;
                break;
            }
        }
        mPresenter.getWords(mRepeatTodayWords);
    }
}
