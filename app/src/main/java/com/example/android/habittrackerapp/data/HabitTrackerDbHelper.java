package com.example.android.habittrackerapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.habittrackerapp.data.HabitTrackerContract.HabitTrackerEntry;

/**
 * Created by David on 12/07/2017.
 */

public class HabitTrackerDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "habit_tracker.db";  // Database filename.
    public static final int DATABASE_VERSION = 1;                   // Current version of the database.

    public HabitTrackerDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + HabitTrackerEntry.TABLE_NAME + " (" +
                HabitTrackerEntry.COLUMN_NAME_ID + " " + HabitTrackerEntry.COLUMN_TYPE_ID + " " + HabitTrackerEntry.COLUMN_CONSTRAINTS_ID + ", " +
                HabitTrackerEntry.COLUMN_NAME_USERNAME + " " + HabitTrackerEntry.COLUMN_TYPE_USERNAME + " " + HabitTrackerEntry.COLUMN_CONSTRAINTS_USERNAME + ", " +
                HabitTrackerEntry.COLUMN_NAME_DATE + " " + HabitTrackerEntry.COLUMN_TYPE_DATE + " " + HabitTrackerEntry.COLUMN_CONSTRAINTS_DATE + ", " +
                HabitTrackerEntry.COLUMN_NAME_SLEEPTIME + " " + HabitTrackerEntry.COLUMN_TYPE_SLEEPTIME + " " + HabitTrackerEntry.COLUMN_CONSTRAINTS_SLEEPTIME + ", " +
                HabitTrackerEntry.COLUMN_NAME_WEIGHT + " " + HabitTrackerEntry.COLUMN_TYPE_WEIGHT + " " + HabitTrackerEntry.COLUMN_CONSTRAINTS_SLEEPTIME + ", " +
                HabitTrackerEntry.COLUMN_NAME_WALKINGTIME + " " + HabitTrackerEntry.COLUMN_TYPE_WALKINGTIME + " " + HabitTrackerEntry.COLUMN_CONSTRAINTS_WALKINGTIME + ", " +
                HabitTrackerEntry.COLUMN_NAME_WALKINGDISTANCE + " " + HabitTrackerEntry.COLUMN_TYPE_WALKINGDISTANCEE + " " + HabitTrackerEntry.COLUMN_CONSTRAINTS_WALKINGDISTANCE + ", " +
                HabitTrackerEntry.COLUMN_NAME_RUNNINGTIME + " " + HabitTrackerEntry.COLUMN_TYPE_RUNNINGTIME + " " + HabitTrackerEntry.COLUMN_CONSTRAINTS_RUNNINGTIME + ", " +
                HabitTrackerEntry.COLUMN_NAME_RUNNINGDISTANCE + " " + HabitTrackerEntry.COLUMN_TYPE_RUNNINGDISTANCEE + " " + HabitTrackerEntry.COLUMN_CONSTRAINTS_RUNNINGDISTANCE + ", " +
                HabitTrackerEntry.COLUMN_NAME_AVERAGEHEARTBEATS + " " + HabitTrackerEntry.COLUMN_TYPE_AVERAGEHEARTBEATS + " " + HabitTrackerEntry.COLUMN_CONSTRAINTS_AVERAGEHEARTBEATS + ")";
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
