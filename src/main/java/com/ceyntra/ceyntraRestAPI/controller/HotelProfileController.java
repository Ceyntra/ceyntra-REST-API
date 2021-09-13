package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.HotelEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.ProfilePhotoUpdateModel;
import com.ceyntra.ceyntraRestAPI.model.UserAndHotelModel;
import com.ceyntra.ceyntraRestAPI.model.UserContactModel;
import com.ceyntra.ceyntraRestAPI.repository.HotelRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HotelProfileController {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hotelUserProfile/{id}")
    public UserAndHotelModel getUserData(@PathVariable int id){
        Optional<HotelEntity> hotel = hotelRepository.findById(id);
        Optional<UserEntity> user = userRepository.findById(id);
        UserContactModel userContactModel = new UserContactModel();
        userContactModel.setEmail(user.get().getEmail());
        userContactModel.setTelephone(user.get().getTelephone());
        UserAndHotelModel details = new UserAndHotelModel(hotel.get(), userContactModel);
        return details;
    }

    @PutMapping("/updateHotelProfilePhoto")
    public int updateProfilePhoto(@RequestBody ProfilePhotoUpdateModel model){
        int result=hotelRepository.updatePhoto(model.getPhoto(), model.getUserID());
        return result;
    }
}
