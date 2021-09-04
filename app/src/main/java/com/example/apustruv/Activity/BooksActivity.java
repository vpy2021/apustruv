package com.example.apustruv.Activity;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apustruv.AdapterClass.BooksSearchAdapter;
import com.example.apustruv.Constant.Constants;
import com.example.apustruv.Model.BooksSearchModel;
import com.example.apustruv.R;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BooksActivity extends AppCompatActivity {

    RecyclerView booksRecycler;
    List<BooksSearchModel> bookSearchList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        booksRecycler = findViewById(R.id.booksSearchListID);

        booksdatacollection();

    }

    private void booksdatacollection() {

        String url = Constants.BOOKS_URL;
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        StringRequest jsonObjectRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject1 = new JSONObject(response);
                    JSONObject jsonObject2 = jsonObject1.getJSONObject("payload");
                    JSONArray generalArray = jsonObject2.getJSONArray("general");

                    if (generalArray.length() > 0) {
                        for (int i = 0; i < generalArray.length(); i++) {

                            BooksSearchModel booksSearchModel = new BooksSearchModel();
                            booksSearchModel.setBookTitleName(generalArray.getJSONObject(i).getString("title"));
                            booksSearchModel.setBookImage(generalArray.getJSONObject(i).getString("post_url"));
                            bookSearchList.add(booksSearchModel);

                        }

                        booksRecycler.setAdapter(new BooksSearchAdapter(getApplicationContext(), bookSearchList));
                        booksRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("auth-token", Constants.AUTH_TOKEN);
                return headers;
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> jsonBody = new HashMap<>();
                jsonBody.put("str", "");
                jsonBody.put("page", "1");
                jsonBody.put("limit", "10");

                return jsonBody;
            }
        };

        requestQueue.add(jsonObjectRequest);
    }
}
