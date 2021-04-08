package com.pebblescrow.skillsewaproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    EditText edtLocation, edtInspector, edtDOI, edtHN;
    Button btnSelectImage, btnSave, btnViewList;
    ImageView imgViewFront;

    final int REQUEST_CODE_GALLERY = 999;


    public static SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sqLiteHelper = new SQLiteHelper(this, "SKILLSEWASTTT.sqlite",null,1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS SKILLSEWASTTT (ID INTEGER PRIMARY KEY AUTOINCREMENT, image BLOG, location VARCHAR, inspector VARCHAR, DateOfInspection VARCHAR, houseName VARCHAR)");

        btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                      MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });




        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    sqLiteHelper.insertData(
                            imageViewToByte(imgViewFront),
                            edtLocation.getText().toString().trim(),
                            edtInspector.getText().toString().trim(),
                            edtDOI.getText().toString().trim(),
                            edtHN.getText().toString().trim()



                    );
                    Toast.makeText(getApplicationContext(), "Added successfully", Toast.LENGTH_SHORT).show();
                    imgViewFront.setImageResource(R.mipmap.ic_launcher);
                    edtLocation.setText("");

                    edtInspector.setText("");
                    edtDOI.setText("");
                    edtHN.setText("");

                }
                catch (Exception e){
                   e.printStackTrace();
                }

            }
        });
        btnViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Elementslist.class);
                startActivity(intent);
            }
        });
    }



    private byte[] imageViewToByte(ImageView imgViewFront) {
        Bitmap bitmap = ((BitmapDrawable)imgViewFront.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_GALLERY ){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);

                intent.setType("image/*");

                startActivityForResult(intent, REQUEST_CODE_GALLERY);



            }
            else  {
                Toast.makeText(getApplicationContext(), "You don't have to access file location", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_GALLERY  && resultCode == RESULT_OK && data!= null){
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);


                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                imgViewFront.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    private void init(){
        edtLocation = (EditText) findViewById(R.id.edtTxtLocation);

        edtInspector= (EditText) findViewById(R.id.edtTxtInspector);
        edtDOI = (EditText) findViewById(R.id.edtTxtDOI);
        edtHN = (EditText) findViewById(R.id.edtTxtHN);
        btnSelectImage = (Button) findViewById(R.id.btnSelectImage);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnViewList = (Button) findViewById(R.id.btnViewList);
        imgViewFront = (ImageView) findViewById(R.id.imgViewFrontPhoto);

    }
}