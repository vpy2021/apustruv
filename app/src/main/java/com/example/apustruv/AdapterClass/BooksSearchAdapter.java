package com.example.apustruv.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.Model.BooksSearchModel;
import com.example.apustruv.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BooksSearchAdapter extends RecyclerView.Adapter<BooksSearchAdapter.BooksViewHolder> {

    Context context;
    List<BooksSearchModel> booksList = new ArrayList<>();

    public BooksSearchAdapter(Context context, List<BooksSearchModel> booksList){
        this.context = context;
        this.booksList = booksList;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_books_search,parent,false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {

        holder.bookTitleName.setText(booksList.get(position).getBookTitleName());
        Picasso.get().load(booksList.get(position).getBookImage()).into(holder.booksImage);

    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

    public class BooksViewHolder extends RecyclerView.ViewHolder{
        ImageView booksImage;
        TextView bookTitleName;

        public BooksViewHolder(@NonNull View itemView) {
            super(itemView);

            booksImage = itemView.findViewById(R.id.booksProfileimgID);
            bookTitleName = itemView.findViewById(R.id.booksTitleID);
        }
    }
}
