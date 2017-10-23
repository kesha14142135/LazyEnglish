package com.klg.lazyenglish.ui.welcome.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.klg.lazyenglish.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SlideFiveFragment extends Fragment implements Animation.AnimationListener {

    //ui element
    @BindView(R.id.image_view_flag)
    ImageView mImageViewFlag;
    //component
    private Context mContext;
    private Animation mAnimationRight;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (mAnimationRight == null) {
                mAnimationRight = AnimationUtils.loadAnimation(mContext,
                        R.anim.anim_image_rotate_flag);
                mAnimationRight.setAnimationListener(this);
            }
            mImageViewFlag.startAnimation(mAnimationRight);
        }
    }

    public static SlideFiveFragment newInstance() {
        return new SlideFiveFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide_five, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mImageViewFlag.getAnimation() != null) {
            mImageViewFlag.clearAnimation();
        }
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
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        mImageViewFlag.startAnimation(animation);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}
