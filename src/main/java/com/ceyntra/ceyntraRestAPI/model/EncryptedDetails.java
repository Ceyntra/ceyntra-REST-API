package com.ceyntra.ceyntraRestAPI.model;

public class EncryptedDetails {
    private String userId;
    private String randomKey;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRandomKey() {
        return randomKey;
    }

    public void setRandomKey(String randomKey) {
        this.randomKey = randomKey;
    }
}
