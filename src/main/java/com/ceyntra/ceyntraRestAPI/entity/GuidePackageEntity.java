package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.*;

@Entity
@Table(name = "guidePackage")
public class GuidePackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;

    private String packageName;
    private String packageDesc;
    private String places;
    private String imageURL;
    private String language;
    private int groupCapacity;
    private boolean perDay;
    private boolean perTour;
    private double price;
    private boolean negotiable;
    private int guideId;

    public GuidePackageEntity(int packageId, String packageName, String packageDesc, String places, String imageURL, String language, int groupCapacity, boolean perDay, boolean perTour, double price, boolean negotiable, int guideId) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.packageDesc = packageDesc;
        this.places = places;
        this.imageURL = imageURL;
        this.language = language;
        this.groupCapacity = groupCapacity;
        this.perDay = perDay;
        this.perTour = perTour;
        this.price = price;
        this.negotiable = negotiable;
        this.guideId = guideId;
    }

    public GuidePackageEntity() {

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

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getGroupCapacity() {
        return groupCapacity;
    }

    public void setGroupCapacity(int groupCapacity) {
        this.groupCapacity = groupCapacity;
    }

    public boolean isPerDay() {
        return perDay;
    }

    public void setPerDay(boolean perDay) {
        this.perDay = perDay;
    }

    public boolean isPerTour() {
        return perTour;
    }

    public void setPerTour(boolean perTour) {
        this.perTour = perTour;
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

    public int getGuideId() {
        return guideId;
    }

    public void setGuideId(int guideId) {
        this.guideId = guideId;
    }
}
