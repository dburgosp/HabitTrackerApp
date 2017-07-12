package com.example.android.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.android.habittrackerapp.data.HabitTrackerContract.HabitTrackerEntry;
import com.example.android.habittrackerapp.data.HabitTrackerDbHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Insert a new row in the "habit_tracker" table.
     *
     * @param habitTracker is an object of type HabitTracker with all the data for the record.     *
     * @return true if the insertion has been ok, false otherwise.
     */
    private boolean insertHabit(HabitTracker habitTracker) {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper and pass the
        // context, which is the current activity, and then get the data repository in write mode.
        HabitTrackerDbHelper dbHelper = new HabitTrackerDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys.
        ContentValues values = new ContentValues();
        values.put(HabitTrackerEntry.COLUMN_NAME_USERNAME, habitTracker.getUserName());
        values.put(HabitTrackerEntry.COLUMN_NAME_DATE, habitTracker.getDate());
        values.put(HabitTrackerEntry.COLUMN_NAME_SLEEPTIME, habitTracker.getSleepTime());
        values.put(HabitTrackerEntry.COLUMN_NAME_WEIGHT, habitTracker.getWeight());
        values.put(HabitTrackerEntry.COLUMN_NAME_WALKINGTIME, habitTracker.getWalkingTime());
        values.put(HabitTrackerEntry.COLUMN_NAME_WALKINGDISTANCE, habitTracker.getWalkingDistance());
        values.put(HabitTrackerEntry.COLUMN_NAME_RUNNINGTIME, habitTracker.getRunningTime());
        values.put(HabitTrackerEntry.COLUMN_NAME_RUNNINGDISTANCE, habitTracker.getRunningDistance());
        values.put(HabitTrackerEntry.COLUMN_NAME_AVERAGEHEARTBEATS, habitTracker.getAverageHeartBeats());

        // Insert the new row, returning the primary key value of the new row.
        long newRowId = db.insert(HabitTrackerEntry.TABLE_NAME, null, values);
        if (newRowId < 0) {
            // If db.insert returns -1 there has been an error.
            Toast.makeText(this, "Error inserting record", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            // Insertion ok. The db.insert method returns the primary key for the new row.
            Toast.makeText(this, "New record at index " + newRowId, Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    /**
     * Retrieves all the elements in the "habit_tracker" table of the database.
     * 
     * @return an array of HabitTracker objects, with the information retrieved from the database.
     */
    private ArrayList<HabitTracker> databaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper and pass the
        // context, which is the current activity, and create and/or open a database to read from
        // it.
        HabitTrackerDbHelper dbHelper = new HabitTrackerDbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Create the new array for returning data.
        ArrayList<HabitTracker> habitTrackerArrayList = new ArrayList<HabitTracker>();

        // Perform this raw SQL query "SELECT * FROM habit_tracker" to get a Cursor that contains
        // all rows from the "habit_tracker" table.
        Cursor cursor = db.query(HabitTrackerEntry.TABLE_NAME, null, null, null, null, null, null);

        // Figure out the index of each column.
        int usernameColumnIndex = cursor.getColumnIndex(HabitTrackerEntry.COLUMN_NAME_USERNAME);
        int dateColumnIndex = cursor.getColumnIndex(HabitTrackerEntry.COLUMN_NAME_DATE);
        int sleepTimeColumnIndex = cursor.getColumnIndex(HabitTrackerEntry.COLUMN_NAME_SLEEPTIME);
        int weightColumnIndex = cursor.getColumnIndex(HabitTrackerEntry.COLUMN_NAME_WEIGHT);
        int walkingTimeColumnIndex = cursor.getColumnIndex(HabitTrackerEntry.COLUMN_NAME_WALKINGTIME);
        int walkingDistanceColumnIndex = cursor.getColumnIndex(HabitTrackerEntry.COLUMN_NAME_WALKINGDISTANCE);
        int runningTimeColumnIndex = cursor.getColumnIndex(HabitTrackerEntry.COLUMN_NAME_RUNNINGTIME);
        int runningDistanceColumnIndex = cursor.getColumnIndex(HabitTrackerEntry.COLUMN_NAME_RUNNINGDISTANCE);
        int averageHeartBeatsColumnIndex = cursor.getColumnIndex(HabitTrackerEntry.COLUMN_NAME_AVERAGEHEARTBEATS);

        // Extract every row information from the cursor and store it into the array of HabitTracker
        // objects.
        HabitTracker habitTracker;
        try {
            while (cursor.moveToNext()) {
                habitTracker = new HabitTracker(cursor.getString(usernameColumnIndex),
                        cursor.getString(dateColumnIndex),
                        cursor.getInt(sleepTimeColumnIndex),
                        cursor.getInt(weightColumnIndex),
                        cursor.getInt(walkingTimeColumnIndex),
                        cursor.getInt(walkingDistanceColumnIndex),
                        cursor.getInt(runningTimeColumnIndex),
                        cursor.getInt(runningDistanceColumnIndex),
                        cursor.getInt(averageHeartBeatsColumnIndex));
                habitTrackerArrayList.add(habitTracker);
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
            return habitTrackerArrayList;
        }
    }
}
