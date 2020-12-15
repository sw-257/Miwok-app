package com.example.miwok;

import android.content.Context;
import android.media.MediaPlayer;

public class Translations {


    private String mDefaultTranslations;
    private String mMiwokTranslations;
    private int mImageResourceId = -1;
    private int mMediaResourceId;

    public Translations(String defaultTranslations, String miwokTranslations, int mediaResourceId) {
        mMediaResourceId = mediaResourceId;
        mDefaultTranslations = defaultTranslations;
        mMiwokTranslations = miwokTranslations;
    }

    public Translations(String defaultTranslations, String miwokTranslations, int imageResourceId, int mediaResourceId) {
        mMediaResourceId = mediaResourceId;
        mDefaultTranslations = defaultTranslations;
        mMiwokTranslations = miwokTranslations;
        mImageResourceId = imageResourceId;
    }

    public String getMiwokTranslations() {
        return mMiwokTranslations;
    }

    public String getDefaultTranslations() {
        return mDefaultTranslations;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getPronunciation() { return mMediaResourceId; }

    public boolean hasImageResourceId() {
        return  (mImageResourceId != -1);
    }
}