package com.datagrandeur.gonogo.data;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class TrialRepository {

    private TrialRepository(){ }
    public static final String TABLE_NAME = "trial";
    public static final String  COLUMN_NAME_TRIAL_ID = "id";
    public static final String  COLUMN_NAME_TRIAL_NAME = "trial_name";
    public static final String  COLUMN_NAME_TRIAL_CODE = "trial_code";
    public static final String COLUMN_NAME_GO_FACE = "goface";
    public static final String COLUMN_NAME_NO_GO_FACE = "nogoface";
    public static final String COLUMN_NAME_GO_FACE_COUNT ="gofacecount" ;
    public static final String COLUMN_NAME_NO_GO_FACE_COUNT = "nogofacecount";

    public static final String CREATE =
            "CREATE TABLE  " + TrialRepository.TABLE_NAME + " ("+
                    TrialRepository.COLUMN_NAME_TRIAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TrialRepository.COLUMN_NAME_TRIAL_NAME + " TEXT, " +
                    TrialRepository.COLUMN_NAME_TRIAL_CODE + " TEXT UNIQUE, " +
                    TrialRepository.COLUMN_NAME_GO_FACE + " TEXT, " +
                    TrialRepository.COLUMN_NAME_NO_GO_FACE + " TEXT, " +
                    TrialRepository.COLUMN_NAME_GO_FACE_COUNT + " INTEGER, " +
                    TrialRepository.COLUMN_NAME_NO_GO_FACE_COUNT + " INTEGER " +
                    ")";

    public static long insert(Trial trial, SQLiteDatabase db){

        ContentValues values = new ContentValues();


        values.put(TrialRepository.COLUMN_NAME_TRIAL_NAME, trial.getTrialName());
        values.put(TrialRepository.COLUMN_NAME_TRIAL_CODE, trial.getTrialCode());
        values.put(TrialRepository.COLUMN_NAME_GO_FACE, trial.getGoFace());
        values.put(TrialRepository.COLUMN_NAME_NO_GO_FACE, trial.getNoGoFace());
        values.put(TrialRepository.COLUMN_NAME_GO_FACE_COUNT, trial.getGoFaceCount());
        values.put(TrialRepository.COLUMN_NAME_NO_GO_FACE_COUNT, trial.getNoGoFaceCount());


        return db.insert(TrialRepository.TABLE_NAME, null, values);

    }

}
