package com.ceyntra.ceyntraRestAPI.model;

public class ProfilePhotoUpdateModel {
    private String photo;
    private int userID;

    public ProfilePhotoUpdateModel() {
    }

    public ProfilePhotoUpdateModel(String photo, int userID) {
        this.photo = photo;
        this.userID = userID;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
