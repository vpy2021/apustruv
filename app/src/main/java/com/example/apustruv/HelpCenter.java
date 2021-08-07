package com.example.apustruv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HelpCenter extends AppCompatActivity {

    EditText helpCenterText;
    Button submtBtn;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);

        submtBtn = findViewById(R.id.submitButton);
/// This is for demo
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.helpCenterInputText, RegexTemplate.NOT_EMPTY
                ,R.string.invalid);
        submtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()){
                    messageHelpCenterUpdate();
                }else{
                    Toast.makeText(getApplicationContext(),"Text Cannot be Empty",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void messageHelpCenterUpdate() {
        helpCenterText = findViewById(R.id.helpCenterInputText);

        String helpData = helpCenterText.getText().toString();

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

                Toast.makeText(getApplicationContext(), error.toString(),Toast.LENGTH_LONG).show();

            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
               params.put("issueData",helpData);
                return params;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }
}