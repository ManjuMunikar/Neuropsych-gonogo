package com.datagrandeur.gonogo.data;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

final class ResponseTable implements BaseColumns {

    private ResponseTable() {}

    public static final String TABLE_NAME = "response";
    public static final String USER_ID = "user_id";

    public static final String COLUMN_NAME_TRIAL_NAME = "trail_name";

    public static final String COLUMN_NAME_GOFACE = "goface";
    public static final String COLUMN_NAME_NOGOFACE = "nogoface";
    public static final String COLUMN_NAME_STIMULI = "stimuli";
    public static final String COLUMN_NAME_START_MILLIS = "start_millis";
    public static final String COLUMN_NAME_END_MILLIS = "end_millis";
    public static final String COLUMN_USER_INPUT_MILLIS = "user_input_millis";
    public static final String COLUMN_NAME_SEQUENCE_NUMBER = "sequence_number";
    public static final String COLUMN_NAME_USER_INPUT = "user_input";
    public static final String COLUMN_NAME_CORRECT = "correct";


    public static final String CREATE =
            "CREATE TABLE " + ResponseTable.TABLE_NAME + " (" +
                    ResponseTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ResponseTable.USER_ID + " TEXT," +
                    ResponseTable.COLUMN_NAME_TRIAL_NAME + " TEXT, " +
                    ResponseTable.COLUMN_NAME_GOFACE + " TEXT, " +
                    ResponseTable.COLUMN_NAME_NOGOFACE + " TEXT, " +
                    ResponseTable.COLUMN_NAME_SEQUENCE_NUMBER + " TEXT, " +
                    ResponseTable.COLUMN_NAME_STIMULI + " TEXT," +
                    ResponseTable.COLUMN_NAME_USER_INPUT + " BOOLEAN," +
                    ResponseTable.COLUMN_NAME_START_MILLIS + " TEXT," +
                    ResponseTable.COLUMN_NAME_END_MILLIS + " TEXT," +
                    ResponseTable.COLUMN_USER_INPUT_MILLIS + " TEXT ," +
                    ResponseTable.COLUMN_NAME_CORRECT + " BOOLEAN " +
                    ")";

    public static long insert(Response response, SQLiteDatabase db){

        ContentValues values = new ContentValues();

        values.put(ResponseTable.USER_ID, response.getUserId());
        values.put(ResponseTable.COLUMN_NAME_TRIAL_NAME, response.getTrialName());
        values.put(ResponseTable.COLUMN_NAME_STIMULI, response.getStimulus());
        values.put(ResponseTable.COLUMN_NAME_GOFACE, response.getGoFace());
        values.put(ResponseTable.COLUMN_NAME_NOGOFACE, response.getNoGoFace());
        values.put(ResponseTable.COLUMN_NAME_START_MILLIS, response.getStartMillis() );
        values.put(ResponseTable.COLUMN_NAME_END_MILLIS, response.getEndMillis());
        values.put(ResponseTable.COLUMN_USER_INPUT_MILLIS, response.getUserInputMillis());
        values.put(ResponseTable.COLUMN_NAME_SEQUENCE_NUMBER, response.getSequenceNumber());
        values.put(ResponseTable.COLUMN_NAME_USER_INPUT, response.isUserInput());
        values.put(ResponseTable.COLUMN_NAME_CORRECT, response.isCorrect());

        return db.insert(ResponseTable.TABLE_NAME, null, values);

    }

    public static final String DELETE =
            "DROP TABLE IF EXISTS " + ResponseTable.TABLE_NAME;
}
