package com.example.apustruv.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.apustruv.R;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    TextView EditTextview, textClickForSignUp;
    Button loginButton;
    TextView textView;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        EditTextview = (EditText) findViewById(R.id.edit_username);
        EditTextview = (EditText) findViewById(R.id.edit_Password);
        textView = (TextView) findViewById(R.id.forgettextView);
        loginButton = (Button)findViewById(R.id.buttonLog);
        textClickForSignUp = findViewById(R.id.textClickForSignUpID);

        textClickForSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createData();
                Intent intent = new Intent(LoginActivity.this,LikeActivity.class);
                startActivity(intent);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    private void createData() {
        RequestQueue requestqueue;
        String url="http://www.json-generator.com/api/json/get/bUSlKPjVKa?indent=2";
        requestqueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        });

        requestqueue.add(jsonObjectRequest);
    }

}