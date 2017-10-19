package com.klg.lazyenglish.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.klg.lazyenglish.R;
import com.klg.lazyenglish.data.model.Word;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import net.gotev.speech.Speech;


public class SwipeStackNativeLanguageAdapter extends ArrayAdapter<Word> {

    private Context mContext;
    private int[] mColors;

    public SwipeStackNativeLanguageAdapter(Context context) {
        super(context, 0);
        mContext = context;
        mColors = context.getResources().getIntArray(R.array.array_word);
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        ViewHolder holder;
        if (contentView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.card_rus, parent, false);
            holder = new ViewHolder(contentView);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }

        Word word = getItem(position);
        assert word != null;
        holder.mRelativeLayout.setBackgroundColor(
                mColors[word.getType()]);
        holder.mTextViewWord.setText(word.getWordRus());
        holder.mTextViewHint.setText(mContext.getString(R.string.translate));
        holder.mImageViewHint.setImageBitmap(null);
        holder.mButtonShowHintImage.setVisibility(View.VISIBLE);
        holder.mTextViewHint.setOnClickListener(view ->
            holder.mTextViewHint.setText(word.getWordEng()));
        holder.mButtonSpeech.setOnClickListener(view ->
            Speech.getInstance().say(word.getWordRus()));
        holder.mButtonShowHintImage.setOnClickListener(view -> {
            holder.mButtonShowHintImage.setVisibility(View.GONE);
            final ProgressBar progressView = holder.mProgressBar;
            progressView.setVisibility(View.VISIBLE);
            Picasso.with(mContext)
                    .load(word.getUrl())
                    .resize(150, 150)
                    .into(holder.mImageViewHint, new Callback() {
                        @Override
                        public void onSuccess() {
                            progressView.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError() {
                            holder.mButtonShowHintImage.setVisibility(View.VISIBLE);
                        }
                    });
        });
        return contentView;
    }

    private static class ViewHolder {
        private TextView mTextViewWord;
        private TextView mTextViewHint;
        private ImageView mImageViewHint;
        private Button mButtonShowHintImage;
        private RelativeLayout mRelativeLayout;
        private ProgressBar mProgressBar;
        private Button mButtonSpeech;

        public ViewHolder(View view) {
            mRelativeLayout = view.findViewById(R.id.relative_layout_base_word);
            mTextViewWord = view.findViewById(R.id.text_view_word);
            mTextViewHint = view.findViewById(R.id.text_view_hint);
            mImageViewHint = view.findViewById(R.id.image_view_hint);
            mButtonShowHintImage = view.findViewById(R.id.button_show_hint);
            mProgressBar = view.findViewById(R.id.progress_bar_image);
            mButtonSpeech = view.findViewById(R.id.button_text_to_speech);
        }
    }

}
