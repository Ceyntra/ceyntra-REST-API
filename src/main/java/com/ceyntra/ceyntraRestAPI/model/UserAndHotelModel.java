package com.ceyntra.ceyntraRestAPI.model;

import com.ceyntra.ceyntraRestAPI.entity.HotelEntity;

public class UserAndHotelModel {
    private HotelEntity hotel;
    private UserContactModel contact;

    public UserAndHotelModel() {
    }

    public UserAndHotelModel(HotelEntity hotel, UserContactModel contact) {
        this.hotel = hotel;
        this.contact = contact;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    public UserContactModel getContact() {
        return contact;
    }

    public void setContact(UserContactModel contact) {
        this.contact = contact;
    }
}
