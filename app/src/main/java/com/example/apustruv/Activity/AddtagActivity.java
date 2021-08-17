package com.example.apustruv.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apustruv.AdapterClass.AddTagAdapter;
import com.example.apustruv.Model.Modelrecycle;
import com.example.apustruv.R;

import java.util.ArrayList;
import java.util.List;

public class AddtagActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Modelrecycle> taglist;
    AddTagAdapter adapter;

    ImageView imageView;

    ImageView img;
    TextView txt;
    TextView txt1;
    TextView btn;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtag);


        initData();
        initRecyclerview();
        imageView = findViewById(R.id.backbtn);

        imageView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    public void initData() {
        taglist = new ArrayList<>();
        taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
        taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
        taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
        taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
        taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
        taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
        taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
        taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
        taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
        taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
        taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
        taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
        taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
        taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));


    }

    private void initRecyclerview() {
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AddTagAdapter(taglist);
        recyclerView.setAdapter(adapter);
    }
}

