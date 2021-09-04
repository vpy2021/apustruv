package com.example.apustruv.Model;

import android.widget.ImageView;

public class Postmadalmodel {
    
    private int id ;
    private  String  userreaction;
    private String emojireaction;

    public Postmadalmodel(int i, ImageView emojireaction) {
    }

    public String getUserreaction() {
        return userreaction;
    }

    public void setUserreaction(String userreaction) {
        this.userreaction = userreaction;
    }

    public String getEmojireaction() {
        return emojireaction;
    }

    public void setEmojireaction(String emojireaction) {
        this.emojireaction = emojireaction;
    }

    public Postmadalmodel() {

    }

    public Postmadalmodel(String userreaction, String emojireaction){
        this.userreaction = userreaction;
        this.emojireaction = emojireaction;
        
    }
}
