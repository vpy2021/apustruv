package com.example.apustruv.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apustruv.AdapterClass.CommentAdapter;
import com.example.apustruv.AdapterClass.CommentReplyAdapter;
import com.example.apustruv.Constant.Constants;
import com.example.apustruv.Model.CommentData;
import com.example.apustruv.Model.CommentReplyModel;
import com.example.apustruv.Model.HomeDataModel;
import com.example.apustruv.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepliesActivity extends AppCompatActivity {

    RecyclerView cmtRecycler;
    ImageView back;
    CommentReplyAdapter commentReplyAdapter;
    int id ;


    List<CommentReplyModel> commentDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_replies);

        cmtRecycler = findViewById(R.id.commentRecycerID);
        back = findViewById(R.id.backIcon);

        id = getIntent().getIntExtra("postID",0);
        cmtRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        commentReplyAdapter = new CommentReplyAdapter(getApplicationContext());
        cmtRecycler.setAdapter(commentReplyAdapter);

        getHomeData();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    private void getHomeData() {
        String Home_URL = Constants.GET_ALL_COMMENT;
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST, Home_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "onResponse: " + response);
                try {

                    commentDataList = new ArrayList<>();
                    CommentReplyModel commentReplyModel;

                    JSONObject payloadObject = new JSONObject(response);
                    JSONArray jsonArray = payloadObject.getJSONArray("payload");

                    if (jsonArray.length() > 0) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            commentReplyModel = new CommentReplyModel();
                            commentReplyModel.setTime(jsonArray.getJSONObject(i).getString("created_time"));
                            commentReplyModel.setId(jsonArray.getJSONObject(i).getString("id"));
                            commentReplyModel.setName(jsonArray.getJSONObject(i).getString("name"));
                            commentReplyModel.setChatMsg(jsonArray.getJSONObject(i).getString("content"));

                            commentDataList.add(commentReplyModel);

                        }
                        commentReplyAdapter.addItems(commentDataList);

                    } else {
                        Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> hashmap = new HashMap<>();
                CommentData commentData = new CommentData();
                String id1 = Integer.toString(id);
                hashmap.put("page", "1");
                hashmap.put("limit", "100");
                hashmap.put("post_id", id1);
                return hashmap;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> heads = new HashMap<String, String>();
                heads.put("auth-token", Constants.AUTH_TOKEN);
                return heads;
            }
        };
        requestQueue.add(jsonArrayRequest);
    }
}