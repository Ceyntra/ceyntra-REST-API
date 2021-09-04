package com.ceyntra.ceyntraRestAPI.model;

public class UserContactModel {
    private String email;
    private String telephone;

    public UserContactModel() {
    }

    public UserContactModel(String email, String telephone) {
        this.email = email;
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
