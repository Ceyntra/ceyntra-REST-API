package com.ceyntra.ceyntraRestAPI.controller;
import com.ceyntra.ceyntraRestAPI.model.LoginModel;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import com.ceyntra.ceyntraRestAPI.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public LoginModel login(@RequestBody LoginModel loginModel){

        String hashedPassword = loginService.doHash(loginModel.getPassword());

        List<String> userID = userRepository.getLoggedInUserId(loginModel.getEmail(), loginModel.getPassword());


        System.out.println("we are now in the login");
        System.out.println(hashedPassword);
        System.out.println(userID);


        return loginModel;
    }
}
