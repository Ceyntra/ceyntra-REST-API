package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.*;

@Entity
@Table(name = "hotelPackage")
public class HotelPackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;

    private String packageName;

    private String packageDesc;
    private String imageURL;

    private boolean withAC;
    private boolean swimPool;
    private boolean meal;
    private boolean other;

    private String otherFacility;
    private int roomCapacity;

    private boolean perDay;
    private boolean packageCharge;

    private double price;
    private boolean negotiable;

    private int hotelId;

    public HotelPackageEntity() {
    }

    public HotelPackageEntity(int packageId, String packageName, String packageDesc, String imageURL, boolean withAC, boolean swimPool, boolean meal, boolean other, String otherFacility, int roomCapacity, boolean perDay, boolean packageCharge, double price, boolean negotiable, int hotelId) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.packageDesc = packageDesc;
        this.imageURL = imageURL;
        this.withAC = withAC;
        this.swimPool = swimPool;
        this.meal = meal;
        this.other = other;
        this.otherFacility = otherFacility;
        this.roomCapacity = roomCapacity;
        this.perDay = perDay;
        this.packageCharge = packageCharge;
        this.price = price;
        this.negotiable = negotiable;
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "HotelPackageEntity{" +
                "packageId=" + packageId +
                ", packageName='" + packageName + '\'' +
                ", packageDesc='" + packageDesc + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", withAC=" + withAC +
                ", swimPool=" + swimPool +
                ", meal=" + meal +
                ", other=" + other +
                ", otherFacility='" + otherFacility + '\'' +
                ", roomCapacity=" + roomCapacity +
                ", perDay=" + perDay +
                ", packageCharge=" + packageCharge +
                ", price=" + price +
                ", negotiable=" + negotiable +
                ", hotelId=" + hotelId +
                '}';
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

    public boolean isWithAC() {
        return withAC;
    }

    public void setWithAC(boolean withAC) {
        this.withAC = withAC;
    }

    public boolean isSwimPool() {
        return swimPool;
    }

    public void setSwimPool(boolean swimPool) {
        this.swimPool = swimPool;
    }

    public boolean isMeal() {
        return meal;
    }

    public void setMeal(boolean meal) {
        this.meal = meal;
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

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public boolean isPerDay() {
        return perDay;
    }

    public void setPerDay(boolean perDay) {
        this.perDay = perDay;
    }

    public boolean isPackageCharge() {
        return packageCharge;
    }

    public void setPackageCharge(boolean packageCharge) {
        this.packageCharge = packageCharge;
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

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
}
