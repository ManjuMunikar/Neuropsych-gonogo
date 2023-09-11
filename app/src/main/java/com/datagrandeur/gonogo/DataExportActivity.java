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
import com.datagrandeur.gonogo.utils.DateUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DataExportActivity extends AppCompatActivity {
    TextView tvDataExport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_export);


        tvDataExport= findViewById(R.id.tvDataExport);
        setupActionBar();
        export();
    }
    private void export() {

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        if(ContextCompat.checkSelfPermission(DataExportActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(DataExportActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }

        tvDataExport.setText("Data Exporting In Progress");

        Log.w("Data Export", "Created file");

        Cursor result = null;

        File file = new File(Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS), "gonogo.csv");
        try{
            file.createNewFile();
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            result= db.rawQuery("SELECT * FROM response", null);
            csvWriter.writeNext(appendArray(result.getColumnNames(), new String[] {"start_time", "end_time", "user_input_time","user_input_duration"}));
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
                        result.getString(11),
                        DateUtils.getDate(result.getLong(8)),
                        DateUtils.getDate(result.getLong(9)),
                        result.getLong(10) > result.getLong(8) ?  DateUtils.getDate(result.getLong(10)): "",
                        result.getLong(10) > result.getLong(8) ? String.valueOf((result.getLong(10) - result.getLong(8))) :""
                };
                csvWriter.writeNext(arrStr);
            }
            csvWriter.close();
            result.close();

            Log.i("Data Export", "Created file");
            tvDataExport.setText("Data export completed");

        }catch (IOException e){
            Log.e("Data Export", e.getMessage(), e);
            tvDataExport.setText("Failed to export data.");
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

    public String[] appendArray(String[] array1, String[] array2)
    {
        int length1 = array1.length;
        int length2 = array2.length;
        int mergedLength = length1 + length2;

        String[] mergedArray = new String[mergedLength];

        // Copying elements from array1
        System.arraycopy(array1, 0, mergedArray, 0, length1);

        // Copying elements from array2
        System.arraycopy(array2, 0, mergedArray, length1, length2);

        return mergedArray;
    }
}

