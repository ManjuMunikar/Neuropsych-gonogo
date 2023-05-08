package com.datagrandeur.gonogo.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private final SQLiteDatabase db;
    public static final String DATABASE_NAME = "gonogo.db";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase(); //everytime database create hunna
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //oncreate method called->create table
        db.execSQL(TrialRepository.CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
