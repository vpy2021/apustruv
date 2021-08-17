package com.example.apustruv.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.apustruv.AdapterClass.MemberScreenAdapter;
import com.example.apustruv.Model.MemberScreenData;
import com.example.apustruv.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MemberScreenActivity extends AppCompatActivity {

    ImageView memberProfileImage;
    TextView memberProfileName;
    RecyclerView memberScreenRecycler;

    String JSONURL = "https://www.getpostman.com/collections/9cf4a0cb06a726a786ca";
    List<MemberScreenData> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_screen);

        memberProfileImage = findViewById(R.id.addPhoto);
        memberProfileName = findViewById(R.id.profileNameID);
        memberScreenRecycler = findViewById(R.id.groupMemeberRecyclerID);

        fetchingDataFromAPI();
    }

    private void fetchingDataFromAPI() {

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSONURL,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i=0;i<response.length();i++){

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        MemberScreenData memberScreenData = new MemberScreenData();
                        memberScreenData.setMemberProfileName(jsonObject.getString("user_name").toString());
                        memberScreenData.setMemberProfilePhoto(jsonObject.getString("profile_img").toString());

                        list.add(memberScreenData);

                        memberScreenRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        memberScreenRecycler.setAdapter(new MemberScreenAdapter(getApplicationContext(),list));

                    } catch (JSONException e) {

                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

    }
}