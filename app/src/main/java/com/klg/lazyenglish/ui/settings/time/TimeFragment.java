package com.klg.lazyenglish.ui.settings.time;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.ui.home.HomeFragment;
import com.klg.lazyenglish.ui.settings.number.WordsActivity;
import com.klg.lazyenglish.ui.settings.number.WordsContract;

public class TimeFragment extends Fragment implements TimeContract.View {

    private TimeContract.Presenter mPresenter;

    public static TimeFragment newInstance() {
        return new TimeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_time_learn, container, false);
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
    public void setPresenter(TimeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void nextScreen() {
        Intent intent = new Intent(getContext(), HomeFragment.class);
        startActivity(intent);
        getActivity().finish();
    }
}
