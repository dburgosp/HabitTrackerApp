# Habit Tracker App

The goal is to design and create the structure of a Habit Tracking app which would allow a user to store and track their habits over time. This project has no UI components; instead it focus on what happens behind the scenes, practicing how to design and implement a simple database.

# Project specification

## Layout

**Overall Layout**. No UI is required for this project.

## Functionality

1. **Compile Time Errors**. The code compiles without errors.
2. **Table Definition**. There exists a contract class that defines name of table and constants. Inside the contract class, there is an inner class for each table created.
3. **Table Creation**. There exists a subclass of <a href="https://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper.html" target="_blank">SQLiteOpenHelper</a> that overrides <a href="https://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper.html#onCreate(android.database.sqlite.SQLiteDatabase)" target="_blank">onCreate()</a> and <a href="https://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper.html#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)" target="_blank">onUpgrade()</a>.
4. **Data Insertion**. There is a single insert method that adds at least two values of two different datatypes (e.g. INTEGER, STRING) into the database using a <a href="https://developer.android.com/reference/android/content/ContentValues.html" target="_blank">ContentValues</a> object and the <a href="https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html#insert(java.lang.String, java.lang.String, android.content.ContentValues)" target="_blank">insert()</a> method.
5. **Data Reading**. There is a single read method that returns a Cursor object. It should get the data repository in read and use the <a href="https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html#query(java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String)" target="_blank">query()</a> method to retrieve at least one column of data.
6. **External Libraries and Packages**. No external libraries (e.g. <a href="https://blog.realm.io/realm-for-android/" target="_blank">Realm</a>) are used for the database code, and no <a href="https://developer.android.com/guide/topics/providers/content-providers.html" target="_blank">Content Providers</a> is used. All data insertion and reading should be done using direct method calls to the <a href="https://developer.android.com/reference/android/database/sqlite/package-summary.html" target="_blank">SQLite database</a> in the <a href="https://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper.html" target="_blank">SQLiteOpenHelper</a> class.

## Code Readability

1. **Readability**. Code is easily readable such that a fellow programmer can understand the purpose of the app.
2. **Naming Conventions**. All variables, methods, and resource IDs are descriptively named such that another developer reading the code can easily understand their function.
3. **Format**. The code is properly formatted:
   * No unnecessary blank lines.
   * No unused variables or methods.
   * No commented out code.
   * The code also has proper indentation when defining variables and methods.
