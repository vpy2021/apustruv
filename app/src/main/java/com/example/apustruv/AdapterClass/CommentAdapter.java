package com.example.apustruv.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EdgeEffect;
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

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.DataViewHolder>  {
     Context context;
     List<CommentData>comment = new ArrayList<>();
    public CommentAdapter(Context context, List<CommentData>comment) {
        this.context = context;
        this.comment = comment;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_comment, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Picasso.get().load(comment.get(position).getProfileImage()).into(holder.commentProfilePhoto);
        holder.commentProfileName.setText(comment.get(position).getProfileName());
        holder.commentmsg.setText(comment.get(position).getCommentMessage());
        holder.countDay.setText(comment.get(position).getCountTime());

    }

    @Override
    public int getItemCount() {
        return comment.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder {

          ImageView commentProfilePhoto,ivSend;
          TextView commentProfileName, commentmsg,countDay;
          LinearLayout linearLayout;
          EditText edtComment;

       public DataViewHolder(@NonNull View itemView) {
           super(itemView);

           commentProfilePhoto = itemView.findViewById(R.id.commentStatusImageHome);
           commentProfileName = itemView.findViewById(R.id.commentProfileNameID);
           commentmsg = itemView.findViewById(R.id.commentMessageID);
           countDay = itemView.findViewById(R.id.countDaysID);
           linearLayout = itemView.findViewById(R.id.ll_action_coment_layout);
           edtComment = itemView.findViewById(R.id.messageID);
          // ivSend = itemView.findViewById(R.id.iv_send);
       }
   }
}
