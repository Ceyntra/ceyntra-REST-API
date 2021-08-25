package com.ceyntra.ceyntraRestAPI.model;

public class FavouritePlaceUpdateModel {

    private boolean favouriteStatus;
    private int userId;
    private int placeId;

    public FavouritePlaceUpdateModel(boolean favouriteStatus, int userId, int placeId) {
        this.favouriteStatus = favouriteStatus;
        this.userId = userId;
        this.placeId = placeId;
    }

    public FavouritePlaceUpdateModel() {
    }

    public boolean isFavouriteStatus() {
        return favouriteStatus;
    }

    public void setFavouriteStatus(boolean favouriteStatus) {
        this.favouriteStatus = favouriteStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }
}
