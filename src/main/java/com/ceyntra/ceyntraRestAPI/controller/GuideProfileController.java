package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.GuideEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.DetailsUpdateModel;
import com.ceyntra.ceyntraRestAPI.model.ProfilePhotoUpdateModel;
import com.ceyntra.ceyntraRestAPI.model.UserAndGuideModel;
import com.ceyntra.ceyntraRestAPI.model.UserContactModel;
import com.ceyntra.ceyntraRestAPI.repository.GuideRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GuideProfileController {

    @Autowired
    private GuideRepository guideRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/guideUserProfile/{id}")
    public UserAndGuideModel getUserData(@PathVariable int id){
        Optional<GuideEntity> taxi = guideRepository.findById(id);
        Optional<UserEntity> user = userRepository.findById(id);
        UserContactModel userContactModel = new UserContactModel();
        userContactModel.setEmail(user.get().getEmail());
        userContactModel.setTelephone(user.get().getTelephone());
        UserAndGuideModel details = new UserAndGuideModel(taxi.get(), userContactModel);
        return details;
    }

    @PutMapping("/updateGuideProfilePhoto")
    public int updateProfilePhoto(@RequestBody ProfilePhotoUpdateModel model){
        int result=guideRepository.updatePhoto(model.getPhoto(), model.getUserID());
        return result;
    }

    @PutMapping("/updateGuideProfileDetails")
    public int updateTaxiProfileDetails(@RequestBody DetailsUpdateModel model){
        int result1=userRepository.updateContactDetails(model.getEmail(), model.getContactNumber(), model.getUserID());
        int result2=guideRepository.updateGuideDetails(model.getNic(), model.getFirstName(), model.getLastName(), model.getPricePerDay(), model.getDescription(), model.getVehicleState(), model.getUserID());
        if(result1*result2>0){
            return 1;
        }else{
            return 0;
        }
    }
}
