package com.pebblescrow.skillsewaproject;

import android.Manifest;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.pebblescrow.skillsewaproject.utils.ImageUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    EditText edtLocation, edtInspector, edtDOI, edtHN;
    Button btnSelectFrontImage, btnSelectBackImage, btnSave, btnViewList;
    ImageView imgViewFront, imgViewBack;

    final int SELECT_FRONT_IMAGE_FROM_GALLERY_REQUEST_CODE = 999;
    final int SELECT_BACK_IMAGE_FROM_GALLERY_REQUEST_CODE = 1000;

    public static SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sqLiteHelper = new SQLiteHelper(this, "SKILLSEWASTTT.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS SKILLSEWASTTT (ID INTEGER PRIMARY KEY AUTOINCREMENT, frontImage VARCHAR, backImage VARCHAR,  location VARCHAR, inspector VARCHAR, DateOfInspection VARCHAR, houseName VARCHAR)");

        btnSelectFrontImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        SELECT_FRONT_IMAGE_FROM_GALLERY_REQUEST_CODE
                );
            }
        });

        btnSelectBackImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        SELECT_BACK_IMAGE_FROM_GALLERY_REQUEST_CODE
                );

            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String encodedFrontImage = ImageUtils.encodeImageToBase64(imgViewFront);
                    String encodedBackImage = ImageUtils.encodeImageToBase64(imgViewBack);
                    String location = edtLocation.getText().toString().trim();
                    String inspector = edtInspector.getText().toString().trim();
                    String dateOfInspection = edtDOI.getText().toString().trim();
                    String houseName = edtHN.getText().toString().trim();

                    sqLiteHelper.insertData(
                            encodedFrontImage,
                            encodedBackImage,
                            location,
                            inspector,
                            dateOfInspection,
                            houseName
                    );
                    Toast.makeText(getApplicationContext(), "Added successfully", Toast.LENGTH_SHORT).show();

                    imgViewFront.setImageResource(R.mipmap.ic_launcher);
                    imgViewBack.setImageResource(R.mipmap.ic_launcher);
                    edtLocation.setText("");

                    edtInspector.setText("");
                    edtDOI.setText("");
                    edtHN.setText("");

                } catch (Exception e) {
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
        Bitmap bitmap = ((BitmapDrawable) imgViewFront.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == SELECT_FRONT_IMAGE_FROM_GALLERY_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);

                intent.setType("image/*");

                startActivityForResult(intent, SELECT_FRONT_IMAGE_FROM_GALLERY_REQUEST_CODE);


            } else {
                Toast.makeText(getApplicationContext(), "You don't have to access file location", Toast.LENGTH_SHORT).show();
            }
            return;
        } else if (requestCode == SELECT_BACK_IMAGE_FROM_GALLERY_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);

                intent.setType("image/*");

                startActivityForResult(intent, SELECT_BACK_IMAGE_FROM_GALLERY_REQUEST_CODE);


            } else {
                Toast.makeText(getApplicationContext(), "You don't have to access file location", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == SELECT_FRONT_IMAGE_FROM_GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);


                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                imgViewFront.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (requestCode == SELECT_BACK_IMAGE_FROM_GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                imgViewBack.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    private void init() {
        edtLocation = (EditText) findViewById(R.id.edtTxtLocation);

        edtInspector = (EditText) findViewById(R.id.edtTxtInspector);
        edtDOI = (EditText) findViewById(R.id.edtTxtDOI);
        edtHN = (EditText) findViewById(R.id.edtTxtHN);
        btnSelectFrontImage = (Button) findViewById(R.id.btnSelectFrontImage);
        btnSelectBackImage = (Button) findViewById(R.id.btnSelectBackImage);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnViewList = (Button) findViewById(R.id.btnViewList);
        imgViewFront = (ImageView) findViewById(R.id.imgViewFrontPhoto);
        imgViewBack = (ImageView) findViewById(R.id.imgViewBackPhoto);

    }
}