package com.ceyntra.ceyntraRestAPI.model;

import com.ceyntra.ceyntraRestAPI.entity.PlaceReviewEntity;

import java.util.List;

public class GetMetaDataPlaceModel {
    private boolean isFavourite;
    private double myRating;
    private List<UserAndReviewModel> list;

    public GetMetaDataPlaceModel(boolean isFavourite, double myRating, List<UserAndReviewModel> list) {
        this.isFavourite = isFavourite;
        this.myRating = myRating;
        this.list = list;
    }

    public double getMyRating() {
        return myRating;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public List<UserAndReviewModel> getList() {
        return list;
    }
}
