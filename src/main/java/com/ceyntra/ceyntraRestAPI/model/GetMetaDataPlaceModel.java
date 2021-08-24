package com.ceyntra.ceyntraRestAPI.model;

import com.ceyntra.ceyntraRestAPI.entity.PlaceReviewEntity;

import java.util.List;

public class GetMetaDataPlaceModel {
    boolean isFavourite;
    private List<UserAndReviewModel> list;

    public GetMetaDataPlaceModel(boolean isFavourite, List<UserAndReviewModel> list) {
        this.isFavourite = isFavourite;
        this.list = list;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public List<UserAndReviewModel> getList() {
        return list;
    }
}
