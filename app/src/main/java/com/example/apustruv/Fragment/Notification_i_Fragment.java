package com.example.apustruv.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apustruv.AdapterClass.My_adapter;
import com.example.apustruv.Model.DataModel;
import com.example.apustruv.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Notification_i_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Notification_i_Fragment extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageView i_mage;
    TextView D_esc,H_ead,T_ime;


    RecyclerView recyclerView;
    ArrayList<DataModel> dataholder= new ArrayList<>();
    LinearLayoutManager layoutManager;
    BottomNavigationView bottomNavigationView;

    public Notification_i_Fragment() {

        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static Notification_i_Fragment newInstance(String param1, String param2) {
        Notification_i_Fragment fragment = new Notification_i_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification_i, container, false);

        recyclerView = view.findViewById(R.id.R_i);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

          DataModel ob1 = new DataModel(R.drawable.girlpic, "Marketing", "when you first log in to the system", "16:24");
          dataholder.add(ob1);

         DataModel ob2 = new DataModel(R.drawable.girlpic, "Marketing", "when you first log in to the system", "16:24");
       dataholder.add(ob1);

           DataModel ob3 = new DataModel(R.drawable.girlpic, "Marketing", "when you first log in to the system", "16:24");
            dataholder.add(ob1);

           DataModel ob4 = new DataModel(R.drawable.girlpic, "Marketing", "when you first log in to the system", "16:24");
          dataholder.add(ob1);

           DataModel ob5 = new DataModel(R.drawable.girlpic, "Marketing", "when you first log in to the system", "16:24");
            dataholder.add(ob5);

          DataModel ob6 = new DataModel(R.drawable.girlpic, "Marketing", "when you first log in to the system", "16:24");
           dataholder.add(ob6);

           DataModel ob7 = new DataModel(R.drawable.girlpic, "Marketing", "when you first log in to the system", "16:24");
           dataholder.add(ob7);

           DataModel ob8 = new DataModel(R.drawable.girlpic, "Marketing", "when you first log in to the system", "16:24");
          dataholder.add(ob8);

            DataModel ob9 = new DataModel(R.drawable.girlpic, "Marketing", "when you first log in to the system", "16:24");
           dataholder.add(ob8);

            recyclerView.setAdapter(new My_adapter(dataholder));

            return view;

        }
    }


