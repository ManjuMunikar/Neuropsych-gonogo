package com.datagrandeur.gonogo;

import static androidx.fragment.app.FragmentManager.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.datagrandeur.gonogo.data.DatabaseHelper;
import com.datagrandeur.gonogo.data.Trial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;

public class TrialActivity extends AppCompatActivity {
    List<String> stimuli = new ArrayList<>();
    private int currentImageIndex = -1;
    private CountDownTimer timer;
    private Timer timer2;
    private ImageButton btnTrial;
    private TextView tvMessage;
    private String packageName;
    private Trial trial;

    private boolean tapped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial);
        currentImageIndex = -1;
        tvMessage = findViewById(R.id.tvMessage);
        btnTrial = findViewById(R.id.btnTrial);
        packageName = this.getPackageName();

        DatabaseHelper db = new DatabaseHelper(this);
        trial = db.getConfig(Singleton.getInstance().getTrialId());

        stimuli.addAll(resizeList(db.getStimuluses(trial.getGoFace(), Singleton.getInstance().getLocation(), trial.getGoFaceCount()), trial.getGoFaceCount()));
        stimuli.addAll(resizeList(db.getStimuluses(trial.getNoGoFace(), Singleton.getInstance().getLocation(), trial.getNoGoFaceCount()), trial.getNoGoFaceCount()));

        Collections.shuffle(stimuli);

        btnTrial.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                tapped = true;

//                if (currentImageIndex >= 0) {
//                    System.out.println(trial.getGoFace());
//                    System.out.println(trial.getTrialName());
//
//
//                    if ("Practice".equalsIgnoreCase(trial.getTrialName())) {
//                        if (stimuli.get(currentImageIndex).contains("surprised")) {
//                            tvMessage.setText(R.string.Correct);
//                            tvMessage.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.Green));
//                        } else {
//                            tvMessage.setText(R.string.Incorrect);
//                            tvMessage.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.Red));
//                        }
//                    }
//
//                    System.out.println("Button Pressed:" + stimuli.get(currentImageIndex));
//                }
            }
        });
        btnTrial.setImageResource(R.drawable.startplus);
        new Handler().postDelayed(this::startTimer, 1000);


    }

    private void startTimer() {
        if (currentImageIndex >= stimuli.size() - 1) {
            btnTrial.setImageResource(R.drawable.endplus);
            new Handler().postDelayed(this::endActivity, 1000);
        } else {
            tvMessage.setText("");
            tapped = false;
            currentImageIndex++;
            showNextImage();
            new Handler().postDelayed(this::waitForInput, 500);

        }
    }

    private void waitForInput() {
        btnTrial.setImageResource(R.drawable.startplus);
        new Handler().postDelayed(this::showAnswer, 1000);
    }

    private void showAnswer() {
        if ("Practice".equalsIgnoreCase(trial.getTrialName())) {
            if (isInputCorrect()) {
                tvMessage.setText(R.string.Correct);
                tvMessage.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.Green));
            } else {
                tvMessage.setText(R.string.Incorrect);
                tvMessage.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.Red));
            }
        }
        new Handler().postDelayed(this::startTimer, 500);
    }

    private boolean isInputCorrect() {
        return (stimuli.get(currentImageIndex).contains("surprised") && tapped)
                ||
                (!stimuli.get(currentImageIndex).contains("surprised") && !tapped)
                ;

    }

    private void endActivity() {
        Intent intent = new Intent(getApplicationContext(), EndTrialActivity.class);
        finishAffinity();
        startActivity(intent);
    }

//    private void startTimer() {
//        timer = new Timer();
//
//
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        if(currentImageIndex >= stimuli.size()-1){
//                            Intent intent = new Intent(getApplicationContext(), EndTrialActivity.class);
//                            finishAffinity();
//                            startActivity(intent);
//                        }else {
//
//                            new CountDownTimer(500, 500 ) {
//
//
//                                public void onTick(long millisUntilFinished) {
//                                    currentImageIndex++;
//                                    tvMessage.setText("");
//                                    showNextImage();
//                                }
//
//                                public void onFinish() {
//
//                                    if(currentImageIndex >= stimuli.size()-1) {
//                                        btnTrial.setImageResource(R.drawable.endplus);
//                                    } else {
//                                        btnTrial.setImageResource(R.drawable.trial_plus);
//                                    }
//
//
//
//                                }
//                            }.start();
//
//                        }
//
//                    }
//                });
//            }
//        }, 3000, 3000);
//    }

    @SuppressLint("RestrictedApi")
    private void showNextImage() {

        Log.d(TAG, "Index:" + currentImageIndex);
        Log.d(TAG, "Index File:" + stimuli.get(currentImageIndex) );
        System.out.println("Current Image"+stimuli.get(currentImageIndex));
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

    private List<String> resizeList(List<String> strings, int size) {

        List<String > strList = new ArrayList<>();
        while(strList.size()<=size){
            strList.addAll(strings);
        }

        return strList.subList(0,size);

    }


}