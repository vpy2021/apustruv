package com.example.apustruv.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.Model.Followersdatamodel;
import com.example.apustruv.Model.Postmadalmodel;
import com.example.apustruv.R;

import java.util.ArrayList;
import java.util.List;

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.dataholder> {

    private Context context;
    private List<Followersdatamodel> list = new ArrayList<>();

    public FollowersAdapter(Context Context, List<Followersdatamodel> list) {
        this.context = Context;
        this.list = list;

    }

    @Override
    public FollowersAdapter.dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_followers_recycler, parent, false);

        return new dataholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowersAdapter.dataholder holder, int position) {

//        Picasso.get().load(list.get(position).getfollowersimage()).into(dataholder.addfollowersimage);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class dataholder extends RecyclerView.ViewHolder {
        ImageView followersimage;
        TextView heading, description;


        public dataholder(@NonNull View itemView) {
            super(itemView);

            followersimage = itemView.findViewById(R.id.followersimageID);
            heading = itemView.findViewById(R.id.headingID);
            description = itemView.findViewById(R.id.description);
                   }
    }
}
