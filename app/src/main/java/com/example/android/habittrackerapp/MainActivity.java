package com.example.android.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.android.habittrackerapp.data.HabitTrackerContract.HabitTrackerEntry;
import com.example.android.habittrackerapp.data.HabitTrackerDbHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Database helper that will provide us access to the database.
    private HabitTrackerDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To access our database, we instantiate our subclass of SQLiteOpenHelper and pass the
        // context, which is the current activity.
        dbHelper = new HabitTrackerDbHelper(this);

        // Some examples inserting data...
        HabitTracker habitTracker;
        habitTracker = new HabitTracker("David", "2017-07-11", 450, 80000, 210, 3000, 100, 2000, 170);
        if (insertHabit(habitTracker)) Log.i("MainActivity", "Insert 1 OK");
        else Log.e("MainActivity", "Insert 1 ERROR");
        habitTracker = new HabitTracker("David", "2017-07-12", 470, 79800, 220, 3100, 120, 2200, 175);
        if (insertHabit(habitTracker)) Log.i("MainActivity", "Insert 2 OK");
        else Log.e("MainActivity", "Insert 2 ERROR");
        habitTracker = new HabitTracker("David", "2017-07-13", 420, 79000, 250, 3430, 140, 2350, 169);
        if (insertHabit(habitTracker)) Log.i("MainActivity", "Insert 3 OK");
        else Log.e("MainActivity", "Insert 3 ERROR");

        // ... and retrieving all the data in the table.
        Cursor cursor = databaseInfo();
        ArrayList<HabitTracker> habitTrackerArrayList = parseDatabaseInfo(cursor);
        int i = 1;
        for (HabitTracker h : habitTrackerArrayList) {
            Log.i("MainActivity", "Row " + i + ": " + HabitTrackerEntry.COLUMN_NAME_USERNAME + "=" + habitTracker.getUserName());
            Log.i("MainActivity", "Row " + i + ": " + HabitTrackerEntry.COLUMN_NAME_DATE + "=" + habitTracker.getDate());
            Log.i("MainActivity", "Row " + i + ": " + HabitTrackerEntry.COLUMN_NAME_SLEEPTIME + "=" + habitTracker.getSleepTime());
            Log.i("MainActivity", "Row " + i + ": " + HabitTrackerEntry.COLUMN_NAME_WEIGHT + "=" + habitTracker.getWeight());
            Log.i("MainActivity", "Row " + i + ": " + HabitTrackerEntry.COLUMN_NAME_WALKINGTIME + "=" + habitTracker.getWalkingTime());
            Log.i("MainActivity", "Row " + i + ": " + HabitTrackerEntry.COLUMN_NAME_WALKINGDISTANCE + "=" + habitTracker.getWalkingDistance());
            Log.i("MainActivity", "Row " + i + ": " + HabitTrackerEntry.COLUMN_NAME_RUNNINGTIME + "=" + habitTracker.getRunningTime());
            Log.i("MainActivity", "Row " + i + ": " + HabitTrackerEntry.COLUMN_NAME_RUNNINGDISTANCE + "=" + habitTracker.getRunningDistance());
            Log.i("MainActivity", "Row " + i + ": " + HabitTrackerEntry.COLUMN_NAME_AVERAGEHEARTBEATS + "=" + habitTracker.getAverageHeartBeats());
            i++;
        }
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
     * Given a cursor with all the elements in the "habit_tracker" table of the database, extracts
     * then into an array of HabitTracker objects, one object per row.
     *
     * @param cursor is the Cursor object with the result set of a previous query.
     * @return an array of HabitTracker objects, with the information retrieved from the database.
     */
    private ArrayList<HabitTracker> parseDatabaseInfo(Cursor cursor) {
        // Create the new array for returning data.
        ArrayList<HabitTracker> habitTrackerArrayList = new ArrayList<>();

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

    /**
     * Retrieves all the elements in the "habit_tracker" table of the database.
     *
     * @return a Cursor object with the information retrieved from the database.
     */
    private Cursor databaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper and pass the
        // context, which is the current activity, and create and/or open a database to read from
        // it.
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM habit_tracker" to get a Cursor that contains
        // all rows from the "habit_tracker" table.
        return db.query(HabitTrackerEntry.TABLE_NAME, null, null, null, null, null, null);
    }
}
