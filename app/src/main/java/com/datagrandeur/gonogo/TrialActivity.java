package com.datagrandeur.gonogo;

import static androidx.fragment.app.FragmentManager.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.datagrandeur.gonogo.data.DatabaseHelper;
import com.datagrandeur.gonogo.data.Trial;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TrialActivity extends AppCompatActivity {
    List<String> stimuli = new ArrayList<>();
    private int currentImageIndex = 0;
    private Timer timer;
    private ImageButton btnTrial;

    private String packageName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial);
        currentImageIndex=0;

        btnTrial = findViewById(R.id.btnTrial);
        packageName = this.getPackageName();

        DatabaseHelper db = new DatabaseHelper(this);
        Trial trial = db.getConfig(Singleton.getInstance().getTrialId());


        stimuli.addAll(db.getStimuluses(trial.getGoFace(), Singleton.getInstance().getLocation() ,trial.getGoFaceCount()));
        stimuli.addAll(db.getStimuluses(trial.getNoGoFace(), Singleton.getInstance().getLocation() ,trial.getNoGoFaceCount()));



        btnTrial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(currentImageIndex >=stimuli.size()){
                    currentImageIndex = 0;
                    Intent intent = new Intent(getApplicationContext(), EndTrialActivity.class);
                    finishAffinity();
                    startActivity(intent);
                }else {
                    showNextImage();
                    currentImageIndex++;
                }

            }
        });

        startTimer();
    }

    private void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(currentImageIndex >= stimuli.size()){
                            currentImageIndex = 0;
                            Intent intent = new Intent(getApplicationContext(), EndTrialActivity.class);
                            finishAffinity();
                            startActivity(intent);
                        }else {
                            showNextImage();
                            currentImageIndex++;
                        }
                    }
                });
            }
        }, 3000, 3000);
    }

    @SuppressLint("RestrictedApi")
    private void showNextImage() {
        Log.d(TAG, "Index:" + currentImageIndex);
        Log.d(TAG, "Index File:" + stimuli.get(currentImageIndex) );
        btnTrial.setImageResource(getResources().getIdentifier(stimuli.get(currentImageIndex), "drawable", packageName));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

}