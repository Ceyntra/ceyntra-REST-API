package com.ceyntra.ceyntraRestAPI.model;

import com.ceyntra.ceyntraRestAPI.entity.PlaceReviewEntity;
import com.ceyntra.ceyntraRestAPI.entity.TravellerEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;

public class UserAndReviewModel {
    private PlaceReviewEntity placeReviewEntity;
    private TravellerEntity travellerEntity;

    public UserAndReviewModel(PlaceReviewEntity placeReviewEntity, TravellerEntity travellerEntity) {
        this.placeReviewEntity = placeReviewEntity;
        this.travellerEntity = travellerEntity;
    }

    public UserAndReviewModel() {
    }

    public PlaceReviewEntity getPlaceReviewEntity() {
        return placeReviewEntity;
    }

    public void setPlaceReviewEntity(PlaceReviewEntity placeReviewEntity) {
        this.placeReviewEntity = placeReviewEntity;
    }

    public TravellerEntity getTravellerEntity() {
        return travellerEntity;
    }

    public void setTravellerEntity(TravellerEntity travellerEntity) {
        this.travellerEntity = travellerEntity;
    }
}
