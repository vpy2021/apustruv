package com.example.apustruv.FetchingData;

public class HomeStatusData {

    private String homeProfileImage;
    private String homeStatusImage;

    public HomeStatusData(){

    }

    HomeStatusData(String homeProfileImage,String homeStatusImage){

        this.homeProfileImage = homeProfileImage;
        this.homeStatusImage = homeStatusImage;
    }

    public String getHomeProfileImage() {
        return homeProfileImage;
    }

    public void setHomeProfileImage(String homeProfileImage) {
        this.homeProfileImage = homeProfileImage;
    }

    public String getHomeStatusImage() {
        return homeStatusImage;
    }

    public void setHomeStatusImage(String homeStatusImage) {
        this.homeStatusImage = homeStatusImage;
    }
}
