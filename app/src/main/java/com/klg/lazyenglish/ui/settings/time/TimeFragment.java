package com.klg.lazyenglish.ui.settings.time;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.ui.home.HomeActivity;
import com.klg.lazyenglish.ui.home.HomeFragment;

import net.steamcrafted.lineartimepicker.dialog.LinearTimePickerDialog;

public class TimeFragment extends Fragment implements TimeContract.View, View.OnClickListener, LinearTimePickerDialog.ButtonCallback {

    private Button mButtonAddClock;
    private TextView mTextViewTime;
    //element
    private TimeContract.Presenter mPresenter;
    private LinearTimePickerDialog mTimePicker;
    private Context mContext;
    private int mHour;
    private int mMinute;

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
        View view = inflater.inflate(R.layout.fragment_time, container, false);
        mTimePicker = LinearTimePickerDialog.Builder.with(mContext)
                .setButtonCallback(this)
                .setPickerBackgroundColor(mContext.getResources().getColor(R.color.colorBlack))
                .setLineColor(mContext.getResources().getColor(R.color.colorWhite))
                .setTextColor(mContext.getResources().getColor(R.color.colorWhite))
                .setShowTutorial(false)
                .build();
        updateViewDependencies(view);
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
    public void setPresenter(TimeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void nextScreen() {
        Intent intent = new Intent(getContext(), HomeActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_next) {
            mPresenter.writeTime(mHour, mMinute);
        } else if (view.getId() == R.id.button_skip) {
            mPresenter.writeTimeSetting();
        } else if (view.getId() == R.id.button_add_clock) {
            mTimePicker.show();
        }
    }

    private void updateViewDependencies(View view) {
        mTextViewTime = view.findViewById(R.id.text_view_time);
        view.findViewById(R.id.button_next).setOnClickListener(this);
        view.findViewById(R.id.button_skip).setOnClickListener(this);
        mButtonAddClock = view.findViewById(R.id.button_add_clock);
        mButtonAddClock.setOnClickListener(this);
    }

    @Override
    public void onPositive(DialogInterface dialog, int hour, int minutes) {
        mHour = hour;
        mMinute = minutes;
        mTextViewTime.setText(String.format(mContext.getString(R.string.format_time), hour, minutes));
    }

    @Override
    public void onNegative(DialogInterface dialog) {

    }
}
