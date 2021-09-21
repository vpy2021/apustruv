package com.example.apustruv.Activity;

import static android.content.ContentValues.TAG;

import static com.example.apustruv.Activity.SharedPreferenceConfig.Shered_Pref;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.apustruv.Constant.Constants;
import com.example.apustruv.Model.HomePostData;
import com.example.apustruv.Model.SignUpModel;
import com.example.apustruv.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    TextView EditTextview, textClickForSignUp;
    TextView loginbtn;
    TextView textView;
    ImageView backbtn;
    AwesomeValidation awesomeValidation;
    EditText userText, passwordText;
    SharedPreferences sharedPreferences;
    SharedPreferenceConfig sharedPreferenceConfig;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        sharedPreferences = getSharedPreferences(Shered_Pref, MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        Constants.AUTH_TOKEN = sharedPreferences.getString("auth_token","");

        if(!(username.equals("") && password.equals(""))){

            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            finish();
        }


        userText = findViewById(R.id.edit_username);
        passwordText = findViewById(R.id.edit_Password);
        textView = findViewById(R.id.forgettextView);
        loginbtn = findViewById(R.id.buttonLog);
        textClickForSignUp = findViewById(R.id.textClickForSignUpID);
        backbtn = findViewById(R.id.backbtnID);

        textClickForSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.edit_username, RegexTemplate.NOT_EMPTY, R.string.invalidUserName);
        awesomeValidation.addValidation(this, R.id.edit_Password, RegexTemplate.NOT_EMPTY, R.string.passwordincorrect);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginUserName = userText.getText().toString();
                String loginPassword = passwordText.getText().toString();

                if (loginUserName.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please Enter Username", Toast.LENGTH_SHORT).show();
                } else if (loginPassword.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please Enter password", Toast.LENGTH_SHORT).show();
                } else {

                    sendLoginRequest();
                }
            }
        });
    }

    private void sendLoginRequest() {

        RequestQueue requestqueue;
        String url = Constants.LOGIN_URL;
        requestqueue = Volley.newRequestQueue(this);

        StringRequest loginRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "onErrorResponse: " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject value = jsonObject.getJSONObject("payload");

                    Constants.AUTH_TOKEN = value.getString("auth_token");
                    sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());
                    sharedPreferenceConfig.profileImage = value.getString("profile_img");
                    sharedPreferenceConfig.username = userText.getText().toString().trim();
                    sharedPreferenceConfig.password = passwordText.getText().toString().trim();
                    sharedPreferenceConfig.authToken = Constants.AUTH_TOKEN;
                    sharedPreferenceConfig.update(LoginActivity.this);
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    finish();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: " + error);
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hasmap = new HashMap<>();
                hasmap.put("user", userText.getText().toString().trim());
                hasmap.put("password", passwordText.getText().toString().trim());
                hasmap.put("device_type", "A");
                hasmap.put("device_token", "BTC3UHfjR/hIv1IEALkXQ+wBZOVn33");
                return hasmap;
            }
        };
        requestqueue.add(loginRequest);
    }
}