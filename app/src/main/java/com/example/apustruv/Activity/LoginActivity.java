package com.example.apustruv.Activity;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apustruv.Constant.Constants;
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

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        EditTextview = (EditText) findViewById(R.id.edit_username);
        EditTextview = (EditText) findViewById(R.id.edit_Password);
        textView = (TextView) findViewById(R.id.forgettextView);
        loginbtn = findViewById(R.id.buttonLog);
        textClickForSignUp = findViewById(R.id.textClickForSignUpID);
        backbtn = findViewById(R.id.backbtnID);

        textClickForSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendLoginRequest();

                Intent intent = new Intent(LoginActivity.this, LikeActivity.class);
                startActivity(intent);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

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
                    JSONObject jsonObject=new JSONObject(response);
                    JSONObject value=jsonObject.getJSONObject("payload");
                    Constants.AUTH_TOKEN=value.getString("auth_token");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: " + error);
            }
        })
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hasmap=new HashMap<>();
                hasmap.put("user","shachish@ajath.com");
                hasmap.put("password","admin@123");
                hasmap.put("device_type","A");
                hasmap.put("device_token","BTC3UHfjR/hIv1IEALkXQ+wBZOVn33");
                Log.e("Tag", hasmap.toString());
                return hasmap;

            }
        };

        requestqueue.add(loginRequest);

    }
}