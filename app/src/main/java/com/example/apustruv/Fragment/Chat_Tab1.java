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

import com.example.apustruv.AdapterClass.Chat_tab1_adapter;
import com.example.apustruv.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Chat_Tab1 extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Integer> list= new ArrayList<>();
    LinearLayoutManager layoutManager;
    TabLayout tablayout;



    public Chat_Tab1() {
        // Required empty public constructor

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab1, container, false);

        recyclerView = v.findViewById(R.id.Recycle_chatID);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new Chat_tab1_adapter(getActivity(), list));

        return v;




    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.add(R.id.image_profileID);
        }
}