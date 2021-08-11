package com.example.apustruv.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.FetchingData.CommentData;
import com.example.apustruv.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.DataViewHolder>  {
     Context context;
     List<CommentData>comment;
    public CommentAdapter(Context context, List<CommentData>commen) {
        this.context = context;
        this.comment = comment;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_comment, parent, false);
        return new CommentAdapter.DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Picasso.get().load(comment.get(position).getProfileImage()).into(holder.commentProfilePhoto);
        holder.commentProfileName.setText(comment.get(position).getProfileName());
        holder.messageComment.setText(comment.get(position).getCommentMessage());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class DataViewHolder extends RecyclerView.ViewHolder {

          ImageView commentProfilePhoto;
          TextView commentProfileName, messageComment;

       public DataViewHolder(@NonNull View itemView) {
           super(itemView);

           commentProfilePhoto = itemView.findViewById(R.id.commentStatusImageHome);
           commentProfileName = itemView.findViewById(R.id.commentProfileNameID);
           messageComment = itemView.findViewById(R.id.commentMessageID);
       }
   }
}
