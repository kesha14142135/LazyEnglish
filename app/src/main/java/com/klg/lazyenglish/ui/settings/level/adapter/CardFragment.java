package com.klg.lazyenglish.ui.settings.level.adapter;

import android.annotation.SuppressLint;
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

public class CardFragment extends Fragment {

    private CardView mCardView;
    private final static String LEVEL = "level";

    public static Fragment getInstance(Level level) {
        CardFragment f = new CardFragment();
        Bundle args = new Bundle();
        args.putParcelable(LEVEL, level);
        f.setArguments(args);
        return f;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Level level = getArguments().getParcelable(LEVEL);
        View view = inflater.inflate(R.layout.card_view_level, container, false);

        mCardView = view.findViewById(R.id.cardView);
        mCardView.setMaxCardElevation(mCardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);

        TextView title = view.findViewById(R.id.text_view_card_title_level);
        TextView description = view.findViewById(R.id.text_view_card_description_level);
        Button button = view.findViewById(R.id.button_card_level);

        if (level != null) {
            title.setText(level.getName());
            description.setText(level.getDescription());
            if(level.isFlag()==0){
                button.setText(getContext().getString(R.string.used));
            }else{
                button.setText(getContext().getString(R.string.buy));
            }
        }
        button.setOnClickListener(viewClick -> {
            //send data in adapter
        });
        return view;
    }

    public CardView getmCardView() {
        return mCardView;
    }
}