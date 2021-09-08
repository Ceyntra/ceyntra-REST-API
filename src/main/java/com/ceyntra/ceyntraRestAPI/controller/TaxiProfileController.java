package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.TaxiDriverEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.UserAndTaxiModel;
import com.ceyntra.ceyntraRestAPI.model.UserContactModel;
import com.ceyntra.ceyntraRestAPI.repository.TaxiDriverRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
