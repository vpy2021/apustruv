package com.example.apustruv.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity<mobilenumber> extends AppCompatActivity {

    EditText userName, emailID, mobilenumber, password, confirmPassword;
    Button nextButton;
    AwesomeValidation awesomeValidation;
    TextView loginreached;
    ImageView backbtn;
    String userName1, emailID1, mobilenum, password1, confirmPassword1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nextButton = (Button) findViewById(R.id.nextButton);
        userName = (EditText) findViewById(R.id.userNameID);
        mobilenumber = findViewById(R.id.mobileID);
        emailID = (EditText) findViewById(R.id.emailID);
        password = (EditText) findViewById(R.id.passwordID);
        confirmPassword = (EditText) findViewById(R.id.confirmPasswordID);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        loginreached = findViewById(R.id.textViewID);
        backbtn = findViewById(R.id.backIcon);


        userName1 = userName.getText().toString().trim();
        mobilenum = mobilenumber.getText().toString().trim();
        emailID1 = emailID.getText().toString().trim();
        password1 = password.getText().toString().trim();
        confirmPassword1 = confirmPassword.getText().toString().trim();


        awesomeValidation.addValidation(this, R.id.userNameID, RegexTemplate.NOT_EMPTY, R.string.invalidUserName);
        awesomeValidation.addValidation(this, R.id.mobileID, RegexTemplate.NOT_EMPTY, R.string.invalidMobileNumber);
        awesomeValidation.addValidation(this, R.id.emailID, Patterns.EMAIL_ADDRESS, R.string.invalidEmailID);
        awesomeValidation.addValidation(this, R.id.passwordID, ".{6}", R.string.invalidPassword);
        awesomeValidation.addValidation(this, R.id.confirmPasswordID, R.id.newPasswordID, R.string.invalidConfirmPassword);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (awesomeValidation.validate()) {

                    Intent intent = new Intent(SignUpActivity.this, SignUp2Activity.class);
                    intent.putExtra("SignName", userName.getText().toString().trim());
                    intent.putExtra("SignMobileNum", mobilenumber.getText().toString().trim());
                    intent.putExtra("SignEmail", emailID.getText().toString().trim());
                    intent.putExtra("SignPass", password.getText().toString().trim());
                    intent.putExtra("SignConfirmPass", confirmPassword.getText().toString().trim());

                    startActivity(intent);
                }

            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        loginreached.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}