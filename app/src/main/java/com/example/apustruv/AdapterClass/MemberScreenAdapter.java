package com.example.apustruv.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.Model.MemberScreenData;
import com.example.apustruv.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MemberScreenAdapter extends RecyclerView.Adapter<MemberScreenAdapter.MemberViewHolder> {
    Context context;
    List<MemberScreenData> list = new ArrayList<>();

    public MemberScreenAdapter(Context context, List<MemberScreenData>list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_memeber_design,parent,false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {

        holder.memberProfileName.setText(list.get(position).getMemberProfileName());
        Picasso.get().load(list.get(position).getMemberProfilePhoto()).into(holder.addPhotoProfile);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MemberViewHolder extends RecyclerView.ViewHolder{

        ImageView addPhotoProfile;
        TextView memberProfileName;

        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);

            addPhotoProfile = itemView.findViewById(R.id.addPhoto);
            memberProfileName = itemView.findViewById(R.id.profileNameID);
        }
    }

}
