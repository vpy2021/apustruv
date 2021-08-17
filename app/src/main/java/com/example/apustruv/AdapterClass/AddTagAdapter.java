package com.example.apustruv.AdapterClass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.Model.Modelrecycle;
import com.example.apustruv.R;

import java.util.List;

 public class AddTagAdapter extends RecyclerView.Adapter<AddTagAdapter.ViewHolder> {

    private List<Modelrecycle> taglist;

    public AddTagAdapter(List<Modelrecycle> taglist) {

      this.taglist=taglist;
    }


    @Override
    public AddTagAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.designrecycle, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(AddTagAdapter.ViewHolder holder, int position) {

        int  img = taglist.get(position).getImagetag2();
        String txt = taglist.get(position).getAddtextview1();
        String txt1 = taglist.get(position).getAddtextview2();
        String btn = taglist.get(position).getAddbutton();

        holder.setData(img, txt, txt1, btn);


    }


    @Override
    public int getItemCount() {
        return taglist.size();
    }

    public static class
    ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textview1;
        private TextView textview2;
        private TextView textbtn;


        public ViewHolder(View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.imagetag2);
            textview1 = itemView.findViewById(R.id.addtextview1);
            textview2 = itemView.findViewById(R.id.addtextview2);
            textbtn = itemView.findViewById(R.id.addbutton);
        }

        public void setData(int img, String txt, String txt1, String btn) {

//            imageView.setImageResource(img);
            textview1.setText(txt);
            textview2.setText(txt1);
            textbtn.setText(btn);
        }
    }
}

