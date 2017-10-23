package com.klg.lazyenglish.ui.settings.number;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.ui.settings.time.TimeActivity;
import com.klg.lazyenglish.ui.settings.time.TimeFragment;
import com.shawnlin.numberpicker.NumberPicker;

public class WordsFragment extends Fragment implements WordsContract.View, View.OnClickListener {

    private WordsContract.Presenter mPresenter;
    private NumberPicker mNumberPickerWords;


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
        View view = inflater.inflate(R.layout.fragment_words, container, false);
        mNumberPickerWords = view.findViewById(R.id.number_picker_words);
        view.findViewById(R.id.button_next).setOnClickListener(this);
        return view;
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
        Intent intent = new Intent(getContext(), TimeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_next) {
            mPresenter.writeCountWords(mNumberPickerWords.getWheelItemCount());
        }
    }
}
