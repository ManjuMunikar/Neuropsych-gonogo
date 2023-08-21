package com.datagrandeur.gonogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class EndTrialActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_trial);
        //todo -> add delay




                //or if(Singleton.getInstance().getTrialId()==8);
                int trialId= Singleton.getInstance().getTrialId();


                if(trialId ==9){
                    Intent intent= new Intent(getApplicationContext(),ThankYouActivity.class);
                    startActivity(intent);

                }else if(trialId==1){
                    trialId++;
                    Singleton.getInstance().setTrialId(trialId);
                    Intent intent= new Intent(getApplicationContext(), GameStartActivity.class);
                    startActivity(intent);
                }else{
                    trialId++;
                    Singleton.getInstance().setTrialId(trialId);
                    Intent intent= new Intent(getApplicationContext(),InstructionActivity2.class);
                    startActivity(intent);
                }
    }
}






        //gettrialid
        //if trial id 8 vaye TYactivity
        //else instruction2 activity
        //else settrial2






