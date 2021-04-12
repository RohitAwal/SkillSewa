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

    public void insertData(String encodedFrontImage, String encodedBackImage, String encodedPDImage, String location, String inspector, String DateOfInspection, String HouseName, String encodedPF1A, String encodedPF1B, String encodedPF1C, String PFOD, String PFOF, String PFOR, String encodedPF2A, String PFTD, String PFTF, String PFTR, String encodedPF3A, String encodedPF3B, String encodedPF3C, String encodedPF3D, String PFTHD, String PFTHF, String PFTHR, String encodedPF4A, String encodedPF4B, String encodedPF4C, String PFFD, String PFFF, String PFFR, String encodedPF5A, String PFFID, String PFFIF, String PFFIR) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO SKILLSEWASTTTTT VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
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
        statement.bindString(14, encodedPF2A);
        statement.bindString(15, PFTD);
        statement.bindString(16, PFTF);
        statement.bindString(17, PFTR);
        statement.bindString(18, encodedPF3A);
        statement.bindString(19, encodedPF3B);
        statement.bindString(20, encodedPF3C);
        statement.bindString(21, encodedPF3D);
        statement.bindString(22, PFTHD);
        statement.bindString(23, PFTHF);
        statement.bindString(24, PFTHR);
        statement.bindString(25, encodedPF4A);
        statement.bindString(26, encodedPF4B);
        statement.bindString(27, encodedPF4C);
        statement.bindString(28, PFFD);
        statement.bindString(29, PFFF);
        statement.bindString(30, PFFR);
        statement.bindString(31, encodedPF5A);
        statement.bindString(32, PFFID);
        statement.bindString(33, PFFIF);
        statement.bindString(34, PFFIR);

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
