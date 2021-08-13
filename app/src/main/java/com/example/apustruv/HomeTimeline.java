package com.example.apustruv;


import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.apustruv.AdapterClass.CommentAdapter;
import com.example.apustruv.AdapterClass.HomePostAdapter;
import com.example.apustruv.AdapterClass.HomeStatusAdapter;
import com.example.apustruv.FetchingData.CommentData;
import com.example.apustruv.FetchingData.HomePostData;
import com.example.apustruv.FetchingData.HomeStatusData;

import com.example.apustruv.Interface.OnItemClickListener;

import com.getbase.floatingactionbutton.FloatingActionButton;

import com.getbase.floatingactionbutton.FloatingActionsMenu;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class HomeTimeline extends AppCompatActivity implements OnItemClickListener {

    RecyclerView statusRecyler, postRecycler, commentRecycler;
     ImageView commentIcon;
    EditText messageComment;
    String chtMsg;
    LinearLayout linearLayout;
    FloatingActionsMenu floatingActionsMenu;

    BlurView blurView;
    FloatingActionButton candleABtn,textDesignFAB,moviesFAB,cameraFAB,videoFAB,locationFAB,musicFAB,textFAB;


public class HomeTimeline extends AppCompatActivity {

    RecyclerView statusRecyler, postRecycler, commentRecycler;
    // ImageView commentIcon;
    EditText messageComment;


    List<Integer> list = new ArrayList<>(); /// In place of Integer I use HomePostData class
    List<Integer> data = new ArrayList<>(); // In place of Integer I use HomeStatusData class
    List<CommentData> commentData = new ArrayList<>();
    private static String JSONURL = "http://www.json-generator.com/api/json/get/cdYLcSmAZe?indent=2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_timeline);

        messageComment = findViewById(R.id.messageID);

        linearLayout = findViewById(R.id.homePageLayoutID);
        floatingActionsMenu = findViewById(R.id.menuFAMID);
        blurView = findViewById(R.id.blurLayoutID);

        candleABtn = findViewById(R.id.candleID);
        textDesignFAB = findViewById(R.id.textDesignFABID);
        moviesFAB = findViewById(R.id.moviesFABID);
        cameraFAB = findViewById(R.id.cameraFABID);
        locationFAB = findViewById(R.id.locatioFABID);
        musicFAB = findViewById(R.id.musicFABID);
        textFAB = findViewById(R.id.textFABID);
        videoFAB = findViewById(R.id.videoFABID);


        commentIcon = findViewById(R.id.shareID);


        //     commentIcon = findViewById(R.id.shareID);
//        @SuppressLint("ResourceType")
//        LinearLayout linearLayout = findViewById(R.layout.activity_comment_section_layout);


        list.add(R.drawable.dummyimage);
        list.add(R.drawable.dummyimage);
        list.add(R.drawable.dummyimage);
        list.add(R.drawable.dummyimage);
        list.add(R.drawable.dummyimage);
        list.add(R.drawable.dummyimage);
        list.add(R.drawable.dummyimage);

        data.add(R.drawable.download);
        data.add(R.drawable.download);
        data.add(R.drawable.download);
        data.add(R.drawable.download);
        data.add(R.drawable.download);

        //   fetchingData();

       // postCommentMessage();

        candleABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
                if(timeOfDay >= 0 && timeOfDay < 12){
                    Toast.makeText(getApplicationContext(),"Good Morning",Toast.LENGTH_LONG).show();
                }else if(timeOfDay >= 12 && timeOfDay < 16){
                    Toast.makeText(getApplicationContext(),"Good Afternoon",Toast.LENGTH_LONG).show();
                }else if(timeOfDay >=16 && timeOfDay < 21){
                    Toast.makeText(getApplicationContext(),"Good Evening",Toast.LENGTH_LONG).show();
                }else if(timeOfDay >= 21 && timeOfDay < 24){
                    Toast.makeText(getApplicationContext(),"Good night",Toast.LENGTH_LONG).show();
                }

            }
        });
        textDesignFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"WOW this is for post layout",Toast.LENGTH_LONG).show();
            }
        });
        moviesFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Wow this movies for you",Toast.LENGTH_LONG).show();
            }
        });
        cameraFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Camera open",Toast.LENGTH_LONG).show();
            }
        });
        videoFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Video start recorded",Toast.LENGTH_LONG).show();
            }
        });
        locationFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Location serach for your",Toast.LENGTH_LONG).show();
            }
        });
        musicFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"music start",Toast.LENGTH_LONG).show();
            }
        });
        textFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"This text for only write something",Toast.LENGTH_LONG).show();
            }
        });

//     floatingActionsMenu.setOnClickListener(new View.OnClickListener() {
//
//         @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
//         @Override
//         public void onClick(View view) {
//                float radius = 22f;
//                View decorView = getWindow().getDecorView();
//                decorView.setBackgroundColor(Color.parseColor("#000000"));
//             ViewGroup  rootView = decorView.findViewById(android.R.id.content);
//             Drawable windowsBackground = decorView.getBackground();
//
//             blurView.setupWith(rootView)
//                     .setFrameClearDrawable(windowsBackground)
//                     .setBlurAlgorithm(new RenderScriptBlur(getApplicationContext()))
//                     .setBlurRadius(radius)
//                     .setHasFixedTransformationMatrix(true);
//         }
//     });

     floatingActionsMenu.setOnClickListener(new View.OnClickListener() {

         @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
         @Override
         public void onClick(View view) {
                float radius = 22f;
                View decorView = getWindow().getDecorView();
             ViewGroup  rootView = decorView.findViewById(android.R.id.content);
             Drawable windowsBackground = decorView.getBackground();

             blurView.setupWith(rootView)
                   //  .setFrameClearDrawable(windowsBackground)
                     .setBlurAlgorithm(new RenderScriptBlur(getApplicationContext()))
                     .setBlurRadius(radius)
                     .setHasFixedTransformationMatrix(true);
         }



        statusRecyler = findViewById(R.id.homeStatusRecycler);
        statusRecyler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

      //  postCommentMessage();

//        commentIcon.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceType")
//            @Override
//            public void onClick(View view) {
//                if (linearLayout.getVisibility() == View.GONE){
//                    linearLayout.setVisibility(View.VISIBLE);
//                }
//            }
//        });

        statusRecyler = findViewById(R.id.homeStatusRecycler);
        statusRecyler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, true));

        statusRecyler.setAdapter(new HomeStatusAdapter(getApplicationContext(), list));

        postRecycler = findViewById(R.id.homeRecycler);
        postRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        postRecycler.setAdapter(new HomePostAdapter(getApplicationContext(), data,this));

       /* commentRecycler = findViewById(R.id.commentSectionRecyclerViewID);
        commentRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        commentRecycler.setAdapter(new CommentAdapter(getApplicationContext(), commentData));*/

        postRecycler.setAdapter(new HomePostAdapter(getApplicationContext(), data));

        commentRecycler = findViewById(R.id.commentSectionRecyclerViewID);
        commentRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        commentRecycler.setAdapter(new CommentAdapter(getApplicationContext(), commentData));


    }


//    private void fetchingData() {
//        RequestQueue requestQueue;
//        requestQueue = Volley.newRequestQueue(this);
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSONURL, null
//                , new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                for(int i=0;i<response.length();i++){
//                    try {
//                        JSONObject dataObject = response.getJSONObject(i);
//
//                        HomePostData postData = new HomePostData();
//
//                        HomeStatusData statusData = new HomeStatusData();
//
//                        CommentData comment = new CommentData();
//
//                        postData.setProfileName(dataObject.getString("profileName").toString());
//                        postData.setLikeIncrement(dataObject.getString("like").toString());
//                        postData.setProfilePhoto(dataObject.getString("profilePhoto").toString());
//                        postData.setImagePost(dataObject.getString("imagePost").toString());
//
//                        // Home status data
//                //        statusData.setHomeProfileImage(dataObject.getString("homeProfileImage").toString());
//                        statusData.setHomeStatusImage(dataObject.getString("homeStatusImage").toString());
//
//                        // Here comment data
//
//                        comment.setProfileName(dataObject.getString("profileName").toString());
//                        comment.setProfileImage(dataObject.getString("profilePhoto").toString());
//                        comment.setCommentMessage(dataObject.getString("commentMessage").toString());
//
//                        data.add(postData);
//                        list.add(statusData);
//                        commentData.add(comment);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//                postRecycler = findViewById(R.id.homeRecycler);
//                postRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                postRecycler.setAdapter(new HomePostAdapter(getApplicationContext(),data));
//
//                statusRecyler = findViewById(R.id.homeStatusRecycler);
//                statusRecyler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,true));
//                statusRecyler.setAdapter(new HomeStatusAdapter(getApplicationContext(),list));
//
//                commentRecycler = findViewById(R.id.commentSectionRecyclerViewID);
//                commentRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                commentRecycler.setAdapter(new CommentAdapter(getApplicationContext(),commentData));
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(jsonArrayRequest);

//}


    private void postCommentMessage() {




    private void postCommentMessage() {





        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://www.json-generator.com/api/json/get/cdYLcSmAZe?indent=2",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("commentMessage", chtMsg);

                return params;
            }
        };

        requestQueue.add(jsonObjectRequest);
    }
    @Override
    public void onClick(int position, String data) {
   //  Log.d("Ramvilas" ,position+" "+data);
           chtMsg = data;
    }


//    private void postCommentMessage() {
//
//        String message = messageComment.getText().toString();
//
//        RequestQueue requestQueue;
//        requestQueue = Volley.newRequestQueue(this);
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://www.json-generator.com/api/json/get/cdYLcSmAZe?indent=2",
//                null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
//            }
//        }) {
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("commentMessage", message);
//
//                return params;
//            }
//        };
//
//        requestQueue.add(jsonObjectRequest);


}