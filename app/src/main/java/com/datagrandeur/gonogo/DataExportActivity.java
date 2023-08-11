package com.datagrandeur.gonogo;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datagrandeur.gonogo.data.DatabaseHelper;
import com.datagrandeur.gonogo.utils.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataExportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_export);


        TextView tvDataExport = findViewById(R.id.tvDataExport);
        setupActionBar();
        tvDataExport.setText("Data Exporting In Progress");
        export();
        tvDataExport.setText("Data export completed");
    }
    private void export() {

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        if(ContextCompat.checkSelfPermission(DataExportActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(DataExportActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }

        Log.w("Data Export", "Created file");
        Cursor result = null;

        File file = new File(Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS), "gonogo.csv");
        try{
            file.createNewFile();
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            result= db.rawQuery("SELECT * FROM response", null);
            csvWriter.writeNext(result.getColumnNames());
            while(result.moveToNext()){
                String arrStr[] ={
                        result.getString(0),
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getString(8),
                        result.getString(9),
                        result.getString(10),
                        result.getString(11)

                };
                csvWriter.writeNext(arrStr);
            }
            csvWriter.close();
            result.close();

            Log.i("Data Export", "Created file");

        }catch (IOException e){
            Log.e("Data Export", e.getMessage(), e);

        }finally {
            if(result!=null && !result.isClosed()){
                result.close();
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            startActivity(new Intent(DataExportActivity.this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
    private void setupActionBar() {
        ViewGroup rootView = (ViewGroup) findViewById(R.id.action_bar_root); //id from appcompat

        if (rootView != null) {
            View view = getLayoutInflater().inflate(R.layout.toolbar_setting, rootView, false);
            rootView.addView(view, 0);

            setSupportActionBar(findViewById(R.id.toolbar));

        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}

