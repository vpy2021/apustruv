package com.example.apustruv.AdapterClass;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.Activity.CommentRepliesActivity;
import com.example.apustruv.Interface.OnItemClickListener;
import com.example.apustruv.R;

import java.util.List;

public class HomePostAdapter extends RecyclerView.Adapter<HomePostAdapter.dataViewHolder> {

    List<Integer>data;
    Context context;
    LayoutInflater layoutInflater;
    OnItemClickListener onItemClickListener;
    public HomePostAdapter(Context context,List<Integer>data,OnItemClickListener onItemClickListener) {
       this.layoutInflater = LayoutInflater.from(context);
       this.data = data;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public dataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_post, parent, false);
        return new dataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dataViewHolder holder, @SuppressLint("RecyclerView") int position) {
//       holder.profileName.setText(data.get(position).getProfileName());
//       holder.like.setText(data.get(position).getLikeIncrement());
//        Picasso.get().load(data.get(position).getProfilePhoto()).into(holder.profileImage);
//        Picasso.get().load(data.get(position).getImagePost()).into(holder.postImage);

        holder.postImage.setImageResource(data.get(position));

        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if( holder.llactionComment.getVisibility() == View.GONE){
                   holder.llactionComment.setVisibility(View.VISIBLE);
               }else{
                   holder.llactionComment.setVisibility(View.GONE);
               }
            }
        });

        holder.ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = holder.edtComment.getText().toString().trim();
                holder.commentmsg.setText(inputValue);
                onItemClickListener.onClick(position, inputValue);
            }
        });

       holder.showMoreReply.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(holder.itemView.getContext(), CommentRepliesActivity.class);
               holder.itemView.getContext().startActivity(intent);
           }
       });

//        EmojiPopup popup = EmojiPopup.Builder
//                .fromRootView(holder.view).build(holder.edtComment);
//        holder.emoji.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                popup.toggle();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class dataViewHolder extends RecyclerView.ViewHolder{

        ImageView profileImage,postImage,comment,share,refresh,heart,ivSend,emoji;
        TextView profileName,follow,like,reportDot,notes,commentmsg,showMoreReply;
        LinearLayout llactionComment;
        EditText edtComment;
        View view;

        public dataViewHolder(@NonNull View itemView) {
            super(itemView);
//
            profileImage = itemView.findViewById(R.id.statusImageHome);
            postImage = itemView.findViewById(R.id.postImageID);
            profileName = itemView.findViewById(R.id.profileNameID);
            like = itemView.findViewById(R.id.likeInc);
            comment = itemView.findViewById(R.id.commentIconID);
            llactionComment = itemView.findViewById(R.id.ll_action_coment_layout);
            edtComment = itemView.findViewById(R.id.messageID);
            ivSend = itemView.findViewById(R.id.iv_send);
            emoji = itemView.findViewById(R.id.iv_emoji);
            commentmsg = itemView.findViewById(R.id.commentMessageID);
            showMoreReply = itemView.findViewById(R.id.showMoreCommentID);
        }
    }
}
