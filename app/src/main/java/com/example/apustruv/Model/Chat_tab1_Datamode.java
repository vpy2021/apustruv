package com.example.apustruv.Model;

import android.media.Image;
import android.widget.TextView;

import com.android.volley.toolbox.StringRequest;

public class Chat_tab1_Datamode {

  private String green_imageonline,image_profile,image_countbackground;
  private String chat_head,chat_desc,chat_time;

    public String getGreen_imageonline() {
        return green_imageonline;
    }

    public void setGreen_imageonline(String green_imageonline) {
        this.green_imageonline = green_imageonline;
    }

    public String getImage_profile() {
        return image_profile;
    }

    public void setImage_profile(String image_profile) {
        this.image_profile = image_profile;
    }

    public String getImage_countbackground() {
        return image_countbackground;
    }

    public void setImage_countbackground(String image_countbackground) {
        this.image_countbackground = image_countbackground;
    }

    public String getChat_head() {
        return chat_head;
    }

    public void setChat_head(String chat_head) {
        this.chat_head = chat_head;
    }

    public String getChat_desc() {
        return chat_desc;
    }

    public void setChat_desc(String chat_desc) {
        this.chat_desc = chat_desc;
    }

    public String getChat_time() {
        return chat_time;
    }

    public void setChat_time(String chat_time) {
        this.chat_time = chat_time;
    }

    Chat_tab1_Datamode(String Image2iew1, String Imageview2, String Imageview3, String Textview1, String Textview2, String Textview3 ){
   this.green_imageonline=green_imageonline;
   this.image_profile=image_profile;
   this.image_countbackground = image_countbackground;
   this.chat_head=chat_head;
   this.chat_desc=chat_desc;
   this.chat_time=chat_time;



 }

}
