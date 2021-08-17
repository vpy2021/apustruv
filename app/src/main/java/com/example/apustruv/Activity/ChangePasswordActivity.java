package com.example.apustruv.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.apustruv.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
public class ChangePasswordActivity extends AppCompatActivity {

   EditText oldPassword, newPassword, confirmPassword;
   Button submitBtn;
   ImageView backIcon;
   AwesomeValidation awesomeValidation;

   String URL = "https://www.getpostman.com/collections/9cf4a0cb06a726a786ca";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);


        backIcon = findViewById(R.id.backIcon);
        submitBtn = findViewById(R.id.btn_submit);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);


        awesomeValidation.addValidation(this,R.id.newPasswordID,".{6}",R.string.invalidPassword);
        awesomeValidation.addValidation(this,R.id.confirmPasswordID,R.id.newPasswordID,R.string.invalidConfirmPassword);


        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(awesomeValidation.validate()){
                   updatePasswordData();
               }
            }
        });
    }
    private void updatePasswordData() {

        oldPassword = (EditText) findViewById(R.id.oldPasswordID);
        newPassword = (EditText) findViewById(R.id.newPasswordID);
        confirmPassword = (EditText) findViewById(R.id.confirmPasswordID);

        final String oldPass = oldPassword.getText().toString().trim();
        final String newPass = newPassword.getText().toString().trim();
        final String confirmPass = confirmPassword.getText().toString().trim();


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


           //     params.put("userName", oldPass);
                params.put("password", newPass);
                params.put("confirm_password", confirmPass);

                return params;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }

}