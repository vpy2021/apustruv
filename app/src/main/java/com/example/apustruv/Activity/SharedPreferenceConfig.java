package com.example.apustruv.Activity;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.apustruv.R;

public class SharedPreferenceConfig {
    String username, password,authToken,profileImage;

    public static final String Shered_Pref = "com.example.apustruv";

    public SharedPreferenceConfig(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(Shered_Pref, Context.MODE_PRIVATE);
        username=sharedPreferences.getString("username","");
        password=sharedPreferences.getString("password","");
        password=sharedPreferences.getString("auth_token","");
        profileImage = sharedPreferences.getString("profile_img","");


    }

    public void update(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Shered_Pref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.putString("auth_token", authToken);
        editor.putString("profile_img",profileImage);
        editor.apply();
    }

}
