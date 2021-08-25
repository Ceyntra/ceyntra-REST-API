package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "traveller")
public class TravellerEntity {

    @Id
    @Column(name = "traveller_id")
    private int userID;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private  String nic;
    private String profile_photo;

    public TravellerEntity() {
    }

    public TravellerEntity(int userID, String firstName, String lastName, String nic, String profile_photo) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.profile_photo = profile_photo;
    }

    public TravellerEntity(int userID, String firstName, String lastName, String nic) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
    }

    public String getPhoto() {
        return profile_photo;
    }

    public void setPhoto(String photo) {
        this.profile_photo = photo;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}
