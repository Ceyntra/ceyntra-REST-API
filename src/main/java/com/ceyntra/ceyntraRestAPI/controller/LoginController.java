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
    public String login(@RequestBody LoginModel loginModel){

        String hashedPassword = loginService.doHash(loginModel.getPassword());

        List<String> userID = userRepository.getMatchingUserIdForCredential(loginModel.getEmail(), hashedPassword, 1);
        List<String> userEmail = userRepository.getMatchingUserEmail(loginModel.getEmail(), 1);
        List<String> hashedPasswordUserId = userRepository.getMatchingUserHashedPassword(hashedPassword, 1);

        System.out.println(hashedPasswordUserId.get(0));
        if(!userID.isEmpty() && userID.size() == 1){
            return userID.get(0);
        }
        else if(userID.isEmpty())
        {
            if(userEmail.size() > 0 || hashedPasswordUserId.size() > 0){
                return "emailOrPasswordIsIncorrect";
            }
            else if(userEmail.isEmpty() && hashedPasswordUserId.isEmpty())
            {
                return "userNotFound";
            }
        }

        System.out.println("we are now in the login");

        System.out.println(userID);


        return "";
    }
}
