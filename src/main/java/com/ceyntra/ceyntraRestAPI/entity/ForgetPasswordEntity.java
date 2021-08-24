package com.ceyntra.ceyntraRestAPI.entity;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;

@Entity
@Table(name = "forget_password")
public class ForgetPasswordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true)
    private String email;
    private int pinNumber;
    public ForgetPasswordEntity() {
    }

    public ForgetPasswordEntity(int pinNumber, String email) {
        this.pinNumber = pinNumber;
        this.email = email;
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
}
