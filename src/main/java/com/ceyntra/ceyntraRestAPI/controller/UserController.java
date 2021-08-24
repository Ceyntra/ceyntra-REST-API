package com.ceyntra.ceyntraRestAPI.controller;


import com.ceyntra.ceyntraRestAPI.model.LoginModel;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import com.ceyntra.ceyntraRestAPI.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;


    @GetMapping("/findAllUsers")
    public List<UserEntity> getAllUsers(){
        System.out.println("sklj");
        return userRepository.findAll();
    }

//    For Ceyntra-Mobile

    @PostMapping("/usertype")
    public int getUserType(@RequestBody String email){
        System.out.println("Hello " + email);
        UserEntity user=userRepository.findByEmail(email);
        if(user != null){
            return user.getUserType();
        }else{
            return 404;
        }
    }

    @PostMapping(value = "/userlogin", consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> login(@RequestBody LoginModel loginModel) {

        String hashedPassword = loginService.doHash(loginModel.getPassword());
        int userType=getUserType(loginModel.getEmail());

        if(userType == 404){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserEntity());
        }

        List<String> userID = userRepository.getMatchingUserIdForCredential(loginModel.getEmail(), hashedPassword, userType);
        List<String> userEmail = userRepository.getMatchingUserEmail(loginModel.getEmail(), userType);
        List<String> hashedPasswordUserId = userRepository.getMatchingUserHashedPassword(hashedPassword, userType);

        //  check if there is matching user
        if (!userID.isEmpty() && userID.size() == 1) {
            UserEntity user1 = userRepository.findById(Integer.parseInt(userID.get(0))).get();
            userRepository.updateUserLoggedInStatus(1, Integer.parseInt(userID.get(0)));
            return ResponseEntity.ok().body(user1);

        } else if (userID.isEmpty()) {
            if (userEmail.size() > 0 || hashedPasswordUserId.size() > 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserEntity());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserEntity());
    }

    @GetMapping("/userlogout")
    public int logout(@RequestBody LoginModel loginModel) {
        System.out.println("sdkjfs");
        UserEntity user=userRepository.findByEmail(loginModel.getEmail());
        int response =  userRepository.updateUserLoggedInStatus(0, user.getUserID());

        return  response;
    }



}
