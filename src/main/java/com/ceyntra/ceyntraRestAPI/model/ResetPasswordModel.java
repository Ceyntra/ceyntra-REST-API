package com.ceyntra.ceyntraRestAPI.model;

public class ResetPasswordModel {
    private int pinNumber;
    private String email;
    private String password;

    public ResetPasswordModel(int pinNumber, String email, String password) {
        this.pinNumber = pinNumber;
        this.email = email;
        this.password = password;
    }

    public ResetPasswordModel() {
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
