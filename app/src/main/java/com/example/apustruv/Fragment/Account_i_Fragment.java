package com.example.apustruv.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apustruv.Activity.Account_setting2Activity;
import com.example.apustruv.AdapterClass.Account_page_adapter;
import com.example.apustruv.R;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Account_i_Fragment extends Fragment {

    TabLayout tabLayouts;
    TabItem tabItem1, tabItem2, tabItem3;
    ViewPager viewPager;
    Account_page_adapter page_adapter;
    ImageView image;
    ImageView backgroundprofile, profileimage;
    TextView profilename, surname, About;

    String url = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account_i, container, false);

        tabLayouts = view.findViewById(R.id.tab_layout);
        tabItem1 = view.findViewById(R.id.posttab);
        tabItem2 = view.findViewById(R.id.followerstab);
        tabItem3 = view.findViewById(R.id.followingtab);
        viewPager = view.findViewById(R.id.view_pager);
        image = view.findViewById(R.id.accountseting12ID);
        backgroundprofile = view.findViewById(R.id.imagebackgroundprofileID);
        profileimage = view.findViewById(R.id.bckgrnd_topprofileimageID);
        profilename = view.findViewById(R.id.top_profilefirstnameID);
        surname = view.findViewById(R.id.surnameID);
        About = view.findViewById(R.id.AboutyourselfID);


        page_adapter = new Account_page_adapter(requireActivity().getSupportFragmentManager(), tabLayouts.getTabCount());
        viewPager.setAdapter(page_adapter);


        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        tabLayouts.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

               if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2)
                   page_adapter.notifyDataSetChanged();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayouts));


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Account_setting2Activity.class);
                startActivity(intent);
            }
        });




    }
}