package com.pebblescrow.skillsewaproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);

    }

    public void insertData(String encodedFrontImage, String encodedBackImage, String encodedPDImage, String location, String inspector, String DateOfInspection, String HouseName, String encodedPF1A, String encodedPF1B, String encodedPF1C, String PFOD, String PFOF, String PFOR) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO SKILLSEWASTTTT VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, encodedFrontImage);
        statement.bindString(2, encodedBackImage);
        statement.bindString(3, encodedPDImage);
        statement.bindString(4, location);
        statement.bindString(5, inspector);
        statement.bindString(6, DateOfInspection);
        statement.bindString(7, HouseName);
        statement.bindString(8, encodedPF1A);
        statement.bindString(9, encodedPF1B);
        statement.bindString(10, encodedPF1C);
        statement.bindString(11, PFOD);
        statement.bindString(12, PFOF);
        statement.bindString(13, PFOR);

        statement.executeInsert();
    }

    public Cursor getData(String sql) {

        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
