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
import com.example.apustruv.Model.Reaction_postdatamodel;
import com.example.apustruv.R;

import java.util.ArrayList;
import java.util.List;

public class Reaction_postadapter extends RecyclerView.Adapter<Reaction_postadapter.dataholder> {

    Context context;
  private List<Reaction_postdatamodel> data = new ArrayList<>();


    public Reaction_postadapter(Context context, List<Reaction_postdatamodel> list) {

        this.context = context;
        this.data = list;

    }


    @Override
    public dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_reaction_post, parent, false);
        return new dataholder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull dataholder holder, int position) {

 //       Picasso.get().load(list.get(position).getmenlogo()).into(dataholder.addmenlogo);
//        Picasso.get().load(list.get(position).getmaindraftlogo()).into(dataholder.addmaindraftlogo);


    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class dataholder extends RecyclerView.ViewHolder {

        ImageView menlogo,maindraftlogo;
        TextView profilenamemen,likeincreament,notes;

        public dataholder(@NonNull View itemView) {
            super(itemView);

            menlogo = itemView.findViewById(R.id.menlogo);
            maindraftlogo = itemView.findViewById(R.id.maindraftlogo);
            profilenamemen = itemView.findViewById(R.id.profilenamemen);
            likeincreament = itemView.findViewById(R.id.likeincreament);
            notes = itemView.findViewById(R.id.notes);


        }
    }
}
