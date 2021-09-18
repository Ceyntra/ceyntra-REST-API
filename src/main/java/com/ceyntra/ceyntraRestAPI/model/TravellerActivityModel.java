package com.ceyntra.ceyntraRestAPI.model;

import java.sql.Timestamp;

public class TravellerActivityModel {

    private int packageID;
    private String packageType;
    private String date;
    private String time;
    private String spName;

    public TravellerActivityModel() {
    }

    public TravellerActivityModel(int packageID, String packageType, String date, String time, String spName) {
        this.packageID = packageID;
        this.packageType = packageType;
        this.date = date;
        this.time = time;
        this.spName = spName;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }
}
