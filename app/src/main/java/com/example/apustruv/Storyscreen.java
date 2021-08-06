package com.example.apustruv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Storyscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*hideToolbar();*/
        setContentView(R.layout.activity_storyscreen);
    }
/*    void hideToolbar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }*/
}