package com.example.apustruv.Model;

import android.widget.ImageView;
import android.widget.TextView;

public class Reaction_postdatamodel {
    
    private int id;
    private String menlogo;
    private String profilenamemen;
    private String maindraftlogo;
    private String likeincreament;
    private String notes;

    public Reaction_postdatamodel(int i, ImageView menlogo) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenlogo() {
        return menlogo;
    }

    public void setMenlogo(String menlogo) {
        this.menlogo = menlogo;
    }

    public String getProfilenamemen() {
        return profilenamemen;
    }

    public void setProfilenamemen(String profilenamemen) {
        this.profilenamemen = profilenamemen;
    }

    public String getMaindraftlogo() {
        return maindraftlogo;
    }

    public void setMaindraftlogo(String maindraftlogo) {
        this.maindraftlogo = maindraftlogo;
    }

    public String getLikeincreament() {
        return likeincreament;
    }

    public void setLikeincreament(String likeincreament) {
        this.likeincreament = likeincreament;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Reaction_postdatamodel(int i, String menlogo, String  maindraftlogo , String profilenamemen, String likeincreament, String notes){
        
    }
}
