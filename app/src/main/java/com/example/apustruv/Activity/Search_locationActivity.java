package com.example.apustruv.Activity;

import static com.example.apustruv.R.id.homeTimeLineID;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.apustruv.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Search_locationActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_location);
        searchView = (SearchView) findViewById(R.id.sv_fruit_searchview);
        searchView.setIconified(false);
        listView = (ListView) findViewById(R.id.lv_listview);
     //   bottomNavigationView = findViewById(R.id.bottomNavID);

        list = new ArrayList<>();
        list.add("India");
        list.add("Australia");
        list.add("Dubai");
        list.add("USA");
        list.add("Europe");
        list.add("Russia");
        list.add("Mizoram");
        list.add("Canada");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);



//        bottomNavigationView.setSelectedItemId(R.id.searchMenuID);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case homeTimeLineID:
//                        startActivity(new Intent(getApplicationContext(), HomeTimeline.class));
//                        overridePendingTransition(0, 0);
//                        return true;
//
//                    case R.id.searchMenuID:
//                        return true;
//                    case R.id.not_i:
//                        startActivity(new Intent(getApplicationContext(), Notification_i.class));
//                        overridePendingTransition(0, 0);
//                        return true;
//
//                    case R.id.accountSettingID:
//                        startActivity(new Intent(getApplicationContext(), Account_setting2.class));
//                        overridePendingTransition(0, 0);
//                        return true;
//                }
//                return false;
//            }
//        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (list.contains(newText)){
                    adapter.getFilter().filter(newText);

                }else{

                }
                return false;
            }
        });
    }
}