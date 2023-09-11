package com.datagrandeur.gonogo.data;

import static androidx.fragment.app.FragmentManager.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private final SQLiteDatabase db;
    public static final String DATABASE_NAME = "gonogo_000101.db";
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
        db.execSQL(ResponseTable.CREATE);


        this.insertTrial(new Trial(1, "Practice", "practice1", "Surprised", "Neutral", 5, 5), db);
        this.insertTrial(new Trial(2, "Practice", "practice2", "Surprised", "Neutral", 5, 5), db);
        this.insertTrial(new Trial(3, "Trial 1", "trial_1", "Happy", "Neutral", 20, 10), db);
        this.insertTrial(new Trial(4, "Trial 2", "trial_2", "Fearful", "Neutral", 20, 10), db);
        this.insertTrial(new Trial(5, "Trial 3", "trial_3", "Sad", "Neutral", 20, 10), db);
        this.insertTrial(new Trial(6, "Trial 4", "trial_4", "Neutral", "Angry", 20, 10), db);
        this.insertTrial(new Trial(7, "Trial 5", "trial_5", "Neutral", "Fearful", 20, 10), db);
        this.insertTrial(new Trial(8, "Trial 6", "trial_6", "Angry", "Neutral", 20, 10), db);
        this.insertTrial(new Trial(9, "Trial 7", "trial_7", "Neutral", "Sad", 20, 10), db);
        this.insertTrial(new Trial(10, "Trial 8", "trial_8", "Neutral", "Happy", 20, 10), db);

        insertGlobalStimuli(db);
        insertNepalStimuli(db);
        insertColombiaStimuli(db);
        insertSouthAfricaAfrikaansStimuli(db);
        insertSouthAfricaIsiXhosaStimuli(db);

    }

    private void insertGlobalStimuli(SQLiteDatabase db){
        this.insertStimulus(new Stimulus( "sa_angry_boy_1.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "sa_angry_boy_2.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "sa_angry_boy_3.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "sa_angry_boy_4.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "sa_angry_boy_5.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_1.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_2.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_3.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_4.jpg", "Angry","global"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_5.jpg", "Angry","global"), db);

        this.insertStimulus(new Stimulus( "sa_fearful_boy_1.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_boy_2.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_boy_3.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_boy_4.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_boy_5.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_1.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_2.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_3.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_4.jpg", "Fearful","global"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_5.jpg", "Fearful","global"), db);

        this.insertStimulus(new Stimulus( "sa_neutral_boy_1.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_boy_2.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_boy_3.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_boy_4.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_boy_5.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_1.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_2.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_3.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_4.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_5.jpg", "Neutral","global"), db);

        this.insertStimulus(new Stimulus( "sa_happy_boy_1.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "sa_happy_boy_2.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "sa_happy_boy_3.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "sa_happy_boy_4.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "sa_happy_boy_5.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_1.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_2.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_3.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_4.jpg", "Happy","global"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_5.jpg", "Happy","global"), db);

        this.insertStimulus(new Stimulus( "sa_sad_boy_1.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sa_sad_boy_2.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sa_sad_boy_3.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sa_sad_boy_4.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sa_sad_boy_5.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_1.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_2.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_3.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_4.jpg", "Sad","global"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_5.jpg", "Sad","global"), db);

        this.insertStimulus(new Stimulus( "sa_surprised_boy_1.png", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_boy_2.png", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_boy_3.png", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_boy_4.png", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_boy_5.png", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_1.png", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_2.jpg", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_3.jpg", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_4.jpg", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_5.jpg", "Surprised","global"), db);



    }

    private void insertNepalStimuli(SQLiteDatabase db){
        this.insertStimulus(new Stimulus( "np_angry_boy_1.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "np_angry_boy_2.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "np_angry_boy_3.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "np_angry_boy_4.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "np_angry_boy_5.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "np_angry_girl_1.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "np_angry_girl_2.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "np_angry_girl_3.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "np_angry_girl_4.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "np_angry_girl_5.jpg", "Angry","nepal"), db);

        this.insertStimulus(new Stimulus( "np_fearful_boy_1.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "np_fearful_boy_2.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "np_fearful_boy_3.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "np_fearful_boy_4.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "np_fearful_boy_5.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "np_fearful_girl_1.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "np_fearful_girl_2.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "np_fearful_girl_3.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "np_fearful_girl_4.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "np_fearful_girl_5.jpg", "Fearful","nepal"), db);

        this.insertStimulus(new Stimulus( "np_neutral_boy_1.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "np_neutral_boy_2.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "np_neutral_boy_3.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "np_neutral_boy_4.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "np_neutral_boy_5.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "np_neutral_girl_1.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "np_neutral_girl_2.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "np_neutral_girl_3.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "np_neutral_girl_4.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "np_neutral_girl_5.jpg", "Neutral","nepal"), db);

        this.insertStimulus(new Stimulus( "np_happy_boy_1.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "np_happy_boy_2.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "np_happy_boy_3.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "np_happy_boy_4.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "np_happy_boy_5.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "np_happy_girl_1.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "np_happy_girl_2.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "np_happy_girl_3.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "np_happy_girl_4.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "np_happy_girl_5.jpg", "Happy","nepal"), db);

        this.insertStimulus(new Stimulus( "np_sad_boy_1.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "np_sad_boy_2.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "np_sad_boy_3.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "np_sad_boy_4.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "np_sad_boy_5.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "np_sad_girl_1.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "np_sad_girl_2.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "np_sad_girl_3.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "np_sad_girl_4.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "np_sad_girl_5.jpg", "Sad","nepal"), db);

        this.insertStimulus(new Stimulus( "np_surprised_boy_1.png", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "np_surprised_boy_2.png", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "np_surprised_boy_3.png", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "np_surprised_boy_4.png", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "np_surprised_boy_5.png", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "np_surprised_girl_1.png", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "np_surprised_girl_2.jpg", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "np_surprised_girl_3.jpg", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "np_surprised_girl_4.jpg", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "np_surprised_girl_5.jpg", "Surprised","nepal"), db);


    }

    private void insertColombiaStimuli(SQLiteDatabase db){
        this.insertStimulus(new Stimulus( "co_angry_boy_1.jpg", "Angry","colombia"), db);
        this.insertStimulus(new Stimulus( "co_angry_boy_2.jpg", "Angry","colombia"), db);
        this.insertStimulus(new Stimulus( "co_angry_boy_3.jpg", "Angry","colombia"), db);
        this.insertStimulus(new Stimulus( "co_angry_boy_4.jpg", "Angry","colombia"), db);
        this.insertStimulus(new Stimulus( "co_angry_boy_5.jpg", "Angry","colombia"), db);
        this.insertStimulus(new Stimulus( "co_angry_girl_1.jpg", "Angry","colombia"), db);
        this.insertStimulus(new Stimulus( "co_angry_girl_2.jpg", "Angry","colombia"), db);
        this.insertStimulus(new Stimulus( "co_angry_girl_3.jpg", "Angry","colombia"), db);
        this.insertStimulus(new Stimulus( "co_angry_girl_4.jpg", "Angry","colombia"), db);
        this.insertStimulus(new Stimulus( "co_angry_girl_5.jpg", "Angry","colombia"), db);

        this.insertStimulus(new Stimulus( "co_fearful_boy_1.jpg", "Fearful","colombia"), db);
        this.insertStimulus(new Stimulus( "co_fearful_boy_2.jpg", "Fearful","colombia"), db);
        this.insertStimulus(new Stimulus( "co_fearful_boy_3.jpg", "Fearful","colombia"), db);
        this.insertStimulus(new Stimulus( "co_fearful_boy_4.jpg", "Fearful","colombia"), db);
        this.insertStimulus(new Stimulus( "co_fearful_boy_5.jpg", "Fearful","colombia"), db);
        this.insertStimulus(new Stimulus( "co_fearful_girl_1.jpg", "Fearful","colombia"), db);
        this.insertStimulus(new Stimulus( "co_fearful_girl_2.jpg", "Fearful","colombia"), db);
        this.insertStimulus(new Stimulus( "co_fearful_girl_3.jpg", "Fearful","colombia"), db);
        this.insertStimulus(new Stimulus( "co_fearful_girl_4.jpg", "Fearful","colombia"), db);
        this.insertStimulus(new Stimulus( "co_fearful_girl_5.jpg", "Fearful","colombia"), db);

        this.insertStimulus(new Stimulus( "co_neutral_boy_1.jpg", "Neutral","colombia"), db);
        this.insertStimulus(new Stimulus( "co_neutral_boy_2.jpg", "Neutral","colombia"), db);
        this.insertStimulus(new Stimulus( "co_neutral_boy_3.jpg", "Neutral","colombia"), db);
        this.insertStimulus(new Stimulus( "co_neutral_boy_4.jpg", "Neutral","colombia"), db);
        this.insertStimulus(new Stimulus( "co_neutral_boy_5.jpg", "Neutral","colombia"), db);
        this.insertStimulus(new Stimulus( "co_neutral_girl_1.jpg", "Neutral","colombia"), db);
        this.insertStimulus(new Stimulus( "co_neutral_girl_2.jpg", "Neutral","colombia"), db);
        this.insertStimulus(new Stimulus( "co_neutral_girl_3.jpg", "Neutral","colombia"), db);
        this.insertStimulus(new Stimulus( "co_neutral_girl_4.jpg", "Neutral","colombia"), db);
        this.insertStimulus(new Stimulus( "co_neutral_girl_5.jpg", "Neutral","colombia"), db);

        this.insertStimulus(new Stimulus( "co_happy_boy_1.jpg", "Happy","colombia"), db);
        this.insertStimulus(new Stimulus( "co_happy_boy_2.jpg", "Happy","colombia"), db);
        this.insertStimulus(new Stimulus( "co_happy_boy_3.jpg", "Happy","colombia"), db);
        this.insertStimulus(new Stimulus( "co_happy_boy_4.jpg", "Happy","colombia"), db);
        this.insertStimulus(new Stimulus( "co_happy_boy_5.jpg", "Happy","colombia"), db);
        this.insertStimulus(new Stimulus( "co_happy_girl_1.jpg", "Happy","colombia"), db);
        this.insertStimulus(new Stimulus( "co_happy_girl_2.jpg", "Happy","colombia"), db);
        this.insertStimulus(new Stimulus( "co_happy_girl_3.jpg", "Happy","colombia"), db);
        this.insertStimulus(new Stimulus( "co_happy_girl_4.jpg", "Happy","colombia"), db);
        this.insertStimulus(new Stimulus( "co_happy_girl_5.jpg", "Happy","colombia"), db);

        this.insertStimulus(new Stimulus( "co_sad_boy_1.jpg", "Sad","colombia"), db);
        this.insertStimulus(new Stimulus( "co_sad_boy_2.jpg", "Sad","colombia"), db);
        this.insertStimulus(new Stimulus( "co_sad_boy_3.jpg", "Sad","colombia"), db);
        this.insertStimulus(new Stimulus( "co_sad_boy_4.jpg", "Sad","colombia"), db);
        this.insertStimulus(new Stimulus( "co_sad_boy_5.jpg", "Sad","colombia"), db);
        this.insertStimulus(new Stimulus( "co_sad_girl_1.jpg", "Sad","colombia"), db);
        this.insertStimulus(new Stimulus( "co_sad_girl_2.jpg", "Sad","colombia"), db);
        this.insertStimulus(new Stimulus( "co_sad_girl_3.jpg", "Sad","colombia"), db);
        this.insertStimulus(new Stimulus( "co_sad_girl_4.jpg", "Sad","colombia"), db);
        this.insertStimulus(new Stimulus( "co_sad_girl_5.jpg", "Sad","colombia"), db);

        this.insertStimulus(new Stimulus( "co_surprised_boy_1.png", "Surprised","colombia"), db);
        this.insertStimulus(new Stimulus( "co_surprised_boy_2.png", "Surprised","colombia"), db);
        this.insertStimulus(new Stimulus( "co_surprised_boy_3.png", "Surprised","colombia"), db);
        this.insertStimulus(new Stimulus( "co_surprised_boy_4.png", "Surprised","colombia"), db);
        this.insertStimulus(new Stimulus( "co_surprised_boy_5.png", "Surprised","colombia"), db);
        this.insertStimulus(new Stimulus( "co_surprised_girl_1.png", "Surprised","colombia"), db);
        this.insertStimulus(new Stimulus( "co_surprised_girl_2.jpg", "Surprised","colombia"), db);
        this.insertStimulus(new Stimulus( "co_surprised_girl_3.jpg", "Surprised","colombia"), db);
        this.insertStimulus(new Stimulus( "co_surprised_girl_4.jpg", "Surprised","colombia"), db);
        this.insertStimulus(new Stimulus( "co_surprised_girl_5.jpg", "Surprised","colombia"), db);


    }

    private void insertSouthAfricaAfrikaansStimuli(SQLiteDatabase db){
        this.insertStimulus(new Stimulus( "sa_angry_boy_1.jpg", "Angry","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_angry_boy_2.jpg", "Angry","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_angry_boy_3.jpg", "Angry","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_angry_boy_4.jpg", "Angry","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_angry_boy_5.jpg", "Angry","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_1.jpg", "Angry","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_2.jpg", "Angry","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_3.jpg", "Angry","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_4.jpg", "Angry","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_5.jpg", "Angry","afrikaans"), db);

        this.insertStimulus(new Stimulus( "sa_fearful_boy_1.jpg", "Fearful","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_boy_2.jpg", "Fearful","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_boy_3.jpg", "Fearful","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_boy_4.jpg", "Fearful","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_boy_5.jpg", "Fearful","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_1.jpg", "Fearful","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_2.jpg", "Fearful","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_3.jpg", "Fearful","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_4.jpg", "Fearful","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_5.jpg", "Fearful","afrikaans"), db);

        this.insertStimulus(new Stimulus( "sa_neutral_boy_1.jpg", "Neutral","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_boy_2.jpg", "Neutral","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_boy_3.jpg", "Neutral","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_boy_4.jpg", "Neutral","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_boy_5.jpg", "Neutral","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_1.jpg", "Neutral","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_2.jpg", "Neutral","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_3.jpg", "Neutral","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_4.jpg", "Neutral","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_5.jpg", "Neutral","afrikaans"), db);

        this.insertStimulus(new Stimulus( "sa_happy_boy_1.jpg", "Happy","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_happy_boy_2.jpg", "Happy","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_happy_boy_3.jpg", "Happy","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_happy_boy_4.jpg", "Happy","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_happy_boy_5.jpg", "Happy","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_1.jpg", "Happy","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_2.jpg", "Happy","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_3.jpg", "Happy","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_4.jpg", "Happy","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_5.jpg", "Happy","afrikaans"), db);

        this.insertStimulus(new Stimulus( "sa_sad_boy_1.jpg", "Sad","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_sad_boy_2.jpg", "Sad","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_sad_boy_3.jpg", "Sad","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_sad_boy_4.jpg", "Sad","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_sad_boy_5.jpg", "Sad","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_1.jpg", "Sad","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_2.jpg", "Sad","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_3.jpg", "Sad","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_4.jpg", "Sad","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_5.jpg", "Sad","afrikaans"), db);

        this.insertStimulus(new Stimulus( "sa_surprised_boy_1.png", "Surprised","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_boy_2.png", "Surprised","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_boy_3.png", "Surprised","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_boy_4.png", "Surprised","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_boy_5.png", "Surprised","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_1.png", "Surprised","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_2.jpg", "Surprised","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_3.jpg", "Surprised","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_4.jpg", "Surprised","afrikaans"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_5.jpg", "Surprised","afrikaans"), db);


    }

    private void insertSouthAfricaIsiXhosaStimuli(SQLiteDatabase db){
        this.insertStimulus(new Stimulus( "sa_angry_boy_1.jpg", "Angry","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_angry_boy_2.jpg", "Angry","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_angry_boy_3.jpg", "Angry","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_angry_boy_4.jpg", "Angry","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_angry_boy_5.jpg", "Angry","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_1.jpg", "Angry","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_2.jpg", "Angry","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_3.jpg", "Angry","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_4.jpg", "Angry","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_angry_girl_5.jpg", "Angry","isixhosa"), db);

        this.insertStimulus(new Stimulus( "sa_fearful_boy_1.jpg", "Fearful","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_boy_2.jpg", "Fearful","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_boy_3.jpg", "Fearful","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_boy_4.jpg", "Fearful","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_boy_5.jpg", "Fearful","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_1.jpg", "Fearful","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_2.jpg", "Fearful","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_3.jpg", "Fearful","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_4.jpg", "Fearful","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_fearful_girl_5.jpg", "Fearful","isixhosa"), db);

        this.insertStimulus(new Stimulus( "sa_neutral_boy_1.jpg", "Neutral","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_boy_2.jpg", "Neutral","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_boy_3.jpg", "Neutral","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_boy_4.jpg", "Neutral","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_boy_5.jpg", "Neutral","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_1.jpg", "Neutral","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_2.jpg", "Neutral","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_3.jpg", "Neutral","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_4.jpg", "Neutral","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_neutral_girl_5.jpg", "Neutral","isixhosa"), db);

        this.insertStimulus(new Stimulus( "sa_happy_boy_1.jpg", "Happy","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_happy_boy_2.jpg", "Happy","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_happy_boy_3.jpg", "Happy","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_happy_boy_4.jpg", "Happy","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_happy_boy_5.jpg", "Happy","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_1.jpg", "Happy","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_2.jpg", "Happy","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_3.jpg", "Happy","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_4.jpg", "Happy","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_happy_girl_5.jpg", "Happy","isixhosa"), db);

        this.insertStimulus(new Stimulus( "sa_sad_boy_1.jpg", "Sad","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_sad_boy_2.jpg", "Sad","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_sad_boy_3.jpg", "Sad","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_sad_boy_4.jpg", "Sad","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_sad_boy_5.jpg", "Sad","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_1.jpg", "Sad","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_2.jpg", "Sad","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_3.jpg", "Sad","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_4.jpg", "Sad","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_sad_girl_5.jpg", "Sad","isixhosa"), db);

        this.insertStimulus(new Stimulus( "sa_surprised_boy_1.png", "Surprised","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_boy_2.png", "Surprised","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_boy_3.png", "Surprised","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_boy_4.png", "Surprised","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_boy_5.png", "Surprised","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_1.png", "Surprised","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_2.jpg", "Surprised","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_3.jpg", "Surprised","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_4.jpg", "Surprised","isixhosa"), db);
        this.insertStimulus(new Stimulus( "sa_surprised_girl_5.jpg", "Surprised","isixhosa"), db);


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


    @SuppressLint({"RestrictedApi"})
    public List<String> getStimuluses (String category, String location, int limit) {

        String CONFIG_SELECT_QUERY =
                String.format("SELECT substr(filename, 0, instr(filename,\".\")) AS filename FROM "+ StimulusTable.TABLE_NAME + " WHERE %s = ? AND %s = ? ORDER BY random() limit " + limit, StimulusTable.COLUMN_NAME_CATEGORY, StimulusTable.COLUMN_NAME_LOCATION);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(CONFIG_SELECT_QUERY, new String[]{ ""+category,""+location });

        List<String> stimuli = new ArrayList<>();

        try {

            while (cursor.moveToNext()) {

                String filename = cursor.getString(0);
                stimuli.add(filename);

            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }


        return stimuli;
    }

    @SuppressLint({"Range", "RestrictedApi"})
    public Trial getConfig (int trailId) {

        String CONFIG_SELECT_QUERY =
                String.format("SELECT * FROM "+ TrialRepository.TABLE_NAME + " WHERE %s = ? LIMIT 1", TrialRepository.COLUMN_NAME_TRIAL_ID);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(CONFIG_SELECT_QUERY, new String[]{ ""+trailId });

        Trial trial = null;

        try {
            if (cursor.moveToFirst()) {
                int id = cursor.getInt(cursor.getColumnIndex(TrialRepository.COLUMN_NAME_TRIAL_ID));
                String goFace = cursor.getString(cursor.getColumnIndex(TrialRepository.COLUMN_NAME_GO_FACE));
                String noGoFace = cursor.getString(cursor.getColumnIndex(TrialRepository.COLUMN_NAME_NO_GO_FACE));
                String trialCode = cursor.getString(cursor.getColumnIndex(TrialRepository.COLUMN_NAME_TRIAL_CODE));
                String trialName = cursor.getString(cursor.getColumnIndex(TrialRepository.COLUMN_NAME_TRIAL_NAME));
                int goFaceCount = cursor.getInt(cursor.getColumnIndex(TrialRepository.COLUMN_NAME_GO_FACE_COUNT));
                int noGoFaceCount = cursor.getInt(cursor.getColumnIndex(TrialRepository.COLUMN_NAME_NO_GO_FACE_COUNT));

                trial = new Trial(id,trialName,trialCode, goFace, noGoFace,goFaceCount, noGoFaceCount);
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return trial;
    }

    public long insertResponse(Response response, SQLiteDatabase db){
        return ResponseTable.insert(response, db);
    }

}
