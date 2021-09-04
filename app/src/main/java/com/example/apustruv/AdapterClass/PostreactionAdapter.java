package com.example.apustruv.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.Model.Followersdatamodel;
import com.example.apustruv.Model.Postmadalmodel;
import com.example.apustruv.R;

import java.util.ArrayList;
import java.util.List;

public class PostreactionAdapter extends RecyclerView.Adapter<PostreactionAdapter.postholder> {

    Context context;
    List<Postmadalmodel> list = new ArrayList<>();


    public PostreactionAdapter(Context context, List<Postmadalmodel> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public postholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_post_reaction_emoji, parent, false);
        return new postholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull postholder holder, int position) {

//        Picasso.get().load(list.get(position).getusereaction()).into(postholder.adduserreaction);
//        Picasso.get().load(list.get(position).getEmojireaction()).into(postholder.addemojireaction);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class postholder extends RecyclerView.ViewHolder {

        ImageView userreaction;
        ImageView emojireaction;

        public postholder(@NonNull View itemView) {
            super(itemView);

            userreaction = itemView.findViewById(R.id.userreaction);
            emojireaction = itemView.findViewById(R.id.emojireaction);

        }
    }
}
