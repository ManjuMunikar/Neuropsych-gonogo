package com.datagrandeur.gonogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.datagrandeur.gonogo.data.DatabaseHelper;
import com.datagrandeur.gonogo.data.Trial;

import java.util.ArrayList;
import java.util.List;

public class TrialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial);

        ImageButton btnTrial = findViewById(R.id.btnTrial);

        DatabaseHelper db = new DatabaseHelper(this);
        Trial trial = db.getConfig(Singleton.getInstance().getTrialId());

        List<String> stimuli = new ArrayList<>();
        stimuli.addAll(db.getStimuluses(trial.getGoFace(), Singleton.getInstance().getLocation() ,trial.getGoFaceCount()));
        stimuli.addAll(db.getStimuluses(trial.getNoGoFace(), Singleton.getInstance().getLocation() ,trial.getNoGoFaceCount()));
        btnTrial.setImageResource(this.getResources().getIdentifier("angryboy1" , "drawable", this.getPackageName()));

        btnTrial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent=new Intent (getApplicationContext(),EndTrialActivity.class);
                startActivity(intent);
            }
        });
    }
}