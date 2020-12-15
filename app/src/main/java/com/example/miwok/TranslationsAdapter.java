package com.example.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class TranslationsAdapter extends ArrayAdapter<Translations> {

    public int mColorResourceId;

    public TranslationsAdapter(Activity context, ArrayList<Translations> translations,int colorResourceId){
        super(context,0, translations);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
//         Check if the existing view is being reused, otherwise inflate the view
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Translations translations = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokWord);
        miwokTextView.setText(translations.getMiwokTranslations());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.defaultWord);
        defaultTextView.setText(translations.getDefaultTranslations());


        ImageView numberImageView = (ImageView) listItemView.findViewById(R.id.image);
        if (translations.hasImageResourceId()) {
            numberImageView.setImageResource(translations.getImageResourceId());
        }
        else
            numberImageView.setVisibility(View.GONE);

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.textContainer);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

//        Button button = listItemView.findViewById(R.id.start);
//        button.setBackgroundColor(color);
//        return super.getView(position, convertView, parent);
        return listItemView;
    }


}
