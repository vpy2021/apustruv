package com.example.apustruv.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.Model.MoviesSearchModel;
import com.example.apustruv.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

public class MoviesSearchAdapter extends RecyclerView.Adapter<MoviesSearchAdapter.MovieViewHolder> {

    Context context;
    List<MoviesSearchModel> list;
    List<HashMap<String, String>> arrayList;

    public MoviesSearchAdapter(Context context, List<MoviesSearchModel> list, List<HashMap<String, String>> arrayList) {
        this.context = context;
        this.list = list;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_movies_seach_design, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        // HashMap<String, String> hashMap = arrayList.get(position);
        //    Picasso.get().load(list.get(position).getMoviesProfilePhoto()).into(holder.moviesProfilePhoto);
        // holder.moviesText.setText(hashMap.get("name"));


        holder.moviesText.setText(list.get(position).getMoviesTitleName());
        //holder.moviesProfilePhoto.setImageResource(R.drawable.download);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView moviesProfilePhoto;
        TextView moviesText;
        LinearLayout linearLayout;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            moviesProfilePhoto = itemView.findViewById(R.id.moviesProfileimgID);
            moviesText = itemView.findViewById(R.id.moviesTitleID);
            linearLayout = itemView.findViewById(R.id.moviesLayoutID);

        }
    }
}
