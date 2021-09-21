package com.example.apustruv.AdapterClass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.Model.CommentData;
import com.example.apustruv.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.DataViewHolder> {

    List<CommentData> commentList = new ArrayList<>();
    int limit = 2;

    public CommentAdapter() {

    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapter_comment_layout, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        try {
            CommentData model = commentList.get(position);
          //  Picasso.get().load(model.getProfileImg()).into(holder.commentProfilePhoto);
            holder.commentProfileName.setText(model.getName());
            holder.commentmsg.setText(model.getContent());
            holder.countDay.setText(model.getCreatedTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addItems(List<CommentData> dataList) {
        commentList.clear();
        commentList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(commentList.size()<=limit) {
            return commentList.size();
        }else{
            return limit;
        }
    }

    class DataViewHolder extends RecyclerView.ViewHolder {

        ImageView commentProfilePhoto;
        TextView commentProfileName, commentmsg, countDay;


        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            commentProfilePhoto = itemView.findViewById(R.id.commentStatusImageHome);
            commentProfileName = itemView.findViewById(R.id.commentProfileNameID);
            commentmsg = itemView.findViewById(R.id.commentMessageID);
            countDay = itemView.findViewById(R.id.countDaysID);
        }
    }
}
