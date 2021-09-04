package com.example.apustruv.AdapterClass;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.apustruv.Fragment.Followerspage;
import com.example.apustruv.Fragment.PostFollowingpage;
import com.example.apustruv.Fragment.Postpage;

public class Account_page_adapter extends FragmentPagerAdapter {


    int tabcounts;


    public Account_page_adapter(FragmentManager fragmentManager, int tabCount) {
        super(fragmentManager, tabCount);
        this.tabcounts = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Postpage();
            case 1:
                return new Followerspage();
            case 2:
                return new PostFollowingpage();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcounts;
    }

}