package com.klg.lazyenglish.ui.welcome.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.klg.lazyenglish.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SlideFourFragment extends Fragment {

    //ui element
    @BindView(R.id.image_view_finger)
    ImageView mImageViewFinger;
    @BindView(R.id.image_view_beach)
    ImageView mImageViewBeach;
    //component
    private Context mContext;
    private Animation mAnimation;
    private Animation mAnimationBeach;

    public static SlideFourFragment newInstance() {
        return new SlideFourFragment();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (mAnimationBeach == null || mAnimation == null) {
                mAnimationBeach = AnimationUtils.loadAnimation(mContext,
                        R.anim.anim_image_visible_next_screen);
                mAnimation = AnimationUtils.loadAnimation(mContext,
                        R.anim.anim_image_move_right);
            }
            mImageViewBeach.setVisibility(View.VISIBLE);
            mImageViewFinger.startAnimation(mAnimation);
            mImageViewBeach.startAnimation(mAnimationBeach);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide_four, container, false);
        ButterKnife.bind(this, view);
        mImageViewBeach.setVisibility(View.INVISIBLE);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mImageViewBeach.getAnimation() != null &&
                mImageViewFinger.getAnimation() != null) {
            mImageViewFinger.clearAnimation();
            mImageViewBeach.clearAnimation();
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
}
