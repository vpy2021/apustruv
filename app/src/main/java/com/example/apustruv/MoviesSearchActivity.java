package com.example.apustruv;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.MockView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.apustruv.AdapterClass.MemberScreenAdapter;
import com.example.apustruv.AdapterClass.MoviesSearchAdapter;
import com.example.apustruv.Model.MoviesSearchModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MoviesSearchActivity extends AppCompatActivity {

    ImageView moviesProfilePic;
    TextView moviesTitleName;
    RecyclerView moviesRecycler;
    List<MoviesSearchModel> moviesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_search);

        moviesProfilePic = findViewById(R.id.moviesProfileimgID);
        moviesTitleName = findViewById(R.id.moviesTitleID);
        moviesRecycler = findViewById(R.id.moviesSearchListID);

        moviesListDataFromAPI();
    }

    private void moviesListDataFromAPI() {
        String url = "http://www.apustrov.com/api/v1/tags";

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e(TAG, "onErrorResponse: " + response);

                try {
                    JSONArray jArray = new JSONArray(response.getString("payload"));
                    HashMap<String, String> hashMap;
                    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

//                    if (jArray.length() > 0) {
//                        for (int i = 0; i < jArray.length(); i++) {
//                            hashMap = new HashMap<>();
//                            hashMap.put("name", jArray.getJSONObject(i).getString("name"));
//                            arrayList.add(hashMap);
//                        }
//
//                        moviesRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                        moviesRecycler.setAdapter(new MoviesSearchAdapter(getApplicationContext(), moviesList,arrayList));
//                    }

                    if (jArray.length() > 0) {
                        MoviesSearchModel moviesSearchModel;
                        moviesList=new ArrayList<>();
                        for (int i = 0; i < jArray.length(); i++) {
                           moviesSearchModel=new MoviesSearchModel();
                           moviesSearchModel.setMoviesTitleName(jArray.getJSONObject(i).getString("name"));
                           moviesList.add(moviesSearchModel);
                        }

                        moviesRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        moviesRecycler.setAdapter(new MoviesSearchAdapter(getApplicationContext(), moviesList,arrayList));
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e(TAG, "onErrorResponse: " + error);
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}