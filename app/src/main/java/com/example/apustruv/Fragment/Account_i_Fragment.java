package com.example.apustruv.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apustruv.Activity.AccountSettingActivity;
import com.example.apustruv.R;

public class Account_i_Fragment extends Fragment {
    ImageView drag;
    LinearLayout linearLayout, linearLayout1;
    TextView accountVisit,privacyPolicy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_account_i, container, false);

        drag = (ImageView) view.findViewById(R.id.dragID);
        linearLayout = view.findViewById(R.id.dragDownLayoutID);
       // accountSetting = v.findViewById(R.id.AccountID);
        accountVisit = view.findViewById(R.id.AccountVisitID);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        accountVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AccountSettingActivity.class);
                startActivity(intent);

            }
        });

        drag.setOnClickListener(v -> {
            if (linearLayout.getVisibility() == View.GONE) {
                linearLayout.setVisibility(View.VISIBLE);

            } else {
                linearLayout.setVisibility(View.GONE);
            }
        });
    }
}