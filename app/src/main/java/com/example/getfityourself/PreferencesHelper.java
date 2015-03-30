package com.example.getfityourself;

import android.*;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.*
        ;
import android.support.v7.app.ActionBarActivity;

public class PreferencesHelper {

    private SharedPreferences sharedPreferences;
    private Editor editor;

    public PreferencesHelper(Context context) {
        this.sharedPreferences = context.getSharedPreferences("GoFitYourself",context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit(); }

    public String GetPreferences(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void SavePreferences(String key, String value) {

        System.out.println("Saving....");

        editor.putString(key, value);
        editor.commit();

        System.out.println("Saved.");
    }
}