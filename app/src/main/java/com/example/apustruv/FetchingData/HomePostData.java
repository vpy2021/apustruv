package com.example.apustruv.FetchingData;

public class HomePostData {

    private String profilePhoto;
    private String profileName;
    private String likeIncrement;
    private String imagePost;

    public HomePostData(){

    }

    public HomePostData(String profilePhoto, String profileName, String likeIncrement, String imagePost) {
        this.profilePhoto = profilePhoto;
        this.profileName = profileName;
        this.likeIncrement = likeIncrement;
        this.imagePost = imagePost;
    }


    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getLikeIncrement() {
        return likeIncrement;
    }

    public void setLikeIncrement(String likeIncrement) {
        this.likeIncrement = likeIncrement;
    }

    public String getImagePost() {
        return imagePost;
    }

    public void setImagePost(String imagePost) {
        this.imagePost = imagePost;
    }
}
