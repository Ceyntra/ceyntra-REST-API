package com.ceyntra.ceyntraRestAPI.model;

public class HotelSignUpModel {

    private String hotelName;
    private String hotelDesc;
    private String registration;
    private String email;
    private double lat;
    private double lon;
    private String district;
    private String contactNumber;
    private String password;

    public HotelSignUpModel() {
    }

    public HotelSignUpModel(String hotelName, String hotelDesc, String registration, String email, double lat, double lon, String district, String contactNumber, String password) {
        this.hotelName = hotelName;
        this.hotelDesc = hotelDesc;
        this.registration = registration;
        this.email = email;
        this.lat = lat;
        this.lon = lon;
        this.district = district;
        this.contactNumber = contactNumber;
        this.password = password;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelDesc() {
        return hotelDesc;
    }

    public void setHotelDesc(String hotelDesc) {
        this.hotelDesc = hotelDesc;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
