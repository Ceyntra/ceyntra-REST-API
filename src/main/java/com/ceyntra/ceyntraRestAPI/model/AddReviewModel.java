package com.ceyntra.ceyntraRestAPI.model;

public class AddReviewModel {
    private String comment;
    private double rating;
    private int placeId;
    private int userId;

    public AddReviewModel() {
    }

    public AddReviewModel(String comment, double rating, int placeId, int userId) {
        this.comment = comment;
        this.rating = rating;
        this.placeId = placeId;
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
