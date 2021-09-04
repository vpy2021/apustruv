package com.example.apustruv.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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

public class SignUp2Activity extends AppCompatActivity {


    EditText nickName, age, about;
    ImageView imageView, profileImageView,backbutton;
    Button getStartedBtn;
    AlertDialog alertDialogProfile;
    AwesomeValidation awesomeValidation;

    String URL = "https://www.getpostman.com/collections/9cf4a0cb06a726a786ca";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);


        getStartedBtn = (Button) findViewById(R.id.getStartedButton);
        profileImageView = (ImageView) findViewById(R.id.profileImageView);
        nickName = (EditText) findViewById(R.id.nickNameID);
        age = (EditText) findViewById(R.id.ageID);
        about = (EditText) findViewById(R.id.aboutID);


        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.nickNameID, RegexTemplate.NOT_EMPTY,R.string.invalidNickName);
        awesomeValidation.addValidation(this,R.id.aboutID, RegexTemplate.NOT_EMPTY,R.string.invalidAbout);
        awesomeValidation.addValidation(this,R.id.ageID, RegexTemplate.NOT_EMPTY,R.string.invalidAge);

        // click Listner for Profile Photo

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseProfilePicture();
            }
        });

//        backbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });

        // Click Listner for API

        getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(awesomeValidation.validate()){
             //     updateData();
                  Intent intent = new Intent(SignUp2Activity.this,LoginActivity.class);
                  startActivity(intent);
              }
            }
        });
    }

    // Here we choose Camera or Galary option for take photo

    private void chooseProfilePicture() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUp2Activity.this);
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

    // Here code for Camera photo

    private void takePictureFromCamera() {

        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePicture.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePicture, 2);
        }
    }

    // check permision when we try to take picture from camera

    private boolean checkPermisionRequest() {

        if (Build.VERSION.SDK_INT >= 23) {
            int cameraPermission = ActivityCompat.checkSelfPermission(SignUp2Activity.this, Manifest.permission.CAMERA);
            if (cameraPermission == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(SignUp2Activity.this, new String[]{Manifest.permission.CAMERA}, 20);
                return false;
            }
        }
        return true;
    }

    // Here RequestPermision result check

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 20 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            takePictureFromCamera();

        } else {
            /// To check third case
            if (!ActivityCompat.shouldShowRequestPermissionRationale(SignUp2Activity.this, Manifest.permission.CAMERA)) {
                Log.e("TAG", "onRequestPermissionsResult: " + "");
                Toast.makeText(SignUp2Activity.this, "Permission permanent denied", Toast.LENGTH_SHORT).show();
                return;
            } else {
                Toast.makeText(SignUp2Activity.this, "Permission Not Granted", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Here take photo through galary

    private void takePictureFromGalary() {
        Intent takePhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(takePhoto, 1);
    }

    // Here we simply store image on Profile

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case 1:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    profileImageView.setImageURI(selectedImage);
                }
                break;

            case 2:
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    Bitmap bitmapImage = (Bitmap) bundle.get("data");
                    profileImageView.setImageBitmap(bitmapImage);
                }
        }
    }

    // Here is coding for API Call

    private void updateData() {



        final String nickName1 = nickName.getText().toString().trim();
        final String age1 = age.getText().toString();
        final String about1 = about.getText().toString().trim();

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,URL,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("nick_name", nickName1);
                params.put("age", age1);
                params.put("about", about1);
                return params;
            }
        };

        requestQueue.add(jsonObjectRequest);
    }


}