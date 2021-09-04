package com.ceyntra.ceyntraRestAPI.model;

import com.ceyntra.ceyntraRestAPI.entity.TravellerEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;

public class UserAndTravellerModel {
    private TravellerEntity traveller;
    private UserContactModel user;


    public UserAndTravellerModel() {
    }

    public UserAndTravellerModel(TravellerEntity traveller, UserContactModel user) {
        this.traveller = traveller;
        this.user = user;
    }

    public TravellerEntity getTraveller() {
        return traveller;
    }

    public void setTraveller(TravellerEntity traveller) {
        this.traveller = traveller;
    }

    public UserContactModel getUser() {
        return user;
    }

    public void setUser(UserContactModel user) {
        this.user = user;
    }
}
