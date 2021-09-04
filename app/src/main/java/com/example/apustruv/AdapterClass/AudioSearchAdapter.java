package com.example.apustruv.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.Model.AudioSearchModel;
import com.example.apustruv.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AudioSearchAdapter extends RecyclerView.Adapter<AudioSearchAdapter.AudioSearchHolder> {

    Context context;
    List<AudioSearchModel>list = new ArrayList<>();

    public AudioSearchAdapter(Context context, List<AudioSearchModel> list){
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public AudioSearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_audio_search,parent,false);
        return new AudioSearchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AudioSearchHolder holder, int position) {

        holder.bookTitleName.setText(list.get(position).getAudioTitleName());
        Picasso.get().load(list.get(position).getAudioImage()).into(holder.booksImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class AudioSearchHolder extends RecyclerView.ViewHolder{

        ImageView booksImage;
        TextView bookTitleName;

        public AudioSearchHolder(@NonNull View itemView) {
            super(itemView);

            booksImage = itemView.findViewById(R.id.audioProfileimgID);
            bookTitleName = itemView.findViewById(R.id.audioTitleID);
        }
    }
}
