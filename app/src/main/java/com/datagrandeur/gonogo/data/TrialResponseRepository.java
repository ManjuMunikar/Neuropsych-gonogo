package com.datagrandeur.gonogo.data;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class TrialResponseRepository {

    private TrialResponseRepository(){ }

    public static final String TABLE_NAME= "trialResponse";
    public static final String COLUMN_NAME_TRIAL_ID = "id";
    public static final String COLUMN_NAME_USER_ID = "user_id";
    public static final String COLUMN_NAME_IMAGE= "image";
    public static final String COLUMN_NAME_RESPONSE= "response";
    public static final String COLUMN_NAME_RESPONSE_TIME= "response_time";
    public static final String COLUMN_NAME_CORRECT = "correct";
    public static final String COLUMN_NAME_RESPONSE_OUTCOME = "response_outcome";


    public static final String CREATE=
            "CREATE TABLE  " + TrialResponseRepository.TABLE_NAME + "("+
                    TrialResponseRepository.COLUMN_NAME_TRIAL_ID + " INTEGER, "+
                    TrialResponseRepository.COLUMN_NAME_USER_ID + " TEXT, "+
                    TrialResponseRepository.COLUMN_NAME_IMAGE + " TEXT, " +
                    TrialResponseRepository.COLUMN_NAME_RESPONSE + " TEXT, " +
                    TrialResponseRepository.COLUMN_NAME_RESPONSE_TIME + " TEXT, " +
                    TrialResponseRepository.COLUMN_NAME_RESPONSE_OUTCOME+ " TEXT, " +
                    TrialResponseRepository.COLUMN_NAME_CORRECT + " BOOLEAN " +
                    ")";

    public static long insert(TrialResponse trialResponse, SQLiteDatabase db){

        ContentValues values= new ContentValues();

        values.put(TrialResponseRepository.COLUMN_NAME_TRIAL_ID, trialResponse.getId());
        values.put(TrialResponseRepository.COLUMN_NAME_USER_ID, trialResponse.getUserId());
        values.put(TrialResponseRepository.COLUMN_NAME_IMAGE, trialResponse.getImage());
        values.put(TrialResponseRepository.COLUMN_NAME_RESPONSE, trialResponse.getResponse());
        values.put(TrialResponseRepository.COLUMN_NAME_RESPONSE_TIME,trialResponse.getResponseTime());
        values.put(TrialResponseRepository.COLUMN_NAME_RESPONSE_OUTCOME,trialResponse.getResponse_outcome());
        values.put(TrialResponseRepository.COLUMN_NAME_CORRECT,trialResponse.isCorrect());
        return db.insert(TrialResponseRepository.TABLE_NAME,null, values);


    }
}
