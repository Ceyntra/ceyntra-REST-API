package com.ceyntra.ceyntraRestAPI.model;

import com.ceyntra.ceyntraRestAPI.entity.TaxiDriverEntity;

public class UserAndTaxiModel {
    private TaxiDriverEntity taxiDriver;
    private UserContactModel contact;

    public UserAndTaxiModel() {
    }

    public UserAndTaxiModel(TaxiDriverEntity taxiDriver, UserContactModel contact) {
        this.taxiDriver = taxiDriver;
        this.contact = contact;
    }

    public TaxiDriverEntity getTaxiDriver() {
        return taxiDriver;
    }

    public void setTaxiDriver(TaxiDriverEntity taxiDriver) {
        this.taxiDriver = taxiDriver;
    }

    public UserContactModel getContact() {
        return contact;
    }

    public void setContact(UserContactModel contact) {
        this.contact = contact;
    }
}
