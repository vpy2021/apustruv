package com.example.apustruv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class Search_location extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_location);
        searchView = (SearchView) findViewById(R.id.sv_fruit_searchview);
        searchView.setIconified(false);
        listView = (ListView) findViewById(R.id.lv_listview);

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