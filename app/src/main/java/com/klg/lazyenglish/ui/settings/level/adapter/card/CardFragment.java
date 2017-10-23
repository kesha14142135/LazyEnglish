package com.klg.lazyenglish.ui.settings.level.adapter.card;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.data.model.Level;
import com.klg.lazyenglish.ui.settings.level.adapter.CallBackLevel;
import com.klg.lazyenglish.ui.settings.level.adapter.CardAdapter;

public class CardFragment extends Fragment implements CardContract.View, View.OnClickListener {
    //ui
    private View mViewLine;
    private CardView mCardView;
    private TextView mTextViewTitle;
    private TextView mTextViewDescription;
    private TextView mTextViewOr;
    private TextView mTextViewVideoDescription;
    private Button mButtonChoose;
    private Button mButtonShowVideo;
    //element
    private final static String LEVEL = "level";
    private CallBackLevel mCallBackIndex;
    private Context mContext;
    private CardContract.Presenter mPresenter;
    private Level mLevel;

    public static Fragment getInstance(Level level) {
        CardFragment f = new CardFragment();
        Bundle args = new Bundle();
        args.putParcelable(LEVEL, level);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        if (context instanceof CallBackLevel) {
            mCallBackIndex = (CallBackLevel) context;
        }
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mLevel = getArguments().getParcelable(LEVEL);
        mPresenter = new CardPresenter(this, mContext);
        View view = inflater.inflate(R.layout.card_view_level, container, false);
        updateViewDependencies(view);
        if (mLevel != null)
            showLevelInfo(mLevel);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter == null) {
            mPresenter = new CardPresenter(this, mContext);
        }
        mPresenter.checkUpdate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter = null;
    }

    @Override
    public void setPresenter(CardContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void updateData(int countVideo) {
        if (mLevel.getCountVideo() <= countVideo) {
            showLevelInfo(mLevel);
        }
    }

    @Override
    public void onClick(View view) {
        if (mLevel != null && mCallBackIndex != null) {
            if (view.getId() == R.id.button_show_video) {
                mCallBackIndex.showVideo(mLevel);
            } else if (view.getId() == R.id.button_card_level) {
                if (mLevel.getCountVideo() <= mPresenter.getCountVideo()) {
                    mCallBackIndex.showNextScreen(mLevel);
                } else {
                    showVideoInformation();
                }
            }
        }
    }

    private void showVideoInformation() {
        mTextViewDescription.setText(mContext.getString(R.string.description_level));
        mTextViewVideoDescription.setVisibility(View.VISIBLE);
        mTextViewVideoDescription.setText(mContext.getString(R.string.description_video_level));
        mTextViewTitle.setVisibility(View.GONE);
        mButtonShowVideo.setVisibility(View.VISIBLE);
        mButtonChoose.setVisibility(View.GONE);
        mTextViewOr.setVisibility(View.VISIBLE);
        mViewLine.setVisibility(View.VISIBLE);
    }

    private void showLevelInfo(Level level) {
        if (level.getCountVideo() > mPresenter.getCountVideo())
            mButtonChoose.setBackgroundColor(
                    mContext.getResources().getColor(R.color.colorGrey));
        mTextViewTitle.setText(level.getName());
        mTextViewTitle.setVisibility(View.VISIBLE);
        mButtonShowVideo.setVisibility(View.GONE);
        mButtonChoose.setText(getContext().getString(R.string.button_used));
        mButtonChoose.setVisibility(View.VISIBLE);
        mTextViewOr.setVisibility(View.GONE);
        mTextViewVideoDescription.setVisibility(View.GONE);
        mTextViewDescription.setText(String.format(
                mContext.getString(R.string.description_level_word),
                level.getCountWords()));
        mViewLine.setVisibility(View.GONE);
    }

    private void updateViewDependencies(View view) {
        mCardView = view.findViewById(R.id.cardView);
        mCardView.setMaxCardElevation(mCardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);
        mTextViewTitle = view.findViewById(R.id.text_view_card_title_level);
        mTextViewDescription = view.findViewById(R.id.text_view_card_description_level);
        mTextViewOr = view.findViewById(R.id.text_view_card_or_level);
        mViewLine = view.findViewById(R.id.view_or);
        mTextViewVideoDescription = view.findViewById(R.id.text_view_description_video_level);
        mButtonChoose = view.findViewById(R.id.button_card_level);
        mButtonChoose.setOnClickListener(this);
        mButtonShowVideo = view.findViewById(R.id.button_show_video);
        mButtonShowVideo.setOnClickListener(this);
    }

    public CardView getCardView() {
        return mCardView;
    }

}