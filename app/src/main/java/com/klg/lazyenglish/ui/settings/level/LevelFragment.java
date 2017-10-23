package com.klg.lazyenglish.ui.settings.level;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.data.model.Level;
import com.klg.lazyenglish.ui.settings.level.adapter.CallBackLevel;
import com.klg.lazyenglish.ui.settings.level.adapter.CardFragmentPagerAdapter;
import com.klg.lazyenglish.util.ShadowTransformer;
import com.klg.lazyenglish.ui.settings.number.WordsActivity;
import com.klg.lazyenglish.ui.video.VideoActivity;

public class LevelFragment extends Fragment implements LevelContract.View, CallBackLevel {

    private LevelContract.Presenter mPresenter;
    private Context mContext;

    public static LevelFragment newInstance() {
        return new LevelFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level, container, false);
        ViewPager viewPager = view.findViewById(R.id.viewPager);

        CardFragmentPagerAdapter pagerAdapter = new CardFragmentPagerAdapter(
                getChildFragmentManager(),
                dpToPixels(2, getContext()),
                mPresenter.getLevels());
        ShadowTransformer fragmentCardShadowTransformer = new ShadowTransformer(viewPager, pagerAdapter);
        fragmentCardShadowTransformer.enableScaling(true);

        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(false, fragmentCardShadowTransformer);
        viewPager.setOffscreenPageLimit(3);
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
    public void setPresenter(LevelContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void nextScreen() {
        Intent intent = new Intent(getContext(), WordsActivity.class);
        startActivity(intent);
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    @Override
    public void showVideo(Level level) {
        Intent intent = new Intent(getContext(), VideoActivity.class);
        intent.putExtra(mContext.getString(R.string.level_send), level);
        startActivity(intent);
    }

    @Override
    public void showNextScreen(Level level) {
        mPresenter.writeLevel(level);
    }
}
