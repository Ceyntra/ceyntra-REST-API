package com.ceyntra.ceyntraRestAPI.model;

public class DetailsUpdateModel {
    private int userID;
    private String firstName;
    private String lastName;
    private  String nic;
    private String email;
    private String contactNumber;
    private  String password;

    public DetailsUpdateModel() {
    }

    public DetailsUpdateModel(int userID, String firstName, String lastName, String nic, String email, String contactNumber, String password) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.email = email;
        this.contactNumber = contactNumber;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
