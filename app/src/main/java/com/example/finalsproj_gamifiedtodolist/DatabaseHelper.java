package com.example.finalsproj_gamifiedtodolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "AppData.db";
    public static final String[] TABLE_NAMES = {"LoginTable","TasksTable","AlarmsTable","UserStatsTable"};
    public static final String[] LOGIN_TABLE_COLS = {"UUID","USERNAME","PASSWORD"};

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAMES[0]+ "(" +
                LOGIN_TABLE_COLS[0]+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                LOGIN_TABLE_COLS[1] +" TEXT," +
                LOGIN_TABLE_COLS[2] +" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAMES[0]);
        onCreate(db);
    }

    public boolean insertData(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LOGIN_TABLE_COLS[1], username);
        contentValues.put(LOGIN_TABLE_COLS[2], password);
        long result = db.insert(TABLE_NAMES[0], null, contentValues);
        return result != -1;
    }
}
