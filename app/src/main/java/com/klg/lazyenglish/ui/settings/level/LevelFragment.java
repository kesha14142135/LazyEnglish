package com.klg.lazyenglish.ui.settings.level;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.data.model.Level;
import com.klg.lazyenglish.ui.settings.level.adapter.CardFragmentPagerAdapter;
import com.klg.lazyenglish.ui.settings.level.adapter.ShadowTransformer;
import com.klg.lazyenglish.ui.settings.number.WordsActivity;
import com.klg.lazyenglish.ui.settings.time.TimeContract;
import com.klg.lazyenglish.ui.welcome.WelcomeActivity;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class LevelFragment extends Fragment implements LevelContract.View {
    private LevelContract.Presenter mPresenter;

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

        CardFragmentPagerAdapter pagerAdapter = new CardFragmentPagerAdapter(getChildFragmentManager(), dpToPixels(5, getContext()), getLevels());
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
        getActivity().finish();
    }

    private List<Level> getLevels() {
        List<Level> levels = new ArrayList<>();
        levels.add(new Level("Base", "Изучите 300 слов на темы", 2));
        levels.add(new Level("Pre intermediate", "Изучите 1000 слов на темы", 3));
        levels.add(new Level("Intermediate", "Изучите 1500 слов на темы", 4));
        levels.add(new Level("Upper intermediate", "Изучите 500 слов на темы", 5));
        levels.add(new Level("Advance", "Изучите 500 слов на темы", 6));
        return levels;
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
}
