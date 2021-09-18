package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.TaxiDriverEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.DetailsUpdateModel;
import com.ceyntra.ceyntraRestAPI.model.ProfilePhotoUpdateModel;
import com.ceyntra.ceyntraRestAPI.model.UserAndTaxiModel;
import com.ceyntra.ceyntraRestAPI.model.UserContactModel;
import com.ceyntra.ceyntraRestAPI.repository.TaxiDriverRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TaxiProfileController {

    @Autowired
    private TaxiDriverRepository taxiDriverRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/taxiUserProfile/{id}")
    public UserAndTaxiModel getUserData(@PathVariable int id){
        Optional<TaxiDriverEntity> taxi = taxiDriverRepository.findById(id);
        Optional<UserEntity> user = userRepository.findById(id);
        UserContactModel userContactModel = new UserContactModel();
        userContactModel.setEmail(user.get().getEmail());
        userContactModel.setTelephone(user.get().getTelephone());
        UserAndTaxiModel details = new UserAndTaxiModel(taxi.get(), userContactModel);
        return details;
    }

    @PutMapping("/updateTaxiProfilePhoto")
    public int updateProfilePhoto(@RequestBody ProfilePhotoUpdateModel model){
        int result=taxiDriverRepository.updatePhoto(model.getPhoto(), model.getUserID());
        return result;
    }

    @PutMapping("/updateTaxiProfileDetails")
    public int updateTaxiProfileDetails(@RequestBody DetailsUpdateModel model){
        int result1=userRepository.updateContactDetails(model.getEmail(), model.getContactNumber(), model.getUserID());
        int result2=taxiDriverRepository.updateTaxiDetails(model.getLicense(), model.getFirstName(), model.getLastName(), model.getPricePerkm(), model.getUserID());
        if(result1*result2>0){
            return 1;
        }else{
            return 0;
        }
    }

    @DeleteMapping("/deleteDriverAccount/{id}")
    public int deleteAccount(@PathVariable int id){
        userRepository.deleteById(id);
        taxiDriverRepository.deleteById(id);
        if(userRepository.existsById(id) || taxiDriverRepository.existsById(id)){
            return 0;
        }else{
            return 1;
        }
    }
}
