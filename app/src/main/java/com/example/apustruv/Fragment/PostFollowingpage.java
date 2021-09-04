package com.example.apustruv.Fragment;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apustruv.AdapterClass.PostFollowingAdapter;
import com.example.apustruv.Constant.Constants;
import com.example.apustruv.Model.FollowingModel;
import com.example.apustruv.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PostFollowingpage extends Fragment {

    RecyclerView followingRecyclerview;
    PostFollowingAdapter postFollowingAdapter;
    List<FollowingModel> arraylist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_followingpage, container, false);

        postFollowingAdapter=new PostFollowingAdapter(requireContext());
        followingRecyclerview = view.findViewById(R.id.rv_following_recyclerview);
        followingRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        followingRecyclerview.setAdapter(postFollowingAdapter);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        getPostfollowingdata();

    }

    private void getPostfollowingdata() {

        String FOLLOWING_URL = Constants.FOLLOWING_URL;
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        StringRequest request = new StringRequest(Request.Method.POST, FOLLOWING_URL, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                try {
                    List<FollowingModel> Followingarraylist = new ArrayList<>();
                    FollowingModel model;
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray value = jsonObject.getJSONArray("payload");
                    for (int i = 0; i < value.length(); i++) {
                        model = new FollowingModel();
                        model.setFollowingheading(value.getJSONObject(i).getString("nick_name"));
                        model.setFollowingdescription(value.getJSONObject(i).getString("message"));
                        Followingarraylist.add(model);

                    }
                    postFollowingAdapter.addItems(Followingarraylist);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e(TAG, "onResponse: " + "");
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("auth-token", Constants.AUTH_TOKEN);
                return params;

            }


        };

        requestQueue.add(request);


    }
}


