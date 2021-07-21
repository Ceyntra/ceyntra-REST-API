package com.ceyntra.ceyntraRestAPI.controller;


import com.ceyntra.ceyntraRestAPI.model.TravellerDetailsModel;
import com.ceyntra.ceyntraRestAPI.model.TravellerModel;
import com.ceyntra.ceyntraRestAPI.model.UserModel;
import com.ceyntra.ceyntraRestAPI.repository.TravellerRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import com.ceyntra.ceyntraRestAPI.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class TravallerSignUpController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TravellerRepository travellerRepository;
    @Autowired
    private LoginService loginService;



//    @Transactional(rollbac = RuntimeException.class )
    @PostMapping("/getUserDetails")
    public String getUserDetails(@RequestBody TravellerDetailsModel user){
        String hashedPassword = loginService.doHash(user.getPassword());
        UserModel userDetails = new UserModel(user.getEmail(),user.getContactNumber(),2,hashedPassword,0);
        UserModel x = userRepository.save(userDetails);
        int userID = userDetails.getUserID();
        try{
            if(x.getEmail().isEmpty())
            {
                userRepository.deleteById(userID);
                throw  new RuntimeException();
            }
            TravellerModel traveller = new TravellerModel(userID,user.getFirstName(),user.getLastName(),user.getNic());
            TravellerModel t =  travellerRepository.save(traveller);
            if(t.getFirstName().isEmpty())
            {
                userRepository.deleteById(userID);
                travellerRepository.deleteById(userID);
                throw  new RuntimeException();
            }
            System.out.print(user.getPassword());
        } catch (Exception e){
            return "userNotAdded";
        }

        return "done";
    }


}
