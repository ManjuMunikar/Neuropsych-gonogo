package com.datagrandeur.gonogo.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private final SQLiteDatabase db;
    public static final String DATABASE_NAME = "gonogo.db";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase(); //everytime database create hunna
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //oncreate method called->create table
        db.execSQL(TrialRepository.CREATE);
        db.execSQL(TrialResponseRepository.CREATE);
        db.execSQL(UserRepository.CREATE);

        this.insertTrial(new Trial(1,"Practice","practice", "Surprised","Neutral",5, 5), db);
        this.insertTrial(new Trial(2,"Trial 1","trial_1", "Happy","Neutral",20, 10),db);
        this.insertTrial(new Trial(3,"Trial 2","trial_2", "Fearful","Neutral",20, 10),db);
        this.insertTrial(new Trial(4,"Trial 3","trial_3", "Sad","Neutral",20, 10),db);
        this.insertTrial(new Trial(5,"Trial 4","trial_4", "Neutral","Angry",20, 10),db);
        this.insertTrial(new Trial(6,"Trial 5","trial_5", "Neutral","Fearful",20, 10),db);
        this.insertTrial(new Trial(7,"Trial 6","trial_6", "Angry","Neutral",20, 10),db);
        this.insertTrial(new Trial(8,"Trial 7","trial_7", "Neutral","Sad",20, 10),db);
        this.insertTrial(new Trial(9,"Trial 8","trial_8", "Neutral","Happy",20, 10),db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertTrial( Trial trial, SQLiteDatabase db){
        return TrialRepository.insert(trial,db);
    }

    public long insertUser( User user, SQLiteDatabase db){
        return UserRepository.insert(user,db);
    }
}
