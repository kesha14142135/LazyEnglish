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

public class SlideThreeFragment extends Fragment {

    //ui element
    @BindView(R.id.image_view_finger)
    ImageView mImageViewFinger;
    @BindView(R.id.image_view_dog)
    ImageView mImageViewDog;
    //component
    private Context mContext;
    private Animation mAnimation;
    private Animation mAnimationDog;

    public static SlideThreeFragment newInstance() {
        return new SlideThreeFragment();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (mAnimation == null || mAnimationDog == null)
                mAnimationDog = AnimationUtils.loadAnimation(mContext,
                        R.anim.anim_image_visible_next_screen);
            mAnimation = AnimationUtils.loadAnimation(mContext,
                    R.anim.anim_image_move_left);

            mImageViewFinger.startAnimation(mAnimation);
            mImageViewDog.setVisibility(View.VISIBLE);
            mImageViewDog.startAnimation(mAnimationDog);
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide_three, container, false);
        ButterKnife.bind(this, view);
        mImageViewDog.setVisibility(View.INVISIBLE);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mImageViewDog.getAnimation() == null &&
                mImageViewDog.getAnimation() == null) {
            mImageViewDog.clearAnimation();
            mImageViewFinger.clearAnimation();
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
