package com.example.apustruv.Model;

public class MemberScreenData {

    private String memberProfileName;
    private String memberProfilePhoto;

    public MemberScreenData(){

    }

    MemberScreenData(String memberProfileName,String memberProfilePhoto){
        this.memberProfileName = memberProfileName;
        this.memberProfilePhoto = memberProfilePhoto;
    }

    public String getMemberProfileName() {
        return memberProfileName;
    }

    public void setMemberProfileName(String memberProfileName) {
        this.memberProfileName = memberProfileName;
    }

    public String getMemberProfilePhoto() {
        return memberProfilePhoto;
    }

    public void setMemberProfilePhoto(String memberProfilePhoto) {
        this.memberProfilePhoto = memberProfilePhoto;
    }



}
