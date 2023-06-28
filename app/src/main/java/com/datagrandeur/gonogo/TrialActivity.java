package com.datagrandeur.gonogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.datagrandeur.gonogo.data.DatabaseHelper;

public class TrialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial);


        ImageButton btnTrial = findViewById(R.id.btnTrial);

        btnTrial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent=new Intent (getApplicationContext(),EndTrialActivity.class);
                startActivity(intent);
            }
        });
    }
}