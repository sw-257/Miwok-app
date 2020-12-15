package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Translations> phraseArray = new ArrayList<Translations>();
        phraseArray.add(new Translations("where are you going?","minto wiksus",R.raw.phrase_where_are_you_going));
        phraseArray.add(new Translations("what is your name?","tinne oyaasene",R.raw.phrase_what_is_your_name));
        phraseArray.add(new Translations("my name is...","oyaaset",R.raw.phrase_my_name_is));
        phraseArray.add(new Translations("how are you feeling?","michwkses",R.raw.phrase_how_are_you_feeling));
        phraseArray.add(new Translations("I'm feelin good","kuchi achit",R.raw.phrase_im_feeling_good));
        phraseArray.add(new Translations("are you coming?","eenes'aa",R.raw.phrase_are_you_coming));
        phraseArray.add(new Translations("yes, i'm comin","hee'eenem",R.raw.phrase_yes_im_coming));
        phraseArray.add(new Translations("i'm comin","eenem",R.raw.phrase_im_coming));
        phraseArray.add(new Translations("let's go","yoowutis",R.raw.phrase_lets_go));
        phraseArray.add(new Translations("come here","anni'nem",R.raw.phrase_come_here));

        TranslationsAdapter translationsAdapter = new TranslationsAdapter(this, phraseArray,R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(translationsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Translations translations = phraseArray.get(position);

                if (mediaPlayer != null){
                    mediaPlayer.release();
                }

                mediaPlayer = MediaPlayer.create(Phrases.this,translations.getPronunciation());
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
