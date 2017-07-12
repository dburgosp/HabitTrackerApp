package com.example.android.habittrackerapp;

/**
 * Created by David on 12/07/2017.
 */

public class HabitTracker {
    String userName;        // is the name of the user who is registering his/her habits.
    String date;            // is the date of the record.
    int sleepTime;          // is the number of minutes that the user has slept the past night.
    int weight;             // is the weight in grames of the user in the morning.
    int walkingTime;        // is the number of minutes that the user has been walking this date.
    int walkingDistance;    // is the number of meters that the user has walked this date.
    int runningTime;        // is the number of minutes that the user has been running this date.
    int runningDistance;    // is the number of meters that the user run on this date.
    int averageHeartBeats;  // is the average heartbeat rate of the user on this date.

    /**
     * Constructor of this class.
     *
     * @param userName          is the name of the user who is registering his/her habits.
     * @param date              is the date of the record.
     * @param sleepTime         is the number of minutes that the user has slept the past night.
     * @param weight            is the weight in grames of the user in the morning.
     * @param walkingTime       is the number of minutes that the user has been walking this date.
     * @param walkingDistance   is the number of meters that the user has walked this date.
     * @param runningTime       is the number of minutes that the user has been running this date.
     * @param runningDistance   is the number of meters that the user run on this date.
     * @param averageHeartBeats is the average heartbeat rate of the user on this date.
     */
    public HabitTracker(String userName, String date, int sleepTime, int weight, int walkingTime,
                        int walkingDistance, int runningTime, int runningDistance,
                        int averageHeartBeats) {
        this.userName = userName;
        this.date = date;
        this.sleepTime = sleepTime;
        this.weight = weight;
        this.walkingTime = walkingTime;
        this.walkingDistance = walkingDistance;
        this.runningTime = runningTime;
        this.runningDistance = runningDistance;
        this.averageHeartBeats = averageHeartBeats;
    }

    // Getters.
    public String getUserName() {
        return userName;
    }

    public String getDate() {
        return date;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public int getWeight() {
        return weight;
    }

    public int getWalkingTime() {
        return walkingTime;
    }

    public int getWalkingDistance() {
        return walkingDistance;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public int getRunningDistance() {
        return runningDistance;
    }

    public int getAverageHeartBeats() {
        return averageHeartBeats;
    }
}
