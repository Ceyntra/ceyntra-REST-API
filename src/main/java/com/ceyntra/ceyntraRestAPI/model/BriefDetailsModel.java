package com.ceyntra.ceyntraRestAPI.model;

public class BriefDetailsModel {
    private int id;
    private String name;
    private String district;
    private UserContactModel userContactModel;

    public BriefDetailsModel() {
    }

    public BriefDetailsModel(int id, String name, String district, UserContactModel userContactModel) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.userContactModel = userContactModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public UserContactModel getUserContactModel() {
        return userContactModel;
    }

    public void setUserContactModel(UserContactModel userContactModel) {
        this.userContactModel = userContactModel;
    }
}
