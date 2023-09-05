package com.datagrandeur.gonogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.datagrandeur.gonogo.data.DatabaseHelper;
import com.datagrandeur.gonogo.data.Trial;


public class InstructionActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction2);

        DatabaseHelper db = new DatabaseHelper(this);
        Trial trial = db.getConfig(Singleton.getInstance().getTrialId());


        ImageButton btnInstructionActivity2 = findViewById(R.id.btnInstructionActivity2);
        String instruction = getString(R.string.instruction2);
        String goFace = "";
        if(getGoFaceStringResource(trial)>0) {
            goFace = getString(getGoFaceStringResource(trial));
        }

        String finalInstruction = "";
        if(trial.getTrialName().equalsIgnoreCase("Practice")){
            finalInstruction = String.format(instruction, goFace, goFace, getString(R.string.tap_practice));
        }else{
            finalInstruction = String.format(instruction, goFace, goFace, getString(R.string.get_ready2));
        }
        TextView tvInstruction = findViewById(R.id.tvInstruction2);
        tvInstruction.setText(finalInstruction);
        btnInstructionActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext(),GetReadyActivity.class);
                startActivity(intent);
            }
        });
    }

    private int getGoFaceStringResource(Trial trial) {

        if("Surprised".equalsIgnoreCase(trial.getGoFace())) {
           return R.string.Surprised;
        }

        if("Angry".equalsIgnoreCase(trial.getGoFace())) {
            return R.string.Angry;
        }

        if("Fearful".equalsIgnoreCase(trial.getGoFace())) {
            return R.string.Fearful;
        }

        if("Happy".equalsIgnoreCase(trial.getGoFace())) {
            return R.string.Happy;
        }

        if("Sad".equalsIgnoreCase(trial.getGoFace())) {
            return R.string.Sad;
        }

        if("Neutral".equalsIgnoreCase(trial.getGoFace())) {
            return R.string.Neutral;
        }

        return 0;
    }

}