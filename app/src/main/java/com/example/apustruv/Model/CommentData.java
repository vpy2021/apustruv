package com.example.apustruv.Model;

public class CommentData {
    private String profileImage;
    private String profileName;
    private String commentMessage;

    public CommentData(){

    }
    CommentData(String profileImage, String profileName, String commentMessage){
        this.profileImage = profileImage;
        this.profileName = profileName;
        this.commentMessage = commentMessage;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }


}
