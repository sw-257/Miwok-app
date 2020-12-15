package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Translations> familyList = new ArrayList<Translations>();

        familyList.add(new Translations("father","epe",R.drawable.family_father,R.raw.family_father));
        familyList.add(new Translations("mother","eta",R.drawable.family_mother,R.raw.family_mother));
        familyList.add(new Translations("son","angsi",R.drawable.family_son,R.raw.family_son));
        familyList.add(new Translations("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        familyList.add(new Translations("old bro","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        familyList.add(new Translations("young bro","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        familyList.add(new Translations("old sis","tele",R.drawable.family_older_sister,R.raw.family_older_sister));
        familyList.add(new Translations("young sis","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        familyList.add(new Translations("granny","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        familyList.add(new Translations("grandpa","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

        TranslationsAdapter translationsAdapter = new TranslationsAdapter(this,familyList,R.color.category_family);
        ListView family = (ListView) findViewById(R.id.list);
        family.setAdapter(translationsAdapter);

        family.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Translations translations = familyList.get(position);

                if (mediaPlayer != null){
                    mediaPlayer.release();
                }

                mediaPlayer = MediaPlayer.create(FamilyMembers.this, translations.getPronunciation());
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
