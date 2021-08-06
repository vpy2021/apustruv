package com.example.apustruv;

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

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
public class ChangePassword extends AppCompatActivity {

    EditText oldPassword, newPassword, confirmPassword;
    Button submitBtn;
    ImageView backIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

     //   getActionBar().setDisplayHomeAsUpEnabled(true);

        backIcon = findViewById(R.id.backIcon);
        submitBtn = findViewById(R.id.btn_submit);

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePasswordData();
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

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://www.json-generator.com/api/json/get/cdYLcSmAZe?indent=2",
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
                params.put("userName", oldPass);
                params.put("userName", newPass);
                params.put("userName", confirmPass);

                return params;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }

}