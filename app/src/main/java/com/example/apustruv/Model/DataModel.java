package com.example.apustruv.Model;

import android.view.View;

import com.example.apustruv.AdapterClass.My_adapter;

public class DataModel {
    private static View Datamodel;
    int i_mage;
    String D_esc, H_ead, T_ime;

    public DataModel(int i_mage, String D_esc, String H_ead, String T_ime) {

        this.i_mage = i_mage;
        this.D_esc = D_esc;
        this.H_ead = H_ead;
        this.T_ime = T_ime;

    }

    public static void OnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Datamodel.setOnLongClickListener(My_adapter.onLongClickListenr);



    }

    public int getI_mage() {
        return i_mage;
    }

    public String getD_esc() {
        return D_esc;
    }

    public String getH_ead() {
        return H_ead;
    }

    public String getT_ime() {
        return T_ime;
    }
}
