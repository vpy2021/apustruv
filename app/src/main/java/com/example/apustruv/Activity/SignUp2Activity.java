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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.apustruv.Constant.Constants;
import com.example.apustruv.Model.SignUpModel;
import com.example.apustruv.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUp2Activity extends AppCompatActivity {


    EditText nickName, age, about;
    ImageView imageView, profileImageView, backbtn;
    Button getStartedBtn;
    AlertDialog alertDialogProfile;
    AwesomeValidation awesomeValidation;
    String loginUserName, loginEmail, loginPassword, loginConfirmPass, loginMobileNum, loginAge, loginNickName, loginAbout;
    String URL = Constants.SignUp;
    String imageProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);


        getStartedBtn = findViewById(R.id.getStartedButton);
        profileImageView = findViewById(R.id.profileImageView);
        nickName = findViewById(R.id.nickNameID);
        age = findViewById(R.id.ageID);
        about = findViewById(R.id.aboutID);
        backbtn = findViewById(R.id.backbutton);

        loginUserName = getIntent().getStringExtra("SignName");
        loginMobileNum = getIntent().getStringExtra("SignMobileNum");
        loginEmail = getIntent().getStringExtra("SignEmail");
        loginPassword = getIntent().getStringExtra("SignPass");
        loginConfirmPass = getIntent().getStringExtra("SignConfirmPass");

        loginNickName = nickName.getText().toString();
        loginAge = age.getText().toString();
        loginAbout = about.getText().toString();


        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.nickNameID, RegexTemplate.NOT_EMPTY, R.string.invalidNickName);
        awesomeValidation.addValidation(this, R.id.aboutID, RegexTemplate.NOT_EMPTY, R.string.invalidAbout);
        awesomeValidation.addValidation(this, R.id.ageID, RegexTemplate.NOT_EMPTY, R.string.invalidAge);

        // click Listner for Profile Photo

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseProfilePicture();
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Click Listner for API

        getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()) {
                    updateData();

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


        RequestQueue MyRequestQueue = Volley.newRequestQueue(this);
        String url = Constants.SignUp;
        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                SignUpModel signUpModel = new SignUpModel();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String value = jsonObject.getString("code");

                    if (value.equals("1")) {
                        //JSONObject jsonObject1 = new JSONObject("payload");
                        /*signUpModel.setSignUpUserName(jsonObject1.getString("user_name"));
                        signUpModel.setSingupPassword(jsonObject1.getString("password"));*/

                        Intent intent = new Intent(SignUp2Activity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();

                    } else if (value.equals("2")) {
                        Toast.makeText(SignUp2Activity.this, value, Toast.LENGTH_SHORT).show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", "onErrorResponse: " + error.toString());
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();
                params.put("user_name", loginUserName);
                params.put("email", loginEmail);
                params.put("mobile", loginMobileNum);
                params.put("password", loginPassword);
                params.put("confirm_password", loginConfirmPass);
                params.put("device_type", "A");
                params.put("device_token", "BTC3UHfjR/hIv1IEALkXQ+wBZOVn33ixPbDFaSVQe6I=");
                params.put("profile_img", "");
                params.put("nick_name", loginNickName);
                params.put("age", loginAge);
                params.put("about", loginAbout);
                params.put("tags_like", "");
                return params;
            }
        };
        MyRequestQueue.add(MyStringRequest);
    }
}