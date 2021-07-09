package com.ceyntra.ceyntraRestAPI.controller;


import com.ceyntra.ceyntraRestAPI.model.LoginModel;
import com.ceyntra.ceyntraRestAPI.model.UserModel;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/findAllUsers")
    public List<UserModel> getAllUsers(){
        System.out.println("sklj");
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public LoginModel login(@RequestBody LoginModel loginModel){
        System.out.println(loginModel.getEmail());
        List<String> userID = userRepository.getLoggedInUserId(loginModel.getEmail(), loginModel.getPassword());
        System.out.println(userID);


        return loginModel;
    }
}
