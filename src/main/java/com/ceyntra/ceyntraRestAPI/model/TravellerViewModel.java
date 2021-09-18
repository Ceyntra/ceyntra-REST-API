package com.ceyntra.ceyntraRestAPI.model;

import com.ceyntra.ceyntraRestAPI.entity.TravellerEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;

//For admin dashboard
public class TravellerViewModel {

    private UserEntity user;
    private TravellerEntity traveller;

    public TravellerViewModel() {
    }

    public TravellerViewModel(UserEntity user, TravellerEntity traveller) {
        this.user = user;
        this.traveller = traveller;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public TravellerEntity getTraveller() {
        return traveller;
    }

    public void setTraveller(TravellerEntity traveller) {
        this.traveller = traveller;
    }



}
