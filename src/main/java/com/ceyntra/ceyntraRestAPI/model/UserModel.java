package com.ceyntra.ceyntraRestAPI.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserModel {

    @Id

    private int userID;

    private  String email;

    private  String telephone;

    @Column(name = "user_type")
    private  int userType;

    @Column(name = "hashed_password")
    private String hashedPassword;

    public UserModel() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userID=" + userID +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", userType=" + userType +
                ", hashedPassword='" + hashedPassword + '\'' +
                '}';
    }
}
