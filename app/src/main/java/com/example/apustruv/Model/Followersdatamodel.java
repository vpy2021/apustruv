package com.example.apustruv.Model;

public class Followersdatamodel {

    private int followimage;
    private String heading;
    private String description;
    private String checkedtv;

    public int getFollowimage() {
        return followimage;
    }

    public void setFollowimage(int followimage) {
        this.followimage = followimage;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCheckedtv() {
        return checkedtv;
    }

    public void setCheckedtv(String checkedtv) {
        this.checkedtv = checkedtv;
    }

    Followersdatamodel(int followimage, String heading, String description, String checkedtv) {

    }
}
