package com.example.apustruv.Model;

public class NotificationModel {


    String Desc, title, Time, imageUrl;

    public String getImage() {
        return imageUrl;
    }

    public String getDesc() {
        return Desc;
    }

    public String getHead() {
        return title;
    }


    public void setImage(String image) {
        this.imageUrl = image;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public void setHead(String head) {
        title = head;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getTime() {
        return Time;
    }
}
