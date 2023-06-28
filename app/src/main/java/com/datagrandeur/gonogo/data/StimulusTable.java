package com.datagrandeur.gonogo.data;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

class StimulusTable implements BaseColumns {

    private StimulusTable() {}

    public static final String TABLE_NAME = "stimulus";
    public static final String COLUMN_NAME_FILENAME = "filename";
    public static final String COLUMN_NAME_CATEGORY = "category";
    public static final String COLUMN_NAME_LOCATION = "location";

    public static final String CREATE =
            "CREATE TABLE " + StimulusTable.TABLE_NAME + " (" +
                    StimulusTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    StimulusTable.COLUMN_NAME_FILENAME + " TEXT," +
                    StimulusTable.COLUMN_NAME_CATEGORY + " TEXT," +
                    StimulusTable.COLUMN_NAME_LOCATION + " TEXT)";

    public static long insert(Stimulus stimulus, SQLiteDatabase db){

        ContentValues values = new ContentValues();

        values.put(StimulusTable.COLUMN_NAME_FILENAME, stimulus.getFilename());
        values.put(StimulusTable.COLUMN_NAME_CATEGORY, stimulus.getCategory() );
        values.put(StimulusTable.COLUMN_NAME_LOCATION, stimulus.getLocation() );

        return db.insert(StimulusTable.TABLE_NAME, null, values);
    }

    public static final String DELETE =
            "DROP TABLE IF EXISTS " + StimulusTable.TABLE_NAME;


}