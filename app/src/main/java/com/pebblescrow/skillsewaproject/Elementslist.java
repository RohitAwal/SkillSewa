package com.pebblescrow.skillsewaproject;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

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

        // get all data from sqlite
        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM SKILLSEWASTTTTT");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String encodedFrontImage = cursor.getString(1);
            String encodedBackImage = cursor.getString(2);
            String encodedPDImage = cursor.getString(3);
            String location = cursor.getString(4);
            String inspector = cursor.getString(5);
            String DOI = cursor.getString(6);
            String HouseName = cursor.getString(7);

            String encodedPF1A = cursor.getString(8);
            String encodedPF1B = cursor.getString(9);
            String encodedPF1C = cursor.getString(10);
            String PFOD = cursor.getString(11);
            String PFOF = cursor.getString(12);
            String PFOR = cursor.getString(13);

            String encodedPF2A = cursor.getString(14);
            String PFTD = cursor.getString(15);
            String PFTF = cursor.getString(16);
            String PFTR = cursor.getString(17);


            String encodedPF3A = cursor.getString(18);
            String encodedPF3B = cursor.getString(19);
            String encodedPF3C = cursor.getString(20);
            String encodedPF3D = cursor.getString(21);
            String PFTHD = cursor.getString(22);
            String PFTHF = cursor.getString(23);
            String PFTHR = cursor.getString(24);

            String encodedPF4A = cursor.getString(25);
            String encodedPF4B = cursor.getString(26);
            String encodedPF4C = cursor.getString(27);
            String PFFD = cursor.getString(28);
            String PFFF = cursor.getString(29);
            String PFFR = cursor.getString(30);

            String encodedPF5A = cursor.getString(31);
            String PFFID = cursor.getString(32);
            String PFFIF = cursor.getString(33);
            String PFFIR = cursor.getString(34);

//            encodedPF1A ,encodedPF1B ,encodedPF1C, PFOD ,PFOF ,PFOR ,encodedPF2A ,PFTD ,PFTF ,PFTR ,encodedPF3A ,encodedPF3B ,encodedPF3C ,encodedPF3D, PFTHD ,PFTHF ,PFTHR ,encodedPF4A ,encodedPF4B ,encodedPF4C, PFFD ,PFFF, PFFR ,encodedPF5A, PFFID ,PFFIF ,PFFIR

            list.add(new Elements(id, encodedFrontImage, encodedBackImage, encodedPDImage, location, inspector, DOI, HouseName, encodedPF1A, encodedPF1B, encodedPF1C, PFOD, PFOF, PFOR, encodedPF2A, PFTD, PFTF, PFTR, encodedPF3A, encodedPF3B, encodedPF3C, encodedPF3D, PFTHD, PFTHF, PFTHR, encodedPF4A, encodedPF4B, encodedPF4C, PFFD, PFFF, PFFR, encodedPF5A, PFFID, PFFIF, PFFIR));

        }
        adapter.notifyDataSetChanged();
    }
}
