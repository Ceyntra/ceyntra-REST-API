package com.ceyntra.ceyntraRestAPI.controller;


import com.ceyntra.ceyntraRestAPI.model.TravellerDetailsModel;
import com.ceyntra.ceyntraRestAPI.entity.TravellerEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.repository.TravellerRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import com.ceyntra.ceyntraRestAPI.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
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
        UserEntity userDetails = new UserEntity(user.getEmail(),user.getContactNumber(),4,hashedPassword,0);
        UserEntity x = userRepository.save(userDetails);
        int userID = userDetails.getUserID();
        try{
            if(x.getEmail().isEmpty())
            {
                userRepository.deleteById(userID);
                throw  new RuntimeException();
            }
            TravellerEntity traveller = new TravellerEntity(userID,user.getFirstName(),user.getLastName(),user.getNic());
            TravellerEntity t =  travellerRepository.save(traveller);
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
