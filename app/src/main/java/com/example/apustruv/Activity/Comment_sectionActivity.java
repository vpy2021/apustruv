package com.example.apustruv.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.apustruv.R;

public class Comment_sectionActivity extends AppCompatActivity {
    ImageView commentIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_section_layout);

       commentIcon =  findViewById(R.id.commentIconID);
        @SuppressLint("ResourceType")
        LinearLayout linearLayout = findViewById(R.layout.activity_comment_section_layout);

        commentIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(linearLayout.getVisibility() == View.GONE){
                   linearLayout.setVisibility(View.VISIBLE);
               }
            }
        });

    }
}