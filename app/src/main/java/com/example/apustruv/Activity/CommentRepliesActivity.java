package com.example.apustruv.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.apustruv.AdapterClass.CommentAdapter;
import com.example.apustruv.Model.CommentData;
import com.example.apustruv.R;

import java.util.ArrayList;
import java.util.List;

public class CommentRepliesActivity extends AppCompatActivity {

    RecyclerView cmtRecycler;
    ImageView back;

    List<CommentData> commentData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_replies);

        cmtRecycler = findViewById(R.id.commentRecycerID);
        back = findViewById(R.id.backIcon);

        cmtRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        cmtRecycler.setAdapter(new CommentAdapter(getApplicationContext(), commentData));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}