package com.example.apustruv.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apustruv.R;

public class Account_setting2Activity extends AppCompatActivity {

    ImageView drag;
    LinearLayout linearLayout, linearLayout1;
    TextView accountSetting,privacyPolicy;
   // CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_account_i);

//        drag = (ImageView) findViewById(R.id.dragID);
//
        linearLayout = (LinearLayout) findViewById(R.id.dragDownLayoutID);
        accountSetting = findViewById(R.id.AccountVisitID);

        accountSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account_setting2Activity.this, AccountSettingActivity.class);
                startActivity(intent);
            }
        });


        drag.setOnClickListener(v -> {
            if (linearLayout.getVisibility() == View.GONE) {
                linearLayout.setVisibility(View.VISIBLE);

            } else {
                linearLayout.setVisibility(View.GONE);
            }
        });
    }
}