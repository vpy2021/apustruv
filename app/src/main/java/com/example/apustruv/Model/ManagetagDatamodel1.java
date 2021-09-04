package com.example.apustruv.Model;

import android.media.Image;

public class ManagetagDatamodel1 {

    private int id;
    private String image1;
    private String text1;
    private String text2;
    private String image2;
    private String image3;

    public ManagetagDatamodel1() {

    }

    public ManagetagDatamodel1(String image1, String text1, String text2, String image2, String image3) {

        this.image1 = image1;
        this.text1 = text1;
        this.text2 = text2;
        this.image2 = image2;
        this.image3 = image3;


    }

    public ManagetagDatamodel1(int addtaglogo, String text1, String text2, int image_plusID, int image_checkID) {
    }

    public ManagetagDatamodel1(int image_plusID) {
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }
}
