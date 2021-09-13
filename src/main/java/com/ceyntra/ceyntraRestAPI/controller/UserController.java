package com.ceyntra.ceyntraRestAPI.controller;


import com.ceyntra.ceyntraRestAPI.entity.ForgetPasswordEntity;
import com.ceyntra.ceyntraRestAPI.model.LoginModel;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.ResetPasswordModel;
import com.ceyntra.ceyntraRestAPI.repository.ForgetPasswordRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import com.ceyntra.ceyntraRestAPI.service.EmailService;
import com.ceyntra.ceyntraRestAPI.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;

    @Autowired
    EmailService emailService;

    @Autowired
    ForgetPasswordRepository forgetPasswordRepository;




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


    //User password reset

    @PostMapping("/resetpassword")
    public ResponseEntity<ForgetPasswordEntity> resetPassword(@RequestBody ForgetPasswordEntity forgetPasswordEntity){

        System.out.println("Email :"+forgetPasswordEntity.getEmail());

        UserEntity user=userRepository.findByEmail(forgetPasswordEntity.getEmail());

        if(user == null){
            //INValid email
            System.out.println("No user ");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ForgetPasswordEntity());

        }else {
            //Valid email

            int pin = loginService.generateFourDigitRandomNumber();

            ForgetPasswordEntity model = new ForgetPasswordEntity();

            System.out.println(pin);
            forgetPasswordEntity.setPinNumber(pin);
            List<String> list2 = forgetPasswordRepository.findByEmail(forgetPasswordEntity.getEmail());
            if (!list2.isEmpty()) {
                System.out.println("i am now in update box");
                forgetPasswordRepository.updatePin(forgetPasswordEntity.getEmail(), pin);
            } else {
                System.out.println("i am in save box");
                model = forgetPasswordRepository.save(forgetPasswordEntity);
            }

            String body = "Ceyntra Password reset PIN : " + pin;
            emailService.sendEmail(forgetPasswordEntity.getEmail(), body, "Reset Pin Ceyntra");

            if (forgetPasswordEntity.getEmail().isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
            }

            return ResponseEntity.ok().body(model);
        }
    }

    @PostMapping("/verifypin")
    public ResponseEntity<ForgetPasswordEntity> verifyPinCode(@RequestBody ForgetPasswordEntity forgetPasswordEntity ){

        ForgetPasswordEntity entity=forgetPasswordRepository.getForgetPasswordEntityByEmailAndPinNumber(forgetPasswordEntity.getEmail(),forgetPasswordEntity.getPinNumber());

        System.out.println(entity.toString());

        if(entity != null){
            return ResponseEntity.ok(entity);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ForgetPasswordEntity());
        }

    }

    @PutMapping("/updatepassword")
    public ResponseEntity<ResetPasswordModel> updatePassword(@RequestBody ResetPasswordModel passwordModel){

        System.out.println(passwordModel.toString());

        String hashedPassword = loginService.doHash(passwordModel.getPassword());

        int success=userRepository.updateUserPasswordByEmail(passwordModel.getEmail(),hashedPassword);

        if(success > 0){
            //Delete Forget password table column
            forgetPasswordRepository.deleteByEmail(passwordModel.getEmail());

            return ResponseEntity.ok(passwordModel);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(passwordModel);
        }

    }


}
