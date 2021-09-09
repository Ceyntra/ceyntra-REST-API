package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.GuideEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.UserAndGuideModel;
import com.ceyntra.ceyntraRestAPI.model.UserContactModel;
import com.ceyntra.ceyntraRestAPI.repository.GuideRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
