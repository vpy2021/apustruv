package com.example.apustruv.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.apustruv.R;

public class WalkthroughActivity extends AppCompatActivity {

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