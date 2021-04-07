package com.pebblescrow.skillsewaproject;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Elementslist extends AppCompatActivity {

    GridView gridView;
    ArrayList<Elements> list;
    ElementsListAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_list_activity);

        gridView = (GridView) findViewById(R.id.gridViewReport);
        list = new ArrayList<>();
        adapter = new ElementsListAdapter(this, R.layout.report_elements, list);
        gridView.setAdapter(adapter);

        //get all data from sqlite
        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM SKILLSEWA");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            byte[] image = cursor.getBlob(1);
            String location = cursor.getString(2);
            String city = cursor.getString(3);
            String inspector = cursor.getString(4);
            String DOI = cursor.getString(5);
            String HouseName = cursor.getString(6);

            list.add(new Elements(id, image, location, city, inspector, DOI, HouseName ));

        }
        adapter.notifyDataSetChanged();
    }
}
