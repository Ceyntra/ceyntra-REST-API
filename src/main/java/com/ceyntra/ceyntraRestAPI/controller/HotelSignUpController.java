package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.HotelEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.HotelSignUpModel;
import com.ceyntra.ceyntraRestAPI.repository.HotelRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import com.ceyntra.ceyntraRestAPI.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

@RestController
public class HotelSignUpController {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;

    @PostMapping("signupHotel")
    public String signUpHotel(@RequestBody HotelSignUpModel hotelSignUpModel){

        //Save user in User Table
        UserEntity user=new UserEntity(hotelSignUpModel.getEmail(),hotelSignUpModel.getContactNumber(),1,loginService.doHash(hotelSignUpModel.getPassword()),0, LocalDate.now());
        UserEntity savedUser= userRepository.save(user);

        //Save in Hotel table
        HotelEntity hotel=new HotelEntity(savedUser.getUserID(),hotelSignUpModel.getHotelName(),hotelSignUpModel.getHotelDesc(),hotelSignUpModel.getLat(),hotelSignUpModel.getLon(),hotelSignUpModel.getDistrict(),hotelSignUpModel.getRegistration(),"https://firebasestorage.googleapis.com/v0/b/ceyntra-project.appspot.com/o/profile_photos%2Fhotel%2FArchitecture_Hotel_1-copy-15.jpg?alt=media&token=6b7f711d-582a-4874-aa70-ec3a1744aaec",0,0,0);
        HotelEntity savedHotel=hotelRepository.save(hotel);

        if(savedHotel !=null){
            return "done";
        }
        return "not";
    }


}
