package com.ceyntra.ceyntraRestAPI.model;

public class AllSPModel {
    private UserAndHotelModel userAndHotelModel;
    private UserAndTaxiModel userAndTaxiModel;
    private UserAndGuideModel userAndGuideModel;

    public AllSPModel() {
    }

    public AllSPModel(UserAndHotelModel userAndHotelModel) {
        this.userAndHotelModel = userAndHotelModel;
    }

    public AllSPModel(UserAndTaxiModel userAndTaxiModel) {
        this.userAndTaxiModel = userAndTaxiModel;
    }

    public AllSPModel(UserAndGuideModel userAndGuideModel) {
        this.userAndGuideModel = userAndGuideModel;
    }

    public AllSPModel(UserAndHotelModel userAndHotelModel, UserAndTaxiModel userAndTaxiModel, UserAndGuideModel userAndGuideModel) {
        this.userAndHotelModel = userAndHotelModel;
        this.userAndTaxiModel = userAndTaxiModel;
        this.userAndGuideModel = userAndGuideModel;
    }

    public UserAndHotelModel getUserAndHotelModel() {
        return userAndHotelModel;
    }

    public void setUserAndHotelModel(UserAndHotelModel userAndHotelModel) {
        this.userAndHotelModel = userAndHotelModel;
    }

    public UserAndTaxiModel getUserAndTaxiModel() {
        return userAndTaxiModel;
    }

    public void setUserAndTaxiModel(UserAndTaxiModel userAndTaxiModel) {
        this.userAndTaxiModel = userAndTaxiModel;
    }

    public UserAndGuideModel getUserAndGuideModel() {
        return userAndGuideModel;
    }

    public void setUserAndGuideModel(UserAndGuideModel userAndGuideModel) {
        this.userAndGuideModel = userAndGuideModel;
    }
}
