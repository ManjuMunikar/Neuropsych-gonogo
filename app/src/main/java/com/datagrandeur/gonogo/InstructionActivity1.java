package com.datagrandeur.gonogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.neuropsych.R;

public class InstructionActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction1);

        ImageButton instructionActivity1 = findViewById(R.id.instructionAcivity1);

        instructionActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent (getApplicationContext(),InstructionActivity2.class);
//                startActivity(intent);
            }
        });
    }
}