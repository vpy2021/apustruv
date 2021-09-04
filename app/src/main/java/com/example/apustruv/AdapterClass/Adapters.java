package com.example.apustruv.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.graphics.drawable.IconCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.Model.Modelrecycle;
import com.example.apustruv.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Adapters extends RecyclerView.Adapter<Adapters.ViewHolder> {

    ArrayList<Modelrecycle> taglist;
    Context context;
    List<HashMap<String, String>> arrayList;


    public Adapters(Context applicationContext, List<Modelrecycle> taglist, ArrayList<HashMap<String, String>> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
        this.taglist = (ArrayList<Modelrecycle>) taglist;

    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.designrecycle, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

//        int img = taglist.get(position).getImagetag2();
//        String txt = taglist.get(position).getAddtextview1();
//        String txt1 = taglist.get(position).getAddtextview2();
//        String btn = taglist.get(position).getAddbutton();
//holder.setData(img, txt, txt1, btn);

//        Picasso.get().load(taglist.get(position).getImagetag2()).into(holder.addimg);
       holder.imagetag2.setImageResource(Integer.parseInt(taglist.get(position).getImagetag2().toString()));

    }


    @Override
    public int getItemCount() {
        return taglist.size();
    }

    public static class
    ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagetag2;
        TextView textview1;
        TextView textview2;
        TextView textbtn;


        public ViewHolder(View itemView) {
            super(itemView);


            imagetag2= itemView.findViewById(R.id.imagetag2);
            textview1 = itemView.findViewById(R.id.addtextview1);
            textview2 = itemView.findViewById(R.id.addtextview2);
            textbtn = itemView.findViewById(R.id.addbutton);



        }



        }
    }

