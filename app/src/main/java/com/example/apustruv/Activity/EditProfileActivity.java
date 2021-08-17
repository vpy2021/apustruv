package com.example.apustruv.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.apustruv.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class EditProfileActivity extends AppCompatActivity {

    EditText name,userName,about,dateOfBirth,mobileNumber,emailID;
    ImageView addPhoto;
    Button submitButton;
    AlertDialog alertDialogProfile;
    ImageView onBack;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        submitButton = findViewById(R.id.submitButton);
        onBack = findViewById(R.id.backIcon);
        addPhoto =  findViewById(R.id.addPhoto);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        name = (EditText) findViewById(R.id.nameID);
        userName = (EditText) findViewById(R.id.userNameID);
        about = (EditText) findViewById(R.id.aboutProfileID);
        dateOfBirth = (EditText) findViewById(R.id.ageID);
        mobileNumber = (EditText) findViewById(R.id.mobileID);
        emailID = (EditText) findViewById(R.id.emailID);


        // validation check

        awesomeValidation.addValidation(this,R.id.nameID, RegexTemplate.NOT_EMPTY
                ,R.string.invalidName);
        awesomeValidation.addValidation(this,R.id.userNameID, RegexTemplate.NOT_EMPTY
                ,R.string.invalidUserName);
        awesomeValidation.addValidation(this,R.id.aboutProfileID, RegexTemplate.NOT_EMPTY
                ,R.string.invalidUserName);
        awesomeValidation.addValidation(this,R.id.ageID, RegexTemplate.NOT_EMPTY
                ,R.string.invalidAge);
        awesomeValidation.addValidation(this,R.id.mobileID,"[5-9]{1}[0-9]{9}$",R.string.invalidNumber);
        awesomeValidation.addValidation(this,R.id.emailID, Patterns.EMAIL_ADDRESS, R.string.invalidEmailID);

        onBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseProfilePicture();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()){
                    editProfileData();
                }
            }
        });


    }

    private void chooseProfilePicture() {
        AlertDialog.Builder builder = new AlertDialog.Builder(EditProfileActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_alert_dialogbox_camera, null);
        builder.setView(dialogView);

        ImageView dialogCamera = dialogView.findViewById(R.id.dialogCamera);
        ImageView dialogGalary = dialogView.findViewById(R.id.dialogGalary);

        alertDialogProfile = builder.create();
        alertDialogProfile.show();
        alertDialogProfile.setCancelable(true);


        dialogCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPermisionRequest()) {
                    takePictureFromCamera();
                    alertDialogProfile.cancel();
                }
            }
        });

        dialogGalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePictureFromGalary();
                alertDialogProfile.cancel();
            }
        });
    }

    private void takePictureFromGalary() {
        Intent takePhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(takePhoto, 1);
    }

    private void takePictureFromCamera() {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePicture.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePicture, 2);
        }
    }

    private boolean checkPermisionRequest() {
        if (Build.VERSION.SDK_INT >= 23) {
            int cameraPermission = ActivityCompat.checkSelfPermission(EditProfileActivity.this, Manifest.permission.CAMERA);
            if (cameraPermission == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.CAMERA}, 20);
                return false;
            }
        }
        return true;
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 20 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            takePictureFromCamera();

        } else {
            /// To check third case
            if (!ActivityCompat.shouldShowRequestPermissionRationale(EditProfileActivity.this, Manifest.permission.CAMERA)) {
          //      Log.e("TAG", "onRequestPermissionsResult: " + "");
                Toast.makeText(EditProfileActivity.this, "Permission permanent denied", Toast.LENGTH_SHORT).show();
                return;
            } else {
                Toast.makeText(EditProfileActivity.this, "Permission Not Granted", Toast.LENGTH_SHORT).show();
            }
        }
    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case 1:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    addPhoto.setImageURI(selectedImage);
                }
                break;

            case 2:
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    Bitmap bitmapImage = (Bitmap) bundle.get("data");
                    addPhoto.setImageBitmap(bitmapImage);
                }
        }
    }

    private void editProfileData() {


        addPhoto = (ImageView) findViewById(R.id.addPhoto);

        final String name1 = name.getText().toString().trim();
        final String userName1 = userName.getText().toString().trim();
        final String about1 = about.getText().toString().trim();
        final String DOB = dateOfBirth.getText().toString().trim();
        final String mobileNumber1 = mobileNumber.getText().toString().trim();
        final String emailID1 = emailID.getText().toString().trim();

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://www.json-generator.com/api/json/get/cdYLcSmAZe?indent=2",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Toast.makeText(getApplicationContext(),response.toString(), Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user_name", userName1);
                params.put("userName", name1);
                params.put("about", about1);
                params.put("userName", DOB);
                params.put("email", mobileNumber1);
                params.put("password", emailID1);
                return params;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }
}