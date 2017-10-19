package com.klg.lazyenglish.ui.settings.number;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.ui.settings.time.TimeContract;
import com.klg.lazyenglish.ui.settings.time.TimeFragment;

public class WordsFragment extends Fragment implements WordsContract.View {

    private WordsContract.Presenter mPresenter;


    public static WordsFragment newInstance() {
        return new WordsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_words, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void setPresenter(WordsContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void nextScreen() {
        Intent intent = new Intent(getContext(), TimeFragment.class);
        startActivity(intent);
        getActivity().finish();
    }
}
