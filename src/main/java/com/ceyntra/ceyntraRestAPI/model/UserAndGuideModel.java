package com.ceyntra.ceyntraRestAPI.model;

import com.ceyntra.ceyntraRestAPI.entity.GuideEntity;

public class UserAndGuideModel {
    private GuideEntity guide;
    private UserContactModel contact;

    public UserAndGuideModel() {
    }

    public UserAndGuideModel(GuideEntity guide, UserContactModel contact) {
        this.guide = guide;
        this.contact = contact;
    }

    public GuideEntity getGuide() {
        return guide;
    }

    public void setGuide(GuideEntity guide) {
        this.guide = guide;
    }

    public UserContactModel getContact() {
        return contact;
    }

    public void setContact(UserContactModel contact) {
        this.contact = contact;
    }
}
