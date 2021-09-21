package com.example.apustruv.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.Model.CommentData;
import com.example.apustruv.Model.CommentReplyModel;
import com.example.apustruv.R;

import java.util.ArrayList;
import java.util.List;

public class CommentReplyAdapter extends RecyclerView.Adapter<CommentReplyAdapter.DataViewHolder>{

    List<CommentReplyModel> commentList = new ArrayList<>();
    Context context;
    public CommentReplyAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapter_comment_layout,parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
          CommentReplyModel commentReplyModel = commentList.get(position);
          holder.profileName.setText(commentReplyModel.getName());
          holder.cmtmsg.setText(commentReplyModel.getChatMsg());
          holder.countdays.setText(commentReplyModel.getTime());
    }

    public void addItems(List<CommentReplyModel> dataList) {
        commentList.clear();
        commentList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder{

        ImageView profileImage;
        TextView profileName,countdays,cmtmsg;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            profileImage = itemView.findViewById(R.id.commentStatusImageHome);
            profileName = itemView.findViewById(R.id.commentProfileNameID);
            countdays = itemView.findViewById(R.id.countDaysID);
            cmtmsg = itemView.findViewById(R.id.commentMessageID);
        }
    }
}
