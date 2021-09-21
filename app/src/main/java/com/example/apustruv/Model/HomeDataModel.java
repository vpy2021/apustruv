package com.example.apustruv.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeDataModel {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("post_type")
    @Expose
    private String postType;
    @SerializedName("post_url")
    @Expose
    private String postUrl;
    @SerializedName("post_option")
    @Expose
    private String postOption;
    @SerializedName("totalNotes")
    @Expose
    private Integer totalNotes;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getPostOption() {
        return postOption;
    }

    public void setPostOption(String postOption) {
        this.postOption = postOption;
    }

    public Integer getTotalNotes() {
        return totalNotes;
    }

    public void setTotalNotes(Integer totalNotes) {
        this.totalNotes = totalNotes;
    }

}
