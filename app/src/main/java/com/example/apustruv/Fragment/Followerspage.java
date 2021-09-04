package com.example.apustruv.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apustruv.AdapterClass.FollowersAdapter;
import com.example.apustruv.AdapterClass.PostreactionAdapter;
import com.example.apustruv.Model.Followersdatamodel;
import com.example.apustruv.Model.Postmadalmodel;
import com.example.apustruv.R;

import java.util.ArrayList;
import java.util.List;

public class Followerspage extends Fragment{


    RecyclerView followerRecyclerView;
    ImageView followersimage;
    TextView heading,description;




    List<Followersdatamodel> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_followerspage, container, false);
        followerRecyclerView = view.findViewById(R.id.rv_follower_recyclerview);
        followersimage = view.findViewById(R.id.followersimageID);
        heading = view.findViewById(R.id.headingID);
        description = view.findViewById(R.id.description);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);






        followerRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        followerRecyclerView.setAdapter(new FollowersAdapter(getContext(),list));


    }


}