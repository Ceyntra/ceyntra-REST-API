package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.*;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import com.ceyntra.ceyntraRestAPI.service.Encryption;
import com.ceyntra.ceyntraRestAPI.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController

@CrossOrigin("*")
public class LoginController {

    public LoginController() throws NoSuchAlgorithmException {
    }

    @Autowired
    Encryption encryption;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginService loginService;
    IvParameterSpec ivParameterSpec = encryption.generateIv();
    SecretKey key = encryption.generateKey(128);
    String algorithm = "AES/CBC/PKCS5Padding";

    //  function for change security key after every day
    @Scheduled(fixedRate = 24 * 60000)
    public void changeSecurityAndIVKey() throws NoSuchAlgorithmException {
        ivParameterSpec = encryption.generateIv();
        key = encryption.generateKey(128);
    }

    //   function for get user email by user Id
    @GetMapping("/getUser/{id}")
    public UserEntity getUserDetailsById(@PathVariable int id) {
        UserEntity user1 = userRepository.findById(id).get();
        return new UserEntity(user1.getEmail(), user1.getTelephone());
    }

    //  login function, validate password and user name , after validation send userID to the front end and
    //   set user isLoggedIn column to 1
    @PostMapping("/login")
    public String login(@RequestBody LoginModel loginModel) {
        String hashedPassword = loginService.doHash(loginModel.getPassword());
        System.out.println(userRepository.findAll());
        List<String> userID = userRepository.getMatchingUserIdForCredential(loginModel.getEmail(), hashedPassword, 1);

        List<String> userEmail = userRepository.getMatchingUserEmail(loginModel.getEmail(), 1);
        List<String> hashedPasswordUserId = userRepository.getMatchingUserHashedPassword(hashedPassword, 1);

    //  check if there is matching user
        if (!userID.isEmpty() && userID.size() == 1) {
            UserEntity user1 = userRepository.findById(Integer.parseInt(userID.get(0))).get();
            userRepository.updateUserLoggedInStatus(1, Integer.parseInt(userID.get(0)));
            return userID.get(0);
        } else if (userID.isEmpty()) {
            if (userEmail.size() > 0 || hashedPasswordUserId.size() > 0) {
                return "emailOrPasswordIsIncorrect";
            } else if (userEmail.isEmpty() && hashedPasswordUserId.isEmpty()) {
                return "userNotFound";
            }
        }

        return "";
    }


    //   function for encrypt user Id
    @PostMapping("/encryptDetails")
    public String encryptUserId(@RequestBody EncryptedDetails encryptedDetails) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        String cipherText = encryption.encrypt(algorithm, encryptedDetails.getUserId(), key, ivParameterSpec);
        System.out.println(cipherText);
        return cipherText;
    }

//    logout function
    @PostMapping("/logout")
    public int logout(@RequestBody CipherTextModel cipherText) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        int userId = Integer.parseInt(decryptUserIdFunc(cipherText.getCipherText(), key));
       int response =  userRepository.updateUserLoggedInStatus(0, userId);

       return  response;
    }

//    function for decrypt user Id
    public String decryptUserIdFunc(String encryptedUserId, SecretKey key) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        try {
            String plainText = encryption.decrypt(algorithm, encryptedUserId, key, ivParameterSpec);
            System.out.println(plainText);
            return plainText;
        } catch (NoSuchPaddingException e) {
            return e.getMessage();
        } catch (NoSuchAlgorithmException e) {
            return e.getMessage();
        } catch (InvalidAlgorithmParameterException e) {
            return e.getMessage();
        } catch (InvalidKeyException e) {
            return e.getMessage();
        } catch (BadPaddingException e) {
            return e.getMessage();
        } catch (IllegalBlockSizeException e) {
            return e.getMessage();
        }


    }

//    check logging state
    @PostMapping("/checkLoginStatus")
    public LoginStateModel checkLoginStatus(@RequestBody CipherTextModel cipherText) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {

        try {
            System.out.println(cipherText.getCipherText());
            int userId = Integer.parseInt(decryptUserIdFunc(cipherText.getCipherText(), key));
            System.out.println("userId " + userId);

            List<String> userState = userRepository.checkLoginStatusOnUser(userId);
            LoginStateModel loginStateModel = new LoginStateModel(Integer.parseInt(userState.get(0)), userId);
            return loginStateModel;

        } catch (Exception e) {
            return new LoginStateModel();
        }
    }


}
