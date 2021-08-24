package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.ForgetPasswordEntity;
import com.ceyntra.ceyntraRestAPI.model.ResetPasswordModel;
import com.ceyntra.ceyntraRestAPI.repository.ForgetPasswordRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import com.ceyntra.ceyntraRestAPI.service.EmailService;
import com.ceyntra.ceyntraRestAPI.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ForgetPasswordController {
    @Autowired
    EmailService emailService;
    @Autowired
    LoginService loginService;
    @Autowired
    ForgetPasswordRepository forgetPasswordRepository;
    @Autowired
    UserRepository userRepository;






    @PostMapping("/sendAdminPasswordResetPin")
    public ResponseEntity<ForgetPasswordEntity> sendAdminPasswordResetPin(@RequestBody ForgetPasswordEntity forgetPasswordEntity){
        int pin = loginService.generateSixDigitRandomNumber();
        ForgetPasswordEntity model = new ForgetPasswordEntity();
        System.out.println(pin);
        forgetPasswordEntity.setPinNumber(pin);
        List<String> list2 = forgetPasswordRepository.findByEmail(forgetPasswordEntity.getEmail());
        if(!list2.isEmpty()){
            System.out.println("i am now in update box");
            forgetPasswordRepository.updatePin(forgetPasswordEntity.getEmail(), pin);
        }
        else{
            System.out.println("i am in save box");
            model = forgetPasswordRepository.save(forgetPasswordEntity);
        }

        String body = "Ceyntra admin account Password reset PIN : " + pin ;
        emailService.sendEmail(forgetPasswordEntity.getEmail(), body, "Reset Pin Ceyntra Admin");

        if(forgetPasswordEntity.getEmail().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
        }

        return ResponseEntity.ok().body(model);
    }

    @PostMapping("/resetAdminPassword")
    public String resetAdminPassword(@RequestBody ResetPasswordModel resetPasswordModel){
        System.out.println("hello");
        int x = resetPasswordModel.getPinNumber();
        String y = resetPasswordModel.getPassword();
        System.out.println(x);
        System.out.println(y);

       List<String> model = forgetPasswordRepository.findByEmailAndPin(resetPasswordModel.getEmail(), resetPasswordModel.getPinNumber());

//        System.out.println(model.get(0));
//        System.out.println("blaaa");

       if(!model.isEmpty()){
           List<String> list = Arrays.asList(model.get(0).split(","));
           int id = Integer.parseInt(list.get(0));
           String hashedPassword = loginService.doHash(resetPasswordModel.getPassword());
           int updateStatus = userRepository.resetPassword(hashedPassword, resetPasswordModel.getEmail());
           forgetPasswordRepository.deleteById(id);
           if(updateStatus == 1){
               if(forgetPasswordRepository.findById(id).isPresent()){
                   forgetPasswordRepository.deleteById(id);
               }
            return "done";
           }
            return "notUpdate";
       }

       return "userNotFound";
    }
}
