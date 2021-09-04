package com.example.apustruv.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apustruv.Activity.BooksActivity;
import com.example.apustruv.Activity.Chat_screen;
import com.example.apustruv.Activity.MoviesSearchActivity;
import com.example.apustruv.AdapterClass.CommentAdapter;
import com.example.apustruv.AdapterClass.HomePostAdapter;
import com.example.apustruv.Activity.AudioSearchActivity;
import com.example.apustruv.Constant.Constants;
import com.example.apustruv.Interface.OnItemClickListener;
import com.example.apustruv.Model.CommentData;
import com.example.apustruv.Model.HomePostData;
import com.example.apustruv.Model.HomeStatusData;
import com.example.apustruv.R;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HomeFragment extends Fragment implements OnItemClickListener{
    RecyclerView statusRecyler, postRecycler, commentRecycler;
    // ImageView commentIcon;
    EditText messageComment;
    ImageView commentIcon,emoji,chaticon;
    String chtMsg;
    RelativeLayout linearLayout;
    FloatingActionsMenu floatingActionsMenu;
    String tempMessage;
    // BlurView blurView;
    View view;
    FloatingActionButton candleABtn, booksFAB, moviesFAB, cameraFAB, videoFAB, locationFAB, musicFAB, textFAB;
    BottomNavigationView bottomNavigationView;


    List<Integer> data = new ArrayList<>(); // In place of Integer I use HomeStatusData class
    List<CommentData> commentList = new ArrayList<>();

    String JSONURL = "http://www.json-generator.com/api/json/get/cdYLcSmAZe?indent=2";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        messageComment = v.findViewById(R.id.messageID);
        linearLayout = v.findViewById(R.id.homeTimeLineID);
        floatingActionsMenu = v.findViewById(R.id.menuFAMID);
        // blurView = findViewById(R.id.blurLayoutID);
        candleABtn = v.findViewById(R.id.candleID);
      //  booksFAB = v.findViewById(R.id.textDesignFABID);
        moviesFAB = v.findViewById(R.id.moviesFABID);
        cameraFAB = v.findViewById(R.id.cameraFABID);
        locationFAB = v.findViewById(R.id.locatioFABID);
        musicFAB = v.findViewById(R.id.musicFABID);
        textFAB = v.findViewById(R.id.textFABID);
        videoFAB = v.findViewById(R.id.videoFABID);
        commentIcon = v.findViewById(R.id.shareID);
      //  statusRecyler = v.findViewById(R.id.homeStatusRecycler);
        commentRecycler = v.findViewById(R.id.commentSectionRecyclerViewID);
        postRecycler = v.findViewById(R.id.homeRecycler);
        emoji = v.findViewById(R.id.iv_emoji);
        chaticon = v.findViewById(R.id.chatIcon);


        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        data.add(R.drawable.download);
        data.add(R.drawable.download);
        data.add(R.drawable.download);
        data.add(R.drawable.download);
        data.add(R.drawable.download);



     //      fetchingData();


        candleABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
                if (timeOfDay >= 0 && timeOfDay < 12) {
                    Toast.makeText(getActivity(), "Good Morning", Toast.LENGTH_LONG).show();
                } else if (timeOfDay >= 12 && timeOfDay < 16) {
                    Toast.makeText(getActivity(), "Good Afternoon", Toast.LENGTH_LONG).show();
                } else if (timeOfDay >= 16 && timeOfDay < 21) {
                    Toast.makeText(getActivity(), "Good Evening", Toast.LENGTH_LONG).show();
                } else if (timeOfDay >= 21 && timeOfDay < 24) {
                    Toast.makeText(getActivity(), "Good night", Toast.LENGTH_LONG).show();
                }

            }
        });

//        booksFAB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), BooksActivity.class);
//                startActivity(intent);
//            }
//        });
        moviesFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getActivity(), MoviesSearchActivity.class);
               startActivity(intent);
            }
        });
        cameraFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Camera open", Toast.LENGTH_LONG).show();
            }
        });
        videoFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Video start recorded", Toast.LENGTH_LONG).show();
            }
        });
        locationFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Location serach for your", Toast.LENGTH_LONG).show();
            }
        });
        musicFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AudioSearchActivity.class);
                startActivity(intent);
            }
        });
        textFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "This text for only write something", Toast.LENGTH_LONG).show();
            }
        });





             floatingActionsMenu.setOnClickListener(new View.OnClickListener() {

         @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
         @Override
         public void onClick(View view) {
                float radius = 22f;
                View decorView = requireActivity().getWindow().getDecorView();
                decorView.setBackgroundColor(Color.parseColor("#000000"));
             ViewGroup rootView = decorView.findViewById(android.R.id.content);
             Drawable windowsBackground = decorView.getBackground();

           /*  blurView.setupWith(rootView)
                     .setFrameClearDrawable(windowsBackground)
                     .setBlurAlgorithm(new RenderScriptBlur(getActivity())
                     .setBlurRadius(radius)
                     .setHasFixedTransformationMatrix(true);*/
         }
     });

        chaticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Chat_screen.class);
                startActivity(intent);
            }
        });

        postRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        postRecycler.setAdapter(new HomePostAdapter(getActivity(), data, this::onClick));




    }
    @Override
    public void onClick(int position, String data) {

        Toast.makeText(getActivity(), "Data : " + data + " Position :" + position, Toast.LENGTH_SHORT).show();
        postCommentMessage(data);
        // chtMsg = data;
    }


//    private void fetchingData() {
//        RequestQueue requestQueue;
//        requestQueue = Volley.newRequestQueue(getActivity());
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSONURL, null
//                , new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject dataObject = response.getJSONObject(i);
//
//                        HomePostData postData = new HomePostData();
//
//
//                        CommentData comment = new CommentData();
//
//                        postData.setProfileName(dataObject.getString("profileName").toString());
//                        postData.setLikeIncrement(dataObject.getString("like").toString());
//                        postData.setProfilePhoto(dataObject.getString("profilePhoto").toString());
//                        postData.setImagePost(dataObject.getString("imagePost").toString());
//
//                        // Here comment data
//
//                        comment.setProfileName(dataObject.getString("profileName").toString());
//                        comment.setProfileImage(dataObject.getString("profilePhoto").toString());
//                        comment.setCommentMessage(dataObject.getString("commentMessage").toString());
//
//                        data.add(postData);
//                        commentData.add(comment);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//                postRecycler = findViewById(R.id.homeRecycler);
//                postRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                postRecycler.setAdapter(new HomePostAdapter(getApplicationContext(), data));
//
//
//                commentRecycler = findViewById(R.id.commentSectionRecyclerViewID);
//                commentRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                commentRecycler.setAdapter(new CommentAdapter(getApplicationContext(), commentData));
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(jsonArrayRequest);
//    }

    private void postCommentMessage(String chatData) {


        String url = Constants.ADD_COMMENT;

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(getActivity());

        StringRequest jsonObjectRequest = new StringRequest(Request.Method.POST, url , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("payload");

                    if(jsonArray.length() > 0){

                        for(int i=0;i<jsonArray.length();i++){
                            CommentData commentData = new CommentData();
                            commentData.setProfileName(jsonArray.getJSONObject(i).getString("name"));
                            commentData.setProfileImage(jsonArray.getJSONObject(i).getString("profile_img"));
                            commentData.setCommentMessage(jsonArray.getJSONObject(i).getString("content"));
                            commentData.setCountTime(jsonArray.getJSONObject(i).getString("created_time"));

                            commentList.add(commentData);


                        }
                        commentRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                        commentRecycler.setAdapter(new CommentAdapter(getActivity(),commentList));
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> jsonBody = new HashMap<>();
                jsonBody.put("post_id", "1");
                jsonBody.put("content", chatData);
                return jsonBody;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> heads = new HashMap<String, String>();
                heads.put("auth-token", Constants.AUTH_TOKEN);
                return heads;
            }
        };

        requestQueue.add(jsonObjectRequest);
    }
}