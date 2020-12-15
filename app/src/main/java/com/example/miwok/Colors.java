package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final ArrayList<Translations> colorsArray = new ArrayList<Translations>();

        colorsArray.add(new Translations("red","wetetti",R.drawable.color_red,R.raw.color_red));
        colorsArray.add(new Translations("green","chokokki",R.drawable.color_green,R.raw.color_green));
        colorsArray.add(new Translations("brown","takaakki",R.drawable.color_brown,R.raw.color_brown));
        colorsArray.add(new Translations("gray","topoppi",R.drawable.color_gray,R.raw.color_gray));
//        colorsArray.add(new Translations("black","kululli",R.drawable.color_black,R.raw.color_black));
        colorsArray.add(new Translations("white","kelelli",R.drawable.color_white,R.raw.color_white));
        colorsArray.add(new Translations("dusty yellow","topiise",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        colorsArray.add(new Translations("mustard yellow","chiwiite",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        TranslationsAdapter translationsAdapter = new TranslationsAdapter(this,colorsArray,R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(translationsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Translations translations = colorsArray.get(position);

                if (mediaPlayer != null){
                    mediaPlayer.release();
                }

                 mediaPlayer = MediaPlayer.create(Colors.this, translations.getPronunciation());
                mediaPlayer.start();


                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.release();
                    }
                });
            }
        });
    }
}
