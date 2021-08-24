package com.ceyntra.ceyntraRestAPI.model;

import com.ceyntra.ceyntraRestAPI.entity.PlaceReviewEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;

public class UserAndReviewModel {
    private PlaceReviewEntity placeReviewEntity;
    private UserEntity userEntity;


    public UserAndReviewModel() {
    }

    public UserAndReviewModel(PlaceReviewEntity placeReviewEntity, UserEntity userEntity) {
        this.placeReviewEntity = placeReviewEntity;
        this.userEntity = userEntity;
    }

    public PlaceReviewEntity getPlaceReviewEntity() {
        return placeReviewEntity;
    }

    public void setPlaceReviewEntity(PlaceReviewEntity placeReviewEntity) {
        this.placeReviewEntity = placeReviewEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
