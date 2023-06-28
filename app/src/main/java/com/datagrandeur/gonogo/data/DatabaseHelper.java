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
        db.execSQL(StimulusTable.CREATE);

        this.insertTrial(new Trial(1, "Practice", "practice", "Surprised", "Neutral", 5, 5), db);
        this.insertTrial(new Trial(2, "Trial 1", "trial_1", "Happy", "Neutral", 20, 10), db);
        this.insertTrial(new Trial(3, "Trial 2", "trial_2", "Fearful", "Neutral", 20, 10), db);
        this.insertTrial(new Trial(4, "Trial 3", "trial_3", "Sad", "Neutral", 20, 10), db);
        this.insertTrial(new Trial(5, "Trial 4", "trial_4", "Neutral", "Angry", 20, 10), db);
        this.insertTrial(new Trial(6, "Trial 5", "trial_5", "Neutral", "Fearful", 20, 10), db);
        this.insertTrial(new Trial(7, "Trial 6", "trial_6", "Angry", "Neutral", 20, 10), db);
        this.insertTrial(new Trial(8, "Trial 7", "trial_7", "Neutral", "Sad", 20, 10), db);
        this.insertTrial(new Trial(9, "Trial 8", "trial_8", "Neutral", "Happy", 20, 10), db);

        insertGlobalStimuli(db);
    }


    private void insertGlobalStimuli(SQLiteDatabase db){
        this.insertStimulus(new Stimulus( "angryboy1.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "angryboy2.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "angryboy3.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "angryboy4.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "angryboy5.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "angrygirl1.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "angrygirl2.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "angrygirl3.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "angrygirl4.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "angrygirl5.jpg", "Angry","global"), db);

        this.insertStimulus(new Stimulus( "fearfulboy1.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "fearfulboy2.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "fearfulboy3.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "fearfulboy4.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "fearfulboy5.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "fearfulgirl1.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "fearfulgirl2.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "fearfulgirl3.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "fearfulgirl4.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "fearfulgirl5.jpg", "Fearful","global"), db);

        this.insertStimulus(new Stimulus( "neutralboy1.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "neutralboy2.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "neutralboy3.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "neutralboy4.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "neutralboy5.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "neutralgirl1.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "neurtalgirl2.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "neurtalgirl3.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "neurtalgirl4.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "neurtalgirl5.jpg", "Neutral","global"), db);

        this.insertStimulus(new Stimulus( "happyboy1.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "happyboy2.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "happyboy3.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "happyboy4.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "happyboy5.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "happygirl1.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "happygirl2.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "happygirl3.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "happygirl4.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "happygirl5.jpg", "Happy","global"), db);

        this.insertStimulus(new Stimulus( "sadboy1.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sadboy2.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sadboy3.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sadboy4.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sadboy5.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sadgirl1.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sadgirl2.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sadgirl3.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sadgirl4.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sadgirl5.jpg", "Sad","global"), db);

        this.insertStimulus(new Stimulus( "surprise1.jpg", "Surprise","global"), db);
        this.insertStimulus(new Stimulus( "surprise2.jpg", "Surprise","global"), db);
        this.insertStimulus(new Stimulus( "surprise3.jpg", "Surprise","global"), db);
        this.insertStimulus(new Stimulus( "surprise4.jpg", "Surprise","global"), db);
        this.insertStimulus(new Stimulus( "surprise5.jpg", "Surprise","global"), db);
        this.insertStimulus(new Stimulus( "surprisegirl1.jpg", "Surprise","global"), db);
        this.insertStimulus(new Stimulus( "surprisegirl2.jpg", "Surprise","global"), db);
        this.insertStimulus(new Stimulus( "surprisegirl3.jpg", "Surprise","global"), db);
        this.insertStimulus(new Stimulus( "surprisegirl4.jpg", "Surprise","global"), db);
        this.insertStimulus(new Stimulus( "surprisegirl5.jpg", "Surprise","global"), db);


    }

    public long insertStimulus(Stimulus stimulus, SQLiteDatabase db){
        return StimulusTable.insert(stimulus, db);
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
