package com.example.apustruv.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.R;

import java.util.List;

public class Chat_tab1_adapter extends RecyclerView.Adapter<Chat_tab1_adapter.ViewHolder> {

    List<Integer>list;
    Context context;

    public Chat_tab1_adapter(Context context, List<Integer>list){
        this.list=list;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_chat_recycle, parent, false);
        return new Chat_tab1_adapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       // holder.image_profile.setImageResource(list.get(position));
        //   Picasso.get().load(list.get(position).getHomeStatusImage()).into(holder.statusImage);
        holder.count.setText(list.get(position));
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView image_profile;
         TextView count;


        public ViewHolder(View itemview) {
            super(itemview);
            image_profile = itemView.findViewById(R.id.image_profileID);
            count = itemview.findViewById(R.id.count_ID);
        }
    }
}
