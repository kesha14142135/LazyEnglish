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


public class SlideOneFragment extends Fragment {
    //ui element
    @BindView(R.id.image_view_mind)
    ImageView mImageViewMind;
    //component
    private Context mContext;
    private Animation mAnimation;

    public static SlideOneFragment newInstance() {
        return new SlideOneFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide_one, container, false);
        ButterKnife.bind(this, view);
        if (mAnimation == null) {
            mAnimation = AnimationUtils.loadAnimation(mContext,
                    R.anim.anim_image_visible);
        }
        mImageViewMind.startAnimation(mAnimation);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mImageViewMind.getAnimation() != null) {
            mImageViewMind.clearAnimation();
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
