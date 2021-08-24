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

    public TravellerEntity() {
    }

    public TravellerEntity(int userID, String firstName, String lastName, String nic) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
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
