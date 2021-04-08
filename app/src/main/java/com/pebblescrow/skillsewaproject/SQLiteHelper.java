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
    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);

    }
    public void insertData(byte[] image, String location, String inspector,String DateOfInspection, String HouseName){
        SQLiteDatabase database = getWritableDatabase();
        String sql= "INSERT INTO SKILLSEWASTTT VALUES (NULL, ?, ?, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindBlob(1,image);
        statement.bindString(2, location);
        statement.bindString(3,inspector);
        statement.bindString(4, DateOfInspection);
        statement.bindString(5, HouseName);


        statement.executeInsert();
    }
    public Cursor getData(String sql){

        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
