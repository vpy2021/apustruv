package com.example.apustruv.AdapterClass;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.example.apustruv.Model.FollowingModel;
import com.example.apustruv.Model.NotificationModel;
import com.example.apustruv.R;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class PostFollowingAdapter extends RecyclerView.Adapter<PostFollowingAdapter.dataholder> {

    private Context context;
    List<FollowingModel> arraylist = new ArrayList<>();


    public PostFollowingAdapter(Context context){
        this.context = context;

    }


    @Override
    public PostFollowingAdapter.dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_following_recyclescreen, parent, false);
        return new PostFollowingAdapter.dataholder(view);


    }


    @Override
    public void onBindViewHolder(@NonNull PostFollowingAdapter.dataholder holder, int position) {

        FollowingModel model = arraylist.get(position);

    //    .setText(model.getFollowingimage());
        holder.followingheading.setText(model.getFollowingheading());
        holder.followingdescription.setText(model.getFollowingdescription());


    }

    @SuppressLint("NotifyDataSetChanged")
    public void addItems(List<FollowingModel> list){
        arraylist.clear();
        arraylist.addAll(list);
        notifyDataSetChanged();
    }





    @Override
    public int getItemCount() {
        return arraylist.size();
    }

    public class dataholder extends RecyclerView.ViewHolder {

        ImageView followingimage;
        TextView followingheading,followingdescription;

        public dataholder(@NonNull View itemView) {
            super(itemView);

            followingimage = itemView.findViewById(R.id.followingimage);
            followingheading = itemView.findViewById(R.id.followingheading);
            followingdescription = itemView.findViewById(R.id.followingdesricption);


        }
    }
}
