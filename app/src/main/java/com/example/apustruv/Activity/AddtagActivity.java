package com.example.apustruv.Activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.apustruv.AdapterClass.Adapters;
import com.example.apustruv.Model.Modelrecycle;
import com.example.apustruv.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddtagActivity extends AppCompatActivity {

    private static String baseurl = "   ";

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Modelrecycle> taglist;
    Adapters adapter;
    ImageView imageView;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtag);

        initData();
        initRecyclerview();

        imageView = findViewById(R.id.backbtn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        addtagListdatafromAPI();

    }


    private void addtagListdatafromAPI() {
        String url = "  ";

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        //change request if condition required on API condition json request object,jsonArray depend on API
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jArray = new JSONArray(response.getString("key value required"));
//                    HashMap<String,String> hashMap;
                    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

                    if (jArray.length() > 0) {
                        Modelrecycle modelrecycle;
                        taglist = new ArrayList<>();

                        for (int i = 0; i < jArray.length(); i++) {
                            modelrecycle = new Modelrecycle();
                            modelrecycle.setImagetag2(jArray.getJSONObject(i).getString("image"));
                            modelrecycle.setaddtextview1(jArray.getJSONObject(i).getString("text1"));
                            modelrecycle.setAddtextview2(jArray.getJSONObject(i).getString("text2"));

                            taglist.add(modelrecycle);

                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            recyclerView.setAdapter(new Adapters(getApplicationContext(), taglist, arrayList));


                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    public void initData() {
        taglist = new ArrayList<>();
        //     taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
        //taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
//        taglist.add(new Modelrecycle(R.id.imagetag2,"#recipes","100 posts","Add"));
//        taglist.add(new Modelrecycle(R.id.imagetag2,"#recipes","100 posts","Add"));
//        taglist.add(new Modelrecycle(R.id.imagetag2,"#recipes","100 posts","Add"));
//        taglist.add(new Modelrecycle(R.id.imagetag2,"#recipes","100 posts","Add"));
//


    }

    private void initRecyclerview() {


    }
}

