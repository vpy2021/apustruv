package com.example.apustruv.AdapterClass;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.FetchingData.HomePostData;

import com.example.apustruv.Interface.OnItemClickListener;

import com.example.apustruv.R;
import com.squareup.picasso.Picasso;

import java.io.PipedOutputStream;
import java.util.List;

public class HomePostAdapter extends RecyclerView.Adapter<HomePostAdapter.dataViewHolder> {


    List<Integer> data;
    Context context;
    LayoutInflater layoutInflater;
    OnItemClickListener onItemClickListener;

    public HomePostAdapter(Context context, List<Integer> data, OnItemClickListener onItemClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
        this.onItemClickListener = onItemClickListener;


    @NonNull
    @Override
    public dataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_post, parent, false);
        return new dataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dataViewHolder holder, int position) {
//       holder.profileName.setText(data.get(position).getProfileName());
//       holder.like.setText(data.get(position).getLikeIncrement());
//        Picasso.get().load(data.get(position).getProfilePhoto()).into(holder.profileImage);
//        Picasso.get().load(data.get(position).getImagePost()).into(holder.postImage);

        holder.postImage.setImageResource(data.get(position));

        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.llactionComment.setVisibility(View.VISIBLE);
            }
        });

        holder.ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = holder.edtComment.getText().toString().trim();
                onItemClickListener.onClick(position, inputValue);
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    class dataViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImage, postImage, comment, share, refresh, heart, ivSend;
        TextView profileName, follow, like, reportDot, notes;
        LinearLayout llactionComment;
        EditText edtComment;

    class dataViewHolder extends RecyclerView.ViewHolder{

        ImageView profileImage,postImage,comment,share,refresh,heart;
        TextView profileName,follow,like,reportDot,notes;


        public dataViewHolder(@NonNull View itemView) {
            super(itemView);
//

            comment = itemView.findViewById(R.id.commentIconID);
            profileImage = itemView.findViewById(R.id.statusImageHome);
            postImage = itemView.findViewById(R.id.postImageID);
            profileName = itemView.findViewById(R.id.profileNameID);
            like = itemView.findViewById(R.id.likeInc);
            llactionComment = itemView.findViewById(R.id.ll_action_coment_layout);
            edtComment = itemView.findViewById(R.id.messageID);
            ivSend = itemView.findViewById(R.id.iv_send);

            profileImage = itemView.findViewById(R.id.statusImageHome);
            postImage = itemView.findViewById(R.id.postImageID);
           profileName = itemView.findViewById(R.id.profileNameID);
           like = itemView.findViewById(R.id.likeInc);

        }
    }
}
