package com.ceyntra.ceyntraRestAPI.model;

public class LoginStateModel {
    private int loginState;
    private int userId;

    public LoginStateModel(int loginState, int userId) {
        this.loginState = loginState;
        this.userId = userId;
    }

    public LoginStateModel() {

    }

    public int getLoginState() {
        return loginState;
    }

    public void setLoginState(int loginState) {
        this.loginState = loginState;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
