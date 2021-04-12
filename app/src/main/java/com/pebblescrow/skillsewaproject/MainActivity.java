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

    EditText edtLocation, edtInspector, edtDOI, edtHN, edtTxtPFOD, edtTxtPFOF, edtTxtPFOR, edtTxtPFTD, edtTxtPFTF, edtTxtPFTR, edtTxtPFTHD, edtTxtPFTHF, edtTxtPFTHR, edtTxtPFFD, edtTxtPFFF, edtTxtPFFR, edtTxtPFFID, edtTxtPFFIF, edtTxtPFFIR;
    Button btnSelectFrontImage, btnSelectBackImage, btnSelectPD1, btnSave, btnViewList, btnPF1A, btnPF1B, btnPF1C, btnPF2A, btnPF3A, btnPF3B, btnPF3C, btnPF3D, btnPF4A, btnPF4B, btnPF4C, btnPF5A;
    ImageView imgViewFront, imgViewBack, imgViewPD1, imgViewPF1A, imgViewPF1B, imgViewPF1C, imgViewPF2A, imgViewPF3A, imgViewPF3B, imgViewPF3C, imgViewPF3D, imgViewPF4A, imgViewPF4B, imgViewPF4C, imgViewPF5A;

    final int SELECT_FRONT_IMAGE_FROM_GALLERY_REQUEST_CODE = 999;
    final int SELECT_BACK_IMAGE_FROM_GALLERY_REQUEST_CODE = 1000;
    final int SELECT_PD_IMAGE_FROM_GALLERY_REQUEST_CODE = 1001;

    // btnPF1A, btnPF1B, btnPF1C,
    final int SELECT_btnPF1A_IMAGE_FROM_GALLERY_REQUEST_CODE = 1002;
    final int SELECT_btnPF1B_IMAGE_FROM_GALLERY_REQUEST_CODE = 1003;
    final int SELECT_btnPF1C_IMAGE_FROM_GALLERY_REQUEST_CODE = 1004;

    public static SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sqLiteHelper = new SQLiteHelper(this, "SKILLSEWASTTTT.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS SKILLSEWASTTTT (ID INTEGER PRIMARY KEY AUTOINCREMENT, frontImage VARCHAR, backImage VARCHAR, PDImage VARCHAR,  location VARCHAR, inspector VARCHAR, DateOfInspection VARCHAR, houseName VARCHAR, PF1AImage VARCHAR, PF1BImage VARCHAR, PF1CImage VARCHAR, PFOD VARCHAR, PFOF VARCHAR, VARCHAR PFOR)");

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
        btnSelectPD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        SELECT_PD_IMAGE_FROM_GALLERY_REQUEST_CODE
                );

            }
        });


        btnPF1A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        SELECT_btnPF1A_IMAGE_FROM_GALLERY_REQUEST_CODE
                );
            }
        });

        btnPF1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        SELECT_btnPF1B_IMAGE_FROM_GALLERY_REQUEST_CODE
                );

            }
        });
        btnPF1C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        SELECT_btnPF1C_IMAGE_FROM_GALLERY_REQUEST_CODE
                );

            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String encodedFrontImage = ImageUtils.encodeImageToBase64(imgViewFront);
                    String encodedBackImage = ImageUtils.encodeImageToBase64(imgViewBack);
                    String encodedPDImage = ImageUtils.encodeImageToBase64(imgViewPD1);
                    String location = edtLocation.getText().toString().trim();
                    String inspector = edtInspector.getText().toString().trim();
                    String dateOfInspection = edtDOI.getText().toString().trim();
                    String houseName = edtHN.getText().toString().trim();

                    String encodedPF1A = ImageUtils.encodeImageToBase64(imgViewPF1A);
                    String encodedPF1B = ImageUtils.encodeImageToBase64(imgViewPF1B);
                    String encodedPF1C = ImageUtils.encodeImageToBase64(imgViewPF1C);
                    String PFOD = edtTxtPFOD.getText().toString().trim();
                    String PFOF = edtTxtPFOF.getText().toString().trim();
                    String PFOR = edtTxtPFOR.getText().toString().trim();

                    sqLiteHelper.insertData(
                            encodedFrontImage,
                            encodedBackImage,
                            encodedPDImage,
                            location,
                            inspector,
                            dateOfInspection,
                            houseName,
                            encodedPF1A,
                            encodedPF1B,
                            encodedPF1C,
                            PFOD,
                            PFOF,
                            PFOR
                    );
                    Toast.makeText(getApplicationContext(), "Added successfully", Toast.LENGTH_SHORT).show();

                    imgViewFront.setImageResource(R.mipmap.ic_launcher);
                    imgViewBack.setImageResource(R.mipmap.ic_launcher);
                    imgViewPD1.setImageResource(R.mipmap.ic_launcher);
                    edtLocation.setText("");
                    edtInspector.setText("");
                    edtDOI.setText("");
                    edtHN.setText("");
                    imgViewPF1A.setImageResource(R.mipmap.ic_launcher);
                    imgViewPF1B.setImageResource(R.mipmap.ic_launcher);
                    imgViewPF1C.setImageResource(R.mipmap.ic_launcher);
                    edtTxtPFOD.setText("");
                    edtTxtPFOF.setText("");
                    edtTxtPFOR.setText("");

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
        } else if (requestCode == SELECT_PD_IMAGE_FROM_GALLERY_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);

                intent.setType("image/*");

                startActivityForResult(intent, SELECT_PD_IMAGE_FROM_GALLERY_REQUEST_CODE);


            } else {
                Toast.makeText(getApplicationContext(), "You don't have to access file location", Toast.LENGTH_SHORT).show();
            }
            return;
        } else if (requestCode == SELECT_btnPF1A_IMAGE_FROM_GALLERY_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);

                intent.setType("image/*");

                startActivityForResult(intent, SELECT_btnPF1A_IMAGE_FROM_GALLERY_REQUEST_CODE);


            } else {
                Toast.makeText(getApplicationContext(), "You don't have to access file location", Toast.LENGTH_SHORT).show();
            }
            return;
        } else if (requestCode == SELECT_btnPF1B_IMAGE_FROM_GALLERY_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);

                intent.setType("image/*");

                startActivityForResult(intent, SELECT_btnPF1B_IMAGE_FROM_GALLERY_REQUEST_CODE);


            } else {
                Toast.makeText(getApplicationContext(), "You don't have to access file location", Toast.LENGTH_SHORT).show();
            }
            return;
        } else if (requestCode == SELECT_btnPF1C_IMAGE_FROM_GALLERY_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);

                intent.setType("image/*");

                startActivityForResult(intent, SELECT_btnPF1C_IMAGE_FROM_GALLERY_REQUEST_CODE);


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
        } else if (requestCode == SELECT_PD_IMAGE_FROM_GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                imgViewPD1.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (requestCode == SELECT_btnPF1A_IMAGE_FROM_GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                imgViewPF1A.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (requestCode == SELECT_btnPF1B_IMAGE_FROM_GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                imgViewPF1B.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (requestCode == SELECT_btnPF1C_IMAGE_FROM_GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                imgViewPF1C.setImageBitmap(bitmap);

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


        edtTxtPFOD = (EditText) findViewById(R.id.edtTxtPFOD);
        edtTxtPFOF = (EditText) findViewById(R.id.edtTxtPFOF);
        edtTxtPFOR = (EditText) findViewById(R.id.edtTxtPFOR);
        edtTxtPFTD = (EditText) findViewById(R.id.edtTxtPFTD);
        edtTxtPFTF = (EditText) findViewById(R.id.edtTxtPFTF);
        edtTxtPFTR = (EditText) findViewById(R.id.edtTxtPFTR);
        edtTxtPFTHD = (EditText) findViewById(R.id.edtTxtPFTHD);
        edtTxtPFTHF = (EditText) findViewById(R.id.edtTxtPFTHF);
        edtTxtPFTHR = (EditText) findViewById(R.id.edtTxtPFTHR);
        edtTxtPFFD = (EditText) findViewById(R.id.edtTxtPFFD);
        edtTxtPFFF = (EditText) findViewById(R.id.edtTxtPFFF);
        edtTxtPFFR = (EditText) findViewById(R.id.edtTxtPFFR);
        edtTxtPFFID = (EditText) findViewById(R.id.edtTxtPFFID);
        edtTxtPFFIF = (EditText) findViewById(R.id.edtTxtPFFIF);
        edtTxtPFFIR = (EditText) findViewById(R.id.edtTxtPFFIR);


        //BUTTON
        btnSelectFrontImage = (Button) findViewById(R.id.btnSelectFrontImage);
        btnSelectBackImage = (Button) findViewById(R.id.btnSelectBackImage);
        btnSelectPD1 = (Button) findViewById(R.id.btnSelectPD1);

        btnPF1A = (Button) findViewById(R.id.btnPF1A);
        btnPF1B = (Button) findViewById(R.id.btnPF1B);
        btnPF1C = (Button) findViewById(R.id.btnPF1C);
        btnPF2A = (Button) findViewById(R.id.btnPF2A);
        btnPF3A = (Button) findViewById(R.id.btnPF3A);
        btnPF3B = (Button) findViewById(R.id.btnPF3B);
        btnPF3C = (Button) findViewById(R.id.btnPF3C);
        btnPF3D = (Button) findViewById(R.id.btnPF3D);
        btnPF4A = (Button) findViewById(R.id.btnPF4A);
        btnPF4B = (Button) findViewById(R.id.btnPF4B);
        btnPF4C = (Button) findViewById(R.id.btnPF4C);
        btnPF5A = (Button) findViewById(R.id.btnPF5A);


        btnSave = (Button) findViewById(R.id.btnSave);
        btnViewList = (Button) findViewById(R.id.btnViewList);


        // IMGVIEW
        imgViewFront = (ImageView) findViewById(R.id.imgViewFrontPhoto);
        imgViewBack = (ImageView) findViewById(R.id.imgViewBackPhoto);
        imgViewPD1 = (ImageView) findViewById(R.id.imgViewPD1);

        imgViewPF1A = (ImageView) findViewById(R.id.imgViewPF1A);
        imgViewPF1B = (ImageView) findViewById(R.id.imgViewPF1B);
        imgViewPF1C = (ImageView) findViewById(R.id.imgViewPF1C);
        imgViewPF2A = (ImageView) findViewById(R.id.imgViewPF2A);
        imgViewPF3A = (ImageView) findViewById(R.id.imgViewPF3A);
        imgViewPF3B = (ImageView) findViewById(R.id.imgViewPF3B);
        imgViewPF3C = (ImageView) findViewById(R.id.imgViewPF3C);
        imgViewPF3D = (ImageView) findViewById(R.id.imgViewPF3D);
        imgViewPF4A = (ImageView) findViewById(R.id.imgViewPF4A);
        imgViewPF4B = (ImageView) findViewById(R.id.imgViewPF4B);
        imgViewPF4C = (ImageView) findViewById(R.id.imgViewPF4C);
        imgViewPF5A = (ImageView) findViewById(R.id.imgViewPF5A);


    }
}