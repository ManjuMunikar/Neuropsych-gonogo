package com.datagrandeur.gonogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class InstructionActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction2);

        ImageButton btnInstructionActivity2 = findViewById(R.id.btnInstructionActivity2);

        btnInstructionActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext(),GetReadyActivity.class);
                startActivity(intent);
            }
        });
    }
}