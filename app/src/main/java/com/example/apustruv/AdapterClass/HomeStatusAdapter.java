package com.example.apustruv.AdapterClass;

import android.annotation.SuppressLint;
import android.app.LauncherActivity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.FetchingData.HomeStatusData;
import com.example.apustruv.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeStatusAdapter extends RecyclerView.Adapter<HomeStatusAdapter.dataViewHolder> {

    List<Integer> list;
    Context context;

    public HomeStatusAdapter(Context context, List<Integer> list) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public dataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.home_recycler_view, parent, false);
        return new dataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dataViewHolder holder, int position) {

        holder.statusImage.setImageResource(list.get(position));
     //   Picasso.get().load(list.get(position).getHomeStatusImage()).into(holder.statusImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class dataViewHolder extends RecyclerView.ViewHolder {

        ImageView statusImage;

        public dataViewHolder(@NonNull View itemView) {
            super(itemView);
            statusImage = itemView.findViewById(R.id.statusID);
        }
    }
}
