package com.example.apustruv.AdapterClass;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.apustruv.Fragment.Chat_Tab1;
import com.example.apustruv.Fragment.Chat_Tab2;

public class Chat_tab1_Page_adapter extends FragmentPagerAdapter {

    int tabcount;

    public Chat_tab1_Page_adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){

            case 0 :return new Chat_Tab1();
            case 1 :return new Chat_Tab2();
            default:return null;

        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
