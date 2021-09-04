package com.example.apustruv.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.apustruv.AdapterClass.Chat_tab1_Page_adapter;
import com.example.apustruv.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Chat_screen extends AppCompatActivity {

    TabLayout tablayout;
    TabItem tabitem1, tabitem2;
    ViewPager viewPager;
    Chat_tab1_Page_adapter page_adapter;
    ImageView backIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);

        tablayout = findViewById(R.id.tablayout_ID);
        tabitem1 = findViewById(R.id.tab_individualitemID);
        tabitem2 = findViewById(R.id.tab_groupitemID);
        viewPager = findViewById(R.id.view_pagerID);
        backIcon = findViewById(R.id.backIcon);

        page_adapter = new Chat_tab1_Page_adapter(getSupportFragmentManager(), tablayout.getTabCount());
        viewPager.setAdapter(page_adapter);


        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (
                        tab.getPosition() == 0 || tab.getPosition() == 1)
                    page_adapter.notifyDataSetChanged();


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        //listen for scroll or page change

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}