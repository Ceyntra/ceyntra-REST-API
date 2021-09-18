package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.*;

@Entity
@Table(name="TaxiPackage")
public class TaxiPackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;

    private String packageName;

    private String packageDesc;
    private String imageURL;

    private boolean withDriver;
    private boolean fuel;
    private boolean fullDayService;
    private boolean ownRoutine;
    private boolean other;

    private String otherFacility;
    private int numberOfPassengers;

    private boolean perDay;
    private boolean perKm;

    private double price;
    private boolean negotiable;

    private int taxiDriverId;

    public TaxiPackageEntity(int packageId, String packageName, String packageDesc, String imageURL, boolean withDriver, boolean fuel, boolean fullDayService, boolean ownRoutine, boolean other, String otherFacility, int numberOfPassengers, boolean perDay, boolean perKm, double price, boolean negotiable, int taxiDriverId) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.packageDesc = packageDesc;
        this.imageURL = imageURL;
        this.withDriver = withDriver;
        this.fuel = fuel;
        this.fullDayService = fullDayService;
        this.ownRoutine = ownRoutine;
        this.other = other;
        this.otherFacility = otherFacility;
        this.numberOfPassengers = numberOfPassengers;
        this.perDay = perDay;
        this.perKm = perKm;
        this.price = price;
        this.negotiable = negotiable;
        this.taxiDriverId = taxiDriverId;
    }

    public TaxiPackageEntity() {

    }

    public int getTaxiDriverId() {
        return taxiDriverId;
    }

    public void setTaxiDriverId(int taxiDriverId) {
        this.taxiDriverId = taxiDriverId;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageDesc() {
        return packageDesc;
    }

    public void setPackageDesc(String packageDesc) {
        this.packageDesc = packageDesc;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isWithDriver() {
        return withDriver;
    }

    public void setWithDriver(boolean withDriver) {
        this.withDriver = withDriver;
    }

    public boolean isFuel() {
        return fuel;
    }

    public void setFuel(boolean fuel) {
        this.fuel = fuel;
    }

    public boolean isFullDayService() {
        return fullDayService;
    }

    public void setFullDayService(boolean fullDayService) {
        this.fullDayService = fullDayService;
    }

    public boolean isOwnRoutine() {
        return ownRoutine;
    }

    public void setOwnRoutine(boolean ownRoutine) {
        this.ownRoutine = ownRoutine;
    }

    public boolean isOther() {
        return other;
    }

    public void setOther(boolean other) {
        this.other = other;
    }

    public String getOtherFacility() {
        return otherFacility;
    }

    public void setOtherFacility(String otherFacility) {
        this.otherFacility = otherFacility;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public boolean isPerDay() {
        return perDay;
    }

    public void setPerDay(boolean perDay) {
        this.perDay = perDay;
    }

    public boolean isPerKm() {
        return perKm;
    }

    public void setPerKm(boolean perKm) {
        this.perKm = perKm;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isNegotiable() {
        return negotiable;
    }

    public void setNegotiable(boolean negotiable) {
        this.negotiable = negotiable;
    }

    @Override
    public String toString() {
        return "TaxiPackageEntity{" +
                "packageId=" + packageId +
                ", packageName='" + packageName + '\'' +
                ", packageDesc='" + packageDesc + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", withDriver=" + withDriver +
                ", fuel=" + fuel +
                ", fullDayService=" + fullDayService +
                ", ownRoutine=" + ownRoutine +
                ", other=" + other +
                ", otherFacility='" + otherFacility + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                ", perDay=" + perDay +
                ", perKm=" + perKm +
                ", price=" + price +
                ", negotiable=" + negotiable +
                '}';
    }


}
