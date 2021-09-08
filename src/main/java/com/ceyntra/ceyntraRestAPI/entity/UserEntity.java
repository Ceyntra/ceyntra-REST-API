package com.ceyntra.ceyntraRestAPI.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "user")
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userID;
    private String email;
    private String telephone;
    @Column(name = "user_type")
    private int userType;
    @Column(name = "hashed_password")
    private String hashedPassword;
    @Column(name = "is_logged_in")
    private int isLoggedIn;
    private LocalDate added_date;


    public UserEntity() {
    }

    public UserEntity(int userID, String email, String telephone, int userType, String hashedPassword, int isLoggedIn, LocalDate added_date) {
        this.userID = userID;
        this.email = email;
        this.telephone = telephone;
        this.userType = userType;
        this.hashedPassword = hashedPassword;
        this.isLoggedIn = isLoggedIn;
        this.added_date = added_date;
    }

    public UserEntity(String email, String telephone, int userType, String hashedPassword, int isLoggedIn) {

        this.email = email;
        this.telephone = telephone;
        this.userType = userType;
        this.hashedPassword = hashedPassword;
        this.isLoggedIn = isLoggedIn;
    }

    public LocalDate getAdded_date() {
        return added_date;
    }

    public void setAdded_date(LocalDate added_date) {
        this.added_date = added_date;
    }

    public UserEntity(String email, String telephone) {
        this.email = email;
        this.telephone = telephone;
    }



    public UserEntity(String email) {
        this.email = email;
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

    public int getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(int isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userID=" + userID +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", userType=" + userType +
                ", hashedPassword='" + hashedPassword + '\'' +
                ", isLoggedIn=" + isLoggedIn +
                '}';
    }
}
