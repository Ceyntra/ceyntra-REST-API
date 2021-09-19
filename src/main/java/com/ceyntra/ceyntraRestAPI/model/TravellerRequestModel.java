package com.ceyntra.ceyntraRestAPI.model;

import java.sql.Timestamp;

public class TravellerRequestModel {

    private int packageId;
    private int spId;
    private int travellerId;
    private String packageName;
    private Timestamp timestamp;
    private String packageType;

    public TravellerRequestModel() {
    }

    public TravellerRequestModel(int packageId, int spId, int travellerId, String packageName, Timestamp timestamp, String packageType) {
        this.packageId = packageId;
        this.spId = spId;
        this.travellerId = travellerId;
        this.packageName = packageName;
        this.timestamp = timestamp;
        this.packageType = packageType;
    }

    @Override
    public String toString() {
        return "TravellerRequestModel{" +
                "packageId=" + packageId +
                ", spId=" + spId +
                ", travellerId=" + travellerId +
                ", packageName='" + packageName + '\'' +
                ", timestamp=" + timestamp +
                ", packageType='" + packageType + '\'' +
                '}';
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public int getSpId() {
        return spId;
    }

    public void setSpId(int spId) {
        this.spId = spId;
    }

    public int getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(int travellerId) {
        this.travellerId = travellerId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
