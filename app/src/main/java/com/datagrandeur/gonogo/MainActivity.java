package com.datagrandeur.gonogo;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

import com.datagrandeur.gonogo.utils.LocalUtils;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private Singleton singleton = Singleton.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        singleton.setLocation(pref.getString("preferred_location", ""));
        singleton.setLanguage(LocalUtils.getLanguage(singleton.getLocation()));
        LocalUtils.setLanguage(singleton.getLanguage(), getResources());



        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, UserActivity.class));
                finish();
            }
        }, 3000);
    }
}