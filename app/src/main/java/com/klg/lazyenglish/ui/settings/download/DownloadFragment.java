package com.klg.lazyenglish.ui.settings.download;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.ui.home.HomeActivity;
import com.klg.lazyenglish.ui.settings.level.LevelActivity;

import java.time.Duration;

public class DownloadFragment extends Fragment implements DownloadContract.View, Animation.AnimationListener, View.OnClickListener {

    private DownloadContract.Presenter mPresenter;
    private ProgressBar mProgressBar;
    private Button mButtonRepeatDownload;
    private ConstraintLayout mBaseLayout;
    private RelativeLayout mRelativeLayoutFont;
    private ImageView mImageViewMind;
    private Animation mAnimation;

    public static DownloadFragment newInstance() {
        return new DownloadFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_download, container, false);
        updateVIewDependencies(view);
        mAnimation = AnimationUtils.loadAnimation(getContext(),
                R.anim.anim_layout_scala);
        mAnimation.setAnimationListener(this);
        mRelativeLayoutFont.startAnimation(mAnimation);
        return view;
    }

    private void updateVIewDependencies(View view) {
        mProgressBar = view.findViewById(R.id.progress_bar_download);
        mButtonRepeatDownload = view.findViewById(R.id.button_repeat_download);
        mButtonRepeatDownload.setOnClickListener(this);
        mBaseLayout = view.findViewById(R.id.constraint_layout_download);
        mRelativeLayoutFont = view.findViewById(R.id.relative_layout_font);
        mImageViewMind = view.findViewById(R.id.image_view_mind);
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
    public void setPresenter(DownloadContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void nextScreen() {
        Intent intent = new Intent(getActivity(), LevelActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void showError(String message) {
        Snackbar.make(mBaseLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showProgressBar(boolean flag) {
        mProgressBar.setVisibility(View.GONE);
        mImageViewMind.setVisibility(View.GONE);
        if (flag) {
            mImageViewMind.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showButtonDownload(boolean flag) {
        mButtonRepeatDownload.setVisibility(View.GONE);
        if (flag)
            mButtonRepeatDownload.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        mRelativeLayoutFont.setVisibility(View.GONE);
        mPresenter.downloadWords();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onClick(View view) {
        mPresenter.downloadWords();
    }
}
