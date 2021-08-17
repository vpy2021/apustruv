package com.example.apustruv.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.apustruv.Fragment.Account_i_Fragment;
import com.example.apustruv.Fragment.HomeFragment;
import com.example.apustruv.Fragment.Notification_i_Fragment;
import com.example.apustruv.Fragment.SearchFragment;
import com.example.apustruv.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView btnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.bottomnavigation, new HomeFragment()).commit();
        btnv = (com.google.android.material.bottomnavigation.BottomNavigationView) findViewById(R.id.Navigation);
        btnv.setSelectedItemId(R.id.home);
        btnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch(item.getItemId()) {

                    case R.id.home:
                        fragment = new HomeFragment();

                        break;
                    case R.id.search:
                        fragment = new SearchFragment();

                        break;
                    case R.id.notify:
                        fragment = new Notification_i_Fragment();
                        break;
                    case R.id.account:
                        fragment = new Account_i_Fragment();

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.bottomnavigation, fragment).commit();
                return true;
            }
        });
    }


}