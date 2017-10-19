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

public class SlideFiveFragment extends Fragment {

    //ui
    private ImageView mImageViewFlag;
    //element
    private Context mContext;
    private Animation mAnimation;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            mAnimation = AnimationUtils.loadAnimation(mContext,
                    R.anim.anim_image_rotate_flag);
            mImageViewFlag.startAnimation(mAnimation);
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
        mImageViewFlag = view.findViewById(R.id.image_view_flag);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mAnimation != null) {
            mAnimation.cancel();
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
