package com.example.apustruv.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apustruv.Activity.Chat_screen;
import com.example.apustruv.Activity.MoviesSearchActivity;
import com.example.apustruv.AdapterClass.CommentAdapter;
import com.example.apustruv.AdapterClass.HomeAdapter;
import com.example.apustruv.Activity.AudioSearchActivity;
import com.example.apustruv.Constant.Constants;
import com.example.apustruv.Interface.OnItemClickListener;
import com.example.apustruv.Model.CommentData;
import com.example.apustruv.Model.HomeDataModel;
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

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;


public class HomeFragment extends Fragment {
    RecyclerView  postRecycler;
    ImageView commentIcon, emoji, chaticon;
    RelativeLayout relativeLayout;
    FloatingActionsMenu floatingActionsMenu;
    View mView;
    LinearLayout floatingLayout;
    FloatingActionButton candleABtn, moviesFAB, cameraFAB, videoFAB, locationFAB, musicFAB, textFAB;

    List<Integer> data = new ArrayList<>();
    List<HomeDataModel> homeDataModels;
    HomeAdapter homeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        relativeLayout = v.findViewById(R.id.homeTimeLineID);
        floatingActionsMenu = v.findViewById(R.id.menuFAMID);
        mView = v.findViewById(R.id.shadowView);
        floatingLayout = v.findViewById(R.id.floatingLayout);
        candleABtn = v.findViewById(R.id.candleID);
        moviesFAB = v.findViewById(R.id.moviesFABID);
        cameraFAB = v.findViewById(R.id.cameraFABID);
        locationFAB = v.findViewById(R.id.locatioFABID);
        musicFAB = v.findViewById(R.id.musicFABID);
        textFAB = v.findViewById(R.id.textFABID);
        videoFAB = v.findViewById(R.id.videoFABID);
        commentIcon = v.findViewById(R.id.clickLike);

        homeAdapter = new HomeAdapter(requireActivity());
        postRecycler = v.findViewById(R.id.homeRecycler);
        postRecycler.setLayoutManager(new LinearLayoutManager(requireActivity()));
        postRecycler.setAdapter(homeAdapter);
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
        getHomeData();

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

        floatingActionsMenu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onMenuExpanded() {
                mView.setVisibility(View.VISIBLE);
            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onMenuCollapsed() {
                mView.setVisibility(View.GONE);
            }
        });

        chaticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Chat_screen.class);
                startActivity(intent);
            }
        });
    }

    private void getHomeData() {
        String Home_URL = Constants.Home_URL;
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.POST, Home_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "onResponse: " + response);
                try {

                    homeDataModels = new ArrayList<>();
                    HomeDataModel homeDataModel;
                    JSONObject payloadObject = new JSONObject(response);
                    JSONArray jsonArray = payloadObject.getJSONArray("payload");

                    if (jsonArray.length() > 0) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            homeDataModel = new HomeDataModel();
                            homeDataModel.setId(Integer.parseInt(jsonArray.getJSONObject(i).getString("id")));
                            homeDataModel.setPostUrl(jsonArray.getJSONObject(i).getString("post_url"));

                            homeDataModels.add(homeDataModel);
                        }
                        homeAdapter.addItems(homeDataModels);

                    } else {
                        Toast.makeText(requireActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
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
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> hashmap = new HashMap<>();
                hashmap.put("str", "");
                hashmap.put("page", "1");
                hashmap.put("limit", "10");
                return hashmap;
            }
        };
        requestQueue.add(jsonArrayRequest);
    }
}