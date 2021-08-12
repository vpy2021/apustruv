package com.example.apustruv;

import static com.example.apustruv.R.id.homefrag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavbar extends AppCompatActivity {

    BottomNavigationView btnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.bottomnavigation, new Home()).commit();





        btnv = (com.google.android.material.bottomnavigation.BottomNavigationView) findViewById(R.id.Navigation);

        btnv.setSelectedItemId(R.id.home);
        btnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp = null;

                Log.i("Tag_for_testing", item.getItemId()+"");
                switch(item.getItemId()) {

                    case R.id.home:
                        temp = new Home();

                        break;
                    case R.id.search:
                        temp = new Search();

                        break;
                    case R.id.notify:
                        temp = new Notification_i();
                        break;
                    case R.id.account:
                        temp = new Account_i();

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.bottomnavigation, temp).commit();
                return true;
            }
        });
    }


}