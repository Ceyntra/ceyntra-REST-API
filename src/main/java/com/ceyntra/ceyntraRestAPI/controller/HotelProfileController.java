package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.HotelEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.DetailsUpdateModel;
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

    @PutMapping("/updateHotelProfileDetails")
    public int updateHotelProfileDetails(@RequestBody DetailsUpdateModel model){
        int result1=userRepository.updateContactDetails(model.getEmail(), model.getContactNumber(), model.getUserID());
        int result2=hotelRepository.updateHotelDetails(model.getFirstName(), model.getRegistrationNo(), model.getDescription(), model.getUserID());
        if(result1*result2>0){
            return 1;
        }else{
            return 0;
        }
    }

    @DeleteMapping("/deleteHotelAccount/{id}")
    public int deleteAccount(@PathVariable int id){
        userRepository.deleteById(id);
        hotelRepository.deleteById(id);
        if(userRepository.existsById(id) || hotelRepository.existsById(id)){
            return 0;
        }else{
            return 1;
        }
    }

    @GetMapping("/getHotelRating/{id}")
    public double getHotelRating(@PathVariable int id){
        double rating=hotelRepository.getRatingByHotelID(id);
        return rating;
    }

}
