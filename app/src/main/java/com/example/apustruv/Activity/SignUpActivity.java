package com.example.apustruv.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.apustruv.R;

public class SignUpActivity<mobilenumber> extends AppCompatActivity {

    EditText userName, emailID,mobilenumber, password, confirmPassword;
    Button nextButton;
    AwesomeValidation awesomeValidation;
    TextView loginreached;

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



        awesomeValidation.addValidation(this,R.id.userNameID, RegexTemplate.NOT_EMPTY,R.string.invalidUserName);
        awesomeValidation.addValidation(this,R.id.mobileID,RegexTemplate.NOT_EMPTY,R.string.invalidMobileNumber);
        awesomeValidation.addValidation(this,R.id.emailID, Patterns.EMAIL_ADDRESS, R.string.invalidEmailID);
        awesomeValidation.addValidation(this,R.id.passwordID,".{6}",R.string.invalidPassword);
        awesomeValidation.addValidation(this,R.id.confirmPasswordID,R.id.newPasswordID,R.string.invalidConfirmPassword);




        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(awesomeValidation.validate()){
                 //   sendPostRequest();
                    Intent intent = new Intent(SignUpActivity.this,SignUp2Activity.class);
                    startActivity(intent);
                }

            }
        });

        loginreached.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
//    private void sendPostRequest() {
//
//
//
//      final String userName1 = userName.getText().toString().trim();
//      final String mobilenumber = mobileID.getText().toString().trim();
//        final String emailID1 = emailID.getText().toString().trim();
//        final String password1 = password.getText().toString().trim();
//        final String confirmPassword1 = confirmPassword.getText().toString().trim();
//
//        RequestQueue MyRequestQueue = Volley.newRequestQueue(this);
//        String url = "http://staging.ajath.com/forumias/api/v1/userSignupNew";
//        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
//            }
//        }) {
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("userName", userName1);
//                param.put("mobilenumber",mobilenumber);
//                params.put("email", emailID1);
//                params.put("password", password1);
//                params.put("confirm_password", confirmPassword1);
//                return params;
//            }
//        };
//        MyRequestQueue.add(MyStringRequest);
//    }
}