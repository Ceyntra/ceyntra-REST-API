package com.ceyntra.ceyntraRestAPI.model;

import com.ceyntra.ceyntraRestAPI.entity.*;

public class UserAndReviewModel {
    private PlaceReviewEntity placeReviewEntity;
    private SpReviewEntity spReviewEntity;
    private TravellerEntity travellerEntity;
    private double rating;



    public UserAndReviewModel(PlaceReviewEntity placeReviewEntity, TravellerEntity travellerEntity, double rating) {
        this.placeReviewEntity = placeReviewEntity;
        this.travellerEntity = travellerEntity;
        this.rating = rating;
    }

    public UserAndReviewModel( SpReviewEntity spReviewEntity, TravellerEntity travellerEntity, double rating) {
        this.spReviewEntity = spReviewEntity;
        this.travellerEntity = travellerEntity;
        this.rating = rating;

    }

    public UserAndReviewModel() {
    }

    public SpReviewEntity getSpReviewEntity() {
        return spReviewEntity;
    }

    public void setSpReviewEntity(SpReviewEntity spReviewEntity) {
        this.spReviewEntity = spReviewEntity;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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
