package com.example.apustruv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Walkthrough extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);
        imageView= findViewById(R.id.backbtn);

        imageView.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}