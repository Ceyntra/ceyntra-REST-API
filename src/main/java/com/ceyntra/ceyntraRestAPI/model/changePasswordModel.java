package com.ceyntra.ceyntraRestAPI.model;

public class changePasswordModel {
    private int userID;
    private String currentPassword;
    private String newPassword;

    public changePasswordModel() {
    }

    public changePasswordModel(int userID, String currentPassword, String newPassword) {
        this.userID = userID;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
