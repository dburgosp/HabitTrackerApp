package com.example.android.habittrackerapp.data;

import android.provider.BaseColumns;

/**
 * Created by David on 12/07/2017.
 */

public final class HabitTrackerContract {
    /**
     * Class for "habit_tracker" table, which stores the habits of the user at a specific date. It
     * has the following columns:
     * <p>
     * _id (INTEGER) is the index of the table.
     * name (TEXT) is the name of the user of the habit tracker app.
     * date (TEXT) is the date of the record.
     * sleep_time (INTEGER) is the number of minutes that the user has slept the past night.
     * weight (INTEGER) is the weight in grams of the user before having breakfast.
     * walking_time (INTEGER) is the number of minutes that the user has been walking on this date.
     * walking_distance (INTEGER) is the number of meters that the user has walked on this date.
     * running_time (INTEGER) is the number of minutes that the user has been running on this date.
     * running_distance (INTEGER) is the number of meters that the user run on this date.
     * average_heartbeats (INTEGER) is the average number of beats per minute of the user on this date.
     */
    public static abstract class HabitTrackerEntry implements BaseColumns {

        // Name of the table.
        public static final String TABLE_NAME = "habit_tracker";

        // Names of the columns.
        public static final String COLUMN_NAME_ID = BaseColumns._ID;
        public static final String COLUMN_NAME_USERNAME = "name";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_SLEEPTIME = "sleep_time";
        public static final String COLUMN_NAME_WEIGHT = "weight";
        public static final String COLUMN_NAME_WALKINGTIME = "walking_time";
        public static final String COLUMN_NAME_WALKINGDISTANCE = "walking_distance";
        public static final String COLUMN_NAME_RUNNINGTIME = "running_time";
        public static final String COLUMN_NAME_RUNNINGDISTANCE = "running_distance";
        public static final String COLUMN_NAME_AVERAGEHEARTBEATS = "average_heartbeats";

        // Data types of the columns.
        public static final String COLUMN_TYPE_ID = "INTEGER";
        public static final String COLUMN_TYPE_USERNAME = "TEXT";
        public static final String COLUMN_TYPE_DATE = "TEXT";
        public static final String COLUMN_TYPE_SLEEPTIME = "INTEGER";
        public static final String COLUMN_TYPE_WEIGHT = "INTEGER";
        public static final String COLUMN_TYPE_WALKINGTIME = "INTEGER";
        public static final String COLUMN_TYPE_WALKINGDISTANCEE = "INTEGER";
        public static final String COLUMN_TYPE_RUNNINGTIME = "INTEGER";
        public static final String COLUMN_TYPE_RUNNINGDISTANCEE = "INTEGER";
        public static final String COLUMN_TYPE_AVERAGEHEARTBEATS = "INTEGER";

        // Constraints of the columns.
        public static final String COLUMN_CONSTRAINTS_ID = "PRIMARY KEY AUTOINCREMENT";
        public static final String COLUMN_CONSTRAINTS_USERNAME = "NOT NULL";
        public static final String COLUMN_CONSTRAINTS_DATE = "NOT NULL";
        public static final String COLUMN_CONSTRAINTS_SLEEPTIME = "DEFAULT 0";
        public static final String COLUMN_CONSTRAINTS_WEIGHT = "DEFAULT 0";
        public static final String COLUMN_CONSTRAINTS_WALKINGTIME = "DEFAULT 0";
        public static final String COLUMN_CONSTRAINTS_WALKINGDISTANCE = "DEFAULT 0";
        public static final String COLUMN_CONSTRAINTS_RUNNINGTIME = "DEFAULT 0";
        public static final String COLUMN_CONSTRAINTS_RUNNINGDISTANCE = "DEFAULT 0";
        public static final String COLUMN_CONSTRAINTS_AVERAGEHEARTBEATS = "DEFAULT 0";
    }
}
