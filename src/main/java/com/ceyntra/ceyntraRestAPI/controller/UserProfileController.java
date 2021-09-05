package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.TravellerEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.*;
import com.ceyntra.ceyntraRestAPI.repository.TravellerRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TravellerRepository travellerRepository;

    @GetMapping("/userProfile/{id}")
    public UserAndTravellerModel getUserData(@PathVariable int id){
        Optional<TravellerEntity> traveller = travellerRepository.findById(id);
        Optional<UserEntity> user = userRepository.findById(id);
        UserContactModel userContactModel = new UserContactModel();
        userContactModel.setEmail(user.get().getEmail());
        userContactModel.setTelephone(user.get().getTelephone());
        UserAndTravellerModel details = new UserAndTravellerModel(traveller.get(), userContactModel);
        return details;
    }

    @PutMapping("/updateProfilePhoto")
    public int updateProfilePhoto(@RequestBody ProfilePhotoUpdateModel model){
        int result=travellerRepository.updatePhoto(model.getPhoto(), model.getUserID());
        return result;
    }

    @PutMapping("/updateProfileDetails")
    public int updateProfileDetails(@RequestBody DetailsUpdateModel model){
        int result1=userRepository.updateContactDetails(model.getEmail(), model.getContactNumber(), model.getUserID());
        int result2=travellerRepository.updateDetails(model.getNic(), model.getFirstName(), model.getLastName(), model.getUserID());
        if(result1*result2>0){
            return 1;
        }else{
            return 0;
        }
    }
}
