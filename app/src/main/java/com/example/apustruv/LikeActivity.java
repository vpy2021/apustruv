package com.example.apustruv;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.opengl.Visibility;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LikeActivity extends AppCompatActivity implements View.OnClickListener {
    static int maxValue = 5;
    CardView cardView1, cardView2, cardView3, cardView4, cardView5, cardView6, cardView7, cardView8, cardView9;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9;
    Button button;
    TextView textView;

    List<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideToolbar();
        setContentView(R.layout.activity_like);
        init();
    }

    void init() {

        imageView1 = (ImageView) findViewById(R.id.tick1);
        imageView2 = (ImageView) findViewById(R.id.tick2);
        imageView3 = (ImageView) findViewById(R.id.tick3);
        imageView4 = (ImageView) findViewById(R.id.tick4);
        imageView5 = (ImageView) findViewById(R.id.tick5);
        imageView6 = (ImageView) findViewById(R.id.tick6);
        imageView7 = (ImageView) findViewById(R.id.tick7);
        imageView8 = (ImageView) findViewById(R.id.tick8);
        imageView9 = (ImageView) findViewById(R.id.tick9);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView6.setOnClickListener(this);
        imageView7.setOnClickListener(this);
        imageView8.setOnClickListener(this);
        imageView9.setOnClickListener(this);

        cardView1 = (CardView) findViewById(R.id.card1);
        cardView2 = (CardView) findViewById(R.id.card2);
        cardView3 = (CardView) findViewById(R.id.card3);
        cardView4 = (CardView) findViewById(R.id.card4);
        cardView5 = (CardView) findViewById(R.id.card5);
        cardView6 = (CardView) findViewById(R.id.card6);
        cardView7 = (CardView) findViewById(R.id.card7);
        cardView8 = (CardView) findViewById(R.id.card8);
        cardView9 = (CardView) findViewById(R.id.card9);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);
        cardView5.setOnClickListener(this);
        cardView6.setOnClickListener(this);
        cardView7.setOnClickListener(this);
        cardView8.setOnClickListener(this);
        cardView9.setOnClickListener(this);

        button = (Button) findViewById(R.id.nextslide);
        textView = (TextView) findViewById(R.id.picktext);
        textView.setText("5");
    }

    void hideToolbar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card1:
                checkValueInList("Trending", v);
                break;
            case R.id.card2:
                checkValueInList("Art", v);

                break;
            case R.id.card3:
                checkValueInList("Writing", v);

                break;
            case R.id.card4:
                checkValueInList("Television", v);

                break;
            case R.id.card5:
                checkValueInList("Aesthetic", v);

                break;
            case R.id.card6:
                checkValueInList("Positivity", v);

                break;
            case R.id.card7:
                checkValueInList("Movies", v);

                break;
            case R.id.card8:
                checkValueInList("Gaming", v);

                break;
            case R.id.card9:
                checkValueInList("Funny", v);
                break;
        }
    }

    void checkValueInList(String value, View v) {

        if (arrayList.size() < 5) {
            if (arrayList.contains(value)) {
                Toast.makeText(this, "Value already Available in List", Toast.LENGTH_SHORT).show();
            } else {
                arrayList.add(value);
                maxValue--;
                textView.setText(String.valueOf(maxValue));
                Log.e("TAG", "checkValueInList: " + arrayList.toString());

                if (v.getId() == R.id.card1) {
                    imageView1.setVisibility(View.VISIBLE);
                }
                else if (v.getId() == R.id.card2){
                    imageView2.setVisibility(View.VISIBLE);

                }
                else if(v.getId() == R.id.card3){
                    imageView3.setVisibility(View.VISIBLE);
                }
                else if(v.getId() == R.id.card4){
                    imageView4.setVisibility(View.VISIBLE);

                }
                else if(v.getId() == R.id.card5){
                    imageView5.setVisibility(View.VISIBLE);

                }
                else if(v.getId() == R.id.card6){
                    imageView6.setVisibility(View.VISIBLE);

                }
                else if(v.getId() == R.id.card7){
                    imageView7.setVisibility(View.VISIBLE);
                }
                else if(v.getId() == R.id.card8){
                    imageView8.setVisibility(View.VISIBLE);
                }
                else if(v.getId() == R.id.card9){
                    imageView9.setVisibility(View.VISIBLE);
                }

                else{

                }
            }
        } else {
            Toast.makeText(this, "You cant selct more than 5 elements", Toast.LENGTH_SHORT).show();
        }

    }
}