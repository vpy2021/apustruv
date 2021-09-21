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
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apustruv.AdapterClass.PostreactionAdapter;
import com.example.apustruv.AdapterClass.Reaction_postadapter;
import com.example.apustruv.Model.Postmadalmodel;
import com.example.apustruv.Model.Reaction_postdatamodel;
import com.example.apustruv.R;

import java.util.ArrayList;
import java.util.List;


public class Postpage extends Fragment {

    RecyclerView postRecyclerView,PostreactionRecyclerView;
    ImageView userreaction,emojireaction;
    ImageView menlogo,maindraftlogo;
    TextView profilenamemen,likeincreament,notes;
    RatingBar ratingBar;
    TextView value;


    String JSONURL = "https://www.getpostman.com/collections/9cf4a0cb06a726a786ca";
    List<Postmadalmodel> list = new ArrayList<>();
    List<Reaction_postdatamodel> data = new ArrayList<>();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_postfragmentpage, container, false);

        userreaction = view.findViewById(R.id.userreaction);
        emojireaction = view.findViewById(R.id.emojireaction);
        postRecyclerView =view.findViewById(R.id.recyclerreaction);


        menlogo= view.findViewById(R.id.menlogo);
        maindraftlogo = view.findViewById(R.id.maindraftlogo);
        profilenamemen = view.findViewById(R.id.profilenamemen);
        likeincreament = view.findViewById(R.id.likeincreament);
        notes = view.findViewById(R.id.notes);
        PostreactionRecyclerView = view.findViewById(R.id.homereactionrecycler);


        ratingBar = view.findViewById(R.id.rating_bar);
        int numberOfStars =  ratingBar.getNumStars();
        ratingBar.setNumStars(5);
        ratingBar.setRating((float)3.5);





        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list.add(new Postmadalmodel(1 ,emojireaction));
        list.add(new Postmadalmodel(1 ,emojireaction));



        postRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        postRecyclerView.setAdapter(new PostreactionAdapter(getContext(), list));



        data.add(new Reaction_postdatamodel(1,menlogo));
        data.add(new Reaction_postdatamodel(1,menlogo));


        PostreactionRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        PostreactionRecyclerView.setAdapter(new Reaction_postadapter(getContext(),data));

        

        ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String totalStars = "Total Stars:: " + ratingBar.getNumStars();
                String rating = "Rating :: " + ratingBar.getRating();
                Toast.makeText(getContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();

            }
        });

    }

    private void onClick(int i, String s) {
    }
}


