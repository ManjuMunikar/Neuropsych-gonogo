package com.datagrandeur.gonogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.datagrandeur.gonogo.data.DatabaseHelper;
import com.datagrandeur.gonogo.data.User;

import java.security.Signature;

public class UserActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Button nextButton = findViewById(R.id.btnShowInstruction);
        final EditText txtUserId = findViewById(R.id.txtUserId);
        final EditText txtFullName = findViewById(R.id.txtFullName);



        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());

                if (TextUtils.isEmpty(txtUserId.getText().toString().trim())) {
                    txtUserId.setError("Required!");
                } else if (TextUtils.isEmpty(txtFullName.getText().toString().trim())) {
                    txtFullName.setError("Required!");
                } else {

                    Singleton.getInstance().setTrialId(1);
                    Singleton.getInstance().setUserId(txtUserId.getText().toString().trim());
                    Singleton.getInstance().setFullName(txtFullName.getText().toString().trim());

                    Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
                    startActivity(intent);

                    User user = new User(Singleton.getInstance().getUserId(),Singleton.getInstance().getFullName());
                    dbHelper.insertUser(user, dbHelper.getDb());

                }
            }
        });

        ImageButton imgBtnSetting= findViewById(R.id.imgBtnSetting);
        imgBtnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(UserActivity.this, AdminActivity.class);
                startActivity(intent);
            }
        });
    }
}