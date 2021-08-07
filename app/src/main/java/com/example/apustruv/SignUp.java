package com.example.apustruv;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.apustruv.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    EditText userName, emailID, password, confirmPassword;
    Button nextButton;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nextButton = (Button) findViewById(R.id.nextButton);
        userName = (EditText) findViewById(R.id.userNameID);
        emailID = (EditText) findViewById(R.id.emailID);
        password = (EditText) findViewById(R.id.passwordID);
        confirmPassword = (EditText) findViewById(R.id.confirmPasswordID);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.userNameID, RegexTemplate.NOT_EMPTY
                ,R.string.invalidUserName);
        awesomeValidation.addValidation(this,R.id.emailID, Patterns.EMAIL_ADDRESS, R.string.invalidEmailID);
        awesomeValidation.addValidation(this,R.id.passwordID,".{6}",R.string.invalidPassword);
        awesomeValidation.addValidation(this,R.id.confirmPasswordID,R.id.newPasswordID,R.string.invalidConfirmPassword);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(awesomeValidation.validate()){
                    sendPostRequest();
                }

            }
        });

    }
    private void sendPostRequest() {



        final String userName1 = userName.getText().toString().trim();
        final String emailID1 = emailID.getText().toString().trim();
        final String password1 = password.getText().toString().trim();
        final String confirmPassword1 = confirmPassword.getText().toString().trim();

        RequestQueue MyRequestQueue = Volley.newRequestQueue(this);
        String url = "http://staging.ajath.com/forumias/api/v1/userSignupNew";
        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("userName", userName1);
                params.put("email", emailID1);
                params.put("password", password1);
                params.put("confirm_password", confirmPassword1);
                return params;
            }
        };
        MyRequestQueue.add(MyStringRequest);
    }
}