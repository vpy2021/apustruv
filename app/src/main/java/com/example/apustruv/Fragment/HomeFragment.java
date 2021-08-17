package com.example.apustruv.Fragment;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.apustruv.AdapterClass.HomePostAdapter;
import com.example.apustruv.Interface.OnItemClickListener;
import com.example.apustruv.R;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class HomeFragment extends Fragment implements OnItemClickListener{
    RecyclerView statusRecyler, postRecycler, commentRecycler;
    // ImageView commentIcon;
    EditText messageComment;
    ImageView commentIcon,emoji;
    String chtMsg;
    RelativeLayout linearLayout;
    FloatingActionsMenu floatingActionsMenu;
    // BlurView blurView;
    View view;
    FloatingActionButton candleABtn, textDesignFAB, moviesFAB, cameraFAB, videoFAB, locationFAB, musicFAB, textFAB;
    BottomNavigationView bottomNavigationView;


    List<Integer> data = new ArrayList<>(); // In place of Integer I use HomeStatusData class

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
        textDesignFAB = v.findViewById(R.id.textDesignFABID);
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



//        //   fetchingData();
//        //  postCommentMessage();
//


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

        textDesignFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "WOW this is for post layout", Toast.LENGTH_LONG).show();
            }
        });
        moviesFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Wow this movies for you", Toast.LENGTH_LONG).show();
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
                Toast.makeText(getActivity(), "music start", Toast.LENGTH_LONG).show();
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

        postRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        postRecycler.setAdapter(new HomePostAdapter(getActivity(), data, this::onClick));




    }
    @Override
    public void onClick(int position, String data) {
        Log.d("Mess", position + " " + data);

        Toast.makeText(getActivity(), "Data : " + data + " Position :" + position, Toast.LENGTH_SHORT).show();

        // chtMsg = data;
    }


////    private void fetchingData() {
////        RequestQueue requestQueue;
////        requestQueue = Volley.newRequestQueue(this);
////        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSONURL, null
////                , new Response.Listener<JSONArray>() {
////            @Override
////            public void onResponse(JSONArray response) {
////
////                for(int i=0;i<response.length();i++){
////                    try {
////                        JSONObject dataObject = response.getJSONObject(i);
////
////                        HomePostData postData = new HomePostData();
////
////                        HomeStatusData statusData = new HomeStatusData();
////
////                        CommentData comment = new CommentData();
////
////                        postData.setProfileName(dataObject.getString("profileName").toString());
////                        postData.setLikeIncrement(dataObject.getString("like").toString());
////                        postData.setProfilePhoto(dataObject.getString("profilePhoto").toString());
////                        postData.setImagePost(dataObject.getString("imagePost").toString());
////
////                        // Home status data
////                //        statusData.setHomeProfileImage(dataObject.getString("homeProfileImage").toString());
////                        statusData.setHomeStatusImage(dataObject.getString("homeStatusImage").toString());
////
////                        // Here comment data
////
////                        comment.setProfileName(dataObject.getString("profileName").toString());
////                        comment.setProfileImage(dataObject.getString("profilePhoto").toString());
////                        comment.setCommentMessage(dataObject.getString("commentMessage").toString());
////
////                        data.add(postData);
////                        list.add(statusData);
////                        commentData.add(comment);
////
////                    } catch (JSONException e) {
////                        e.printStackTrace();
////                    }
////                }
////                postRecycler = findViewById(R.id.homeRecycler);
////                postRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
////                postRecycler.setAdapter(new HomePostAdapter(getApplicationContext(),data));
////
////                statusRecyler = findViewById(R.id.homeStatusRecycler);
////                statusRecyler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,true));
////                statusRecyler.setAdapter(new HomeStatusAdapter(getApplicationContext(),list));
////
////                commentRecycler = findViewById(R.id.commentSectionRecyclerViewID);
////                commentRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
////                commentRecycler.setAdapter(new CommentAdapter(getApplicationContext(),commentData));
////            }
////        }, new Response.ErrorListener() {
////            @Override
////            public void onErrorResponse(VolleyError error) {
////
////            }
////        });
////        requestQueue.add(jsonArrayRequest);
//
////    private void postCommentMessage() {
////
////        String message = messageComment.getText().toString();
////
////        RequestQueue requestQueue;
////        requestQueue = Volley.newRequestQueue(this);
////
////        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://www.json-generator.com/api/json/get/cdYLcSmAZe?indent=2",
////                null, new Response.Listener<JSONObject>() {
////            @Override
////            public void onResponse(JSONObject response) {
////
////
////            }
////        }, new Response.ErrorListener() {
////            @Override
////            public void onErrorResponse(VolleyError error) {
////                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
////            }
////        }) {
////            protected Map<String, String> getParams() {
////                Map<String, String> params = new HashMap<String, String>();
////                params.put("commentMessage", message);
////
////                return params;
////            }
////        };
////
////        requestQueue.add(jsonObjectRequest);

}