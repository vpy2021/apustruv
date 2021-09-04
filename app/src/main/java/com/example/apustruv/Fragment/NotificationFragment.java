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
import com.example.apustruv.AdapterClass.NotificationAdapter;
import com.example.apustruv.Constant.Constants;
import com.example.apustruv.Model.NotificationModel;
import com.example.apustruv.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NotificationFragment extends Fragment {
    RecyclerView notificationRecyclerView;
    BottomNavigationView bottomNavigationView;
    NotificationAdapter notificationAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notification_i, container, false);

        notificationAdapter=new NotificationAdapter(requireContext());
        notificationRecyclerView = view.findViewById(R.id.R_i);
        notificationRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        notificationRecyclerView.setAdapter(notificationAdapter);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getNotificationData();
    }

    private void getNotificationData() {

        String NotificationURL = Constants.NOTIFICATION_URL;
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        StringRequest request = new StringRequest(Request.Method.POST, NotificationURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    List<NotificationModel> notificationArrayList=new ArrayList<>();
                    NotificationModel model;
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray value=jsonObject.getJSONArray("payload");
                    for(int i=0;i<value.length();i++){
                        model=new NotificationModel();
                        model.setDesc(value.getJSONObject(i).getString("title"));
                        model.setHead(value.getJSONObject(i).getString("message"));
                        model.setTime(value.getJSONObject(i).getString("created_time"));
                        notificationArrayList.add(model);
                    }
                    notificationAdapter.addItems(notificationArrayList);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e(TAG, "onResponse: "+"" );

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


