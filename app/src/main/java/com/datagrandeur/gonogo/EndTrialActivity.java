package com.datagrandeur.gonogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.neuropsych.R;

public class EndTrialActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_trial);
        //todo -> add delay

        int trialId= Singleton.getInstance().getTrialId();
        if(trialId ==8){
            Intent intent= new Intent(getApplicationContext(),ThankYouActivity.class);
            startActivity(intent);

        }else{
            trialId++;
            Singleton.getInstance().setTrialId(trialId);
            Intent intent= new Intent(getApplicationContext(),InstructionActivity2.class);
            startActivity(intent);
        }



        //gettrialid
        //if trial id 8 vaye TYactivity
        //else instruction2 activity
        //else settrial2






    }
}