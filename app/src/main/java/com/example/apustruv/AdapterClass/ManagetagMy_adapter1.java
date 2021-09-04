package com.example.apustruv.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.Model.ManagetagDatamodel1;
import com.example.apustruv.R;

import java.util.ArrayList;
import java.util.List;

public class ManagetagMy_adapter1 extends RecyclerView.Adapter<ManagetagMy_adapter1.holder>{

    List<ManagetagDatamodel1> list  = new ArrayList<>();
    Context context;


    public ManagetagMy_adapter1(Context context,List<ManagetagDatamodel1>list)
    {
        this.list= list;
        this.context =context;
    }

    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_recycle_manage_tag, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

        //here to change image textfields


       holder.text1.setText((CharSequence) list.get(position));
        holder.text2.setText((CharSequence) list.get(position));

//        //button concept always show
//
//        holder.image2.setImageResource(list.get(position));
//        holder.image3.setImageResource(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        public ImageView image1;
        public TextView text1;
        public TextView text2;
        public ImageView image3;
        public ImageView image2;


        public holder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.image_manageID);
            text1 = itemView.findViewById(R.id.managetextID);
            text2 = itemView.findViewById(R.id.managetext1ID);
            image2 = itemView.findViewById(R.id.image_plusID);
            image3 = itemView.findViewById(R.id.image_checkID);






        }

    }
}
