package com.ceyntra.ceyntraRestAPI.model;

import com.ceyntra.ceyntraRestAPI.entity.PlaceReviewEntity;

import java.util.List;

public class GetMetaDataPlaceModel {
    private boolean isFavourite;
    private double myRating;
    private List<UserAndReviewModel> list;
    private int numOfVotesForPlace;
    private double placeRating;
    private List<String> photoList;

    public GetMetaDataPlaceModel(boolean isFavourite, double myRating, List<UserAndReviewModel> list, int numOfVotesForPlace, double placeRating, List<String> photoList) {
        this.isFavourite = isFavourite;
        this.myRating = myRating;
        this.list = list;
        this.numOfVotesForPlace = numOfVotesForPlace;
        this.placeRating = placeRating;
        this.photoList = photoList;
    }

    public GetMetaDataPlaceModel(boolean isFavourite, double myRating, List<UserAndReviewModel> list, int numOfVotesForPlace, double placeRating) {
        this.isFavourite = isFavourite;
        this.myRating = myRating;
        this.list = list;
        this.numOfVotesForPlace = numOfVotesForPlace;
        this.placeRating = placeRating;
    }

    public List<String> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<String> photoList) {
        this.photoList = photoList;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public double getMyRating() {
        return myRating;
    }

    public void setMyRating(double myRating) {
        this.myRating = myRating;
    }

    public List<UserAndReviewModel> getList() {
        return list;
    }

    public void setList(List<UserAndReviewModel> list) {
        this.list = list;
    }

    public int getNumOfVotesForPlace() {
        return numOfVotesForPlace;
    }

    public void setNumOfVotesForPlace(int numOfVotesForPlace) {
        this.numOfVotesForPlace = numOfVotesForPlace;
    }

    public double getPlaceRating() {
        return placeRating;
    }

    public void setPlaceRating(double placeRating) {
        this.placeRating = placeRating;
    }
}
