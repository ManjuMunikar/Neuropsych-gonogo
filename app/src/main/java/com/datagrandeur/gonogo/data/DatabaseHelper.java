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
    public static final String DATABASE_NAME = "gonogo_01.db";
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
        insertNepalStimuli(db);

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
        this.insertStimulus(new Stimulus( "neutralgirl2.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "neutralgirl3.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "neutralgirl4.jpg", "Neutral","global"), db);
        this.insertStimulus(new Stimulus( "neutralgirl5.jpg", "Neutral","global"), db);

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

        this.insertStimulus(new Stimulus( "surprisedboy1.jpg", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "surprisedboy2.jpg", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "surprisedboy3.jpg", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "surprisedboy4.jpg", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "surprisedboy5.jpg", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "surprisedgirl1.jpg", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "surprisedgirl2.jpg", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "surprisedgirl3.jpg", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "surprisedgirl4.jpg", "Surprised","global"), db);
        this.insertStimulus(new Stimulus( "surprisedgirl5.jpg", "Surprised","global"), db);


    }

    private void insertNepalStimuli(SQLiteDatabase db){
        this.insertStimulus(new Stimulus( "angryboy1.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "angryboy2.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "angryboy3.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "angryboy4.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "angryboy5.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "angrygirl1.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "angrygirl2.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "angrygirl3.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "angrygirl4.jpg", "Angry","nepal"), db);
        this.insertStimulus(new Stimulus( "angrygirl5.jpg", "Angry","nepal"), db);

        this.insertStimulus(new Stimulus( "fearfulboy1.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "fearfulboy2.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "fearfulboy3.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "fearfulboy4.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "fearfulboy5.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "fearfulgirl1.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "fearfulgirl2.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "fearfulgirl3.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "fearfulgirl4.jpg", "Fearful","nepal"), db);
        this.insertStimulus(new Stimulus( "fearfulgirl5.jpg", "Fearful","nepal"), db);

        this.insertStimulus(new Stimulus( "neutralboy1.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "neutralboy2.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "neutralboy3.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "neutralboy4.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "neutralboy5.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "neutralgirl1.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "neutralgirl2.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "neutralgirl3.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "neutralgirl4.jpg", "Neutral","nepal"), db);
        this.insertStimulus(new Stimulus( "neutralgirl5.jpg", "Neutral","nepal"), db);

        this.insertStimulus(new Stimulus( "happyboy1.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "happyboy2.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "happyboy3.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "happyboy4.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "happyboy5.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "happygirl1.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "happygirl2.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "happygirl3.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "happygirl4.jpg", "Happy","nepal"), db);
        this.insertStimulus(new Stimulus( "happygirl5.jpg", "Happy","nepal"), db);

        this.insertStimulus(new Stimulus( "sadboy1.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "sadboy2.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "sadboy3.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "sadboy4.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "sadboy5.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "sadgirl1.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "sadgirl2.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "sadgirl3.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "sadgirl4.jpg", "Sad","nepal"), db);
        this.insertStimulus(new Stimulus( "sadgirl5.jpg", "Sad","nepal"), db);

        this.insertStimulus(new Stimulus( "surprisedboy1.jpg", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "surprisedboy2.jpg", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "surprisedboy3.jpg", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "surprisedboy4.jpg", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "surprisedboy5.jpg", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "surprisedgirl1.jpg", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "surprisedgirl2.jpg", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "surprisedgirl3.jpg", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "surprisedgirl4.jpg", "Surprised","nepal"), db);
        this.insertStimulus(new Stimulus( "surprisedgirl5.jpg", "Surprised","nepal"), db);


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
