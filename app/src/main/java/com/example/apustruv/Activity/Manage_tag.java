package com.example.apustruv.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apustruv.AdapterClass.Adapters;
import com.example.apustruv.AdapterClass.ManagetagMy_adapter1;
import com.example.apustruv.AdapterClass.Reaction_postadapter;
import com.example.apustruv.Model.ManagetagDatamodel1;
import com.example.apustruv.Model.Reaction_postdatamodel;
import com.example.apustruv.R;

import java.util.ArrayList;
import java.util.List;

public class Manage_tag extends AppCompatActivity {


    RecyclerView manageRecyler;
    List<ManagetagDatamodel1> lista = new ArrayList<>();
    ImageView imageview;
    TextView manageadd;
    RecyclerView recyclerView;
    ImageView check;
    CheckedTextView plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_tag);


        imageview = findViewById(R.id.backbtn);
//        imageview.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                onBackPressed();
//            }
//        });
//
        manageadd = findViewById(R.id.manage_addID);
        manageadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddtagActivity.class);
                startActivity(intent);
            }
        });


        plus = (CheckedTextView) findViewById(R.id.image_plusID);

        plus.setCheckMarkDrawable(R.drawable.plus);
        check = findViewById(R.id.image_checkID);



//    plus.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               if (check.getVisibility() == View.VISIBLE) {
//                    plus.setVisibility(View.GONE);
//               } else {
//                  check.setVisibility(View.GONE);
//               }
//         }
//      });


        manageRecyler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        manageRecyler.setAdapter(new ManagetagMy_adapter1(getApplicationContext(),lista));




        lista = new ArrayList<>();
        lista.add(new ManagetagDatamodel1(R.id.image_plusID));
            //taglist.add(new Modelrecycle(R.id.imagetag2, "#recipes", "100 posts", "Add"));
//        taglist.add(new Modelrecycle(R.id.imagetag2,"#recipes","100 posts","Add"));
//        taglist.add(new Modelrecycle(R.id.imagetag2,"#recipes","100 posts","Add"));
//        taglist.add(new Modelrecycle(R.id.imagetag2,"#recipes","100 posts","Add"));
//        taglist.add(new Modelrecycle(R.id.imagetag2,"#recipes","100 posts","Add"));
//

    }


}
