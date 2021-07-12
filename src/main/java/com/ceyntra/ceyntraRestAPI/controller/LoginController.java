package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.model.*;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import com.ceyntra.ceyntraRestAPI.service.Encryption;
import com.ceyntra.ceyntraRestAPI.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@SessionAttributes({"name"})
@CrossOrigin("*")
public class LoginController {

    @Autowired
    Encryption encryption;
    IvParameterSpec  ivParameterSpec=  encryption.generateIv();
    SecretKey key = encryption.generateKey(128);
    String algorithm = "AES/CBC/PKCS5Padding";

    @Scheduled(fixedRate = 24*60000)
    public void gen() throws NoSuchAlgorithmException {
      ivParameterSpec =  encryption.generateIv();
        key = encryption.generateKey(128);
//        System.out.println(ivParameterSpec.getIV());
    }
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;

    public LoginController() throws NoSuchAlgorithmException {
    }

    @GetMapping("/getUser/{id}")
    public UserModel getUserDetailsById(@PathVariable int id)
    {
       UserModel user1 =  userRepository.findById(id).get();
       return new UserModel(user1.getEmail(), user1.getTelephone());
    }


    @PostMapping("/login")
    public String login(@RequestBody LoginModel loginModel, HttpServletRequest request) {
        String hashedPassword = loginService.doHash(loginModel.getPassword());

        List<String> userID = userRepository.getMatchingUserIdForCredential(loginModel.getEmail(), hashedPassword, 1);
        List<String> userEmail = userRepository.getMatchingUserEmail(loginModel.getEmail(), 1);
        List<String> hashedPasswordUserId = userRepository.getMatchingUserHashedPassword(hashedPassword, 1);

//        System.out.println(hashedPasswordUserId.get(0));
        if (!userID.isEmpty() && userID.size() == 1) {
            UserModel user1 = userRepository.findById(Integer.parseInt(userID.get(0))).get();
                userRepository.updateUserLoggedInStatus(1, Integer.parseInt(userID.get(0)));
            return userID.get(0);
        } else if (userID.isEmpty()) {
            if (userEmail.size() > 0 || hashedPasswordUserId.size() > 0) {
                return "emailOrPasswordIsIncorrect";
            } else if (userEmail.isEmpty() && hashedPasswordUserId.isEmpty()) {
                return "userNotFound";
            }
        }

        System.out.println("we are now in the login");

        System.out.println(userID);


        return "";
    }



    @PostMapping("/encryptDetails")
    public String  encryptUserId(@RequestBody EncryptedDetails encryptedDetails) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
//        byte[] decodedKey = Base64.getDecoder().decode(encryptedDetails.getRandomKey());
//        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

        String cipherText = encryption.encrypt(algorithm, encryptedDetails.getUserId(), key, ivParameterSpec);
        System.out.println(cipherText);
        return cipherText;
    }

    @GetMapping("/logout/{key3}")
    public String logout(@PathVariable String key3) throws NoSuchAlgorithmException {
        return  null;
    }



    public String  decryptUserIdFunc(String encryptedUserId, SecretKey key) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
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

    @PostMapping("/checkLoginStatus")
    public LoginStateModel checkLoginStatus(@RequestBody CipherTextModel cipherText) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {


        try {

//            byte[] decodedKey = Base64.getDecoder().decode(cipherText.getRandomKey());
//            SecretKey originalKey2 = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

            System.out.println(cipherText.getCipherText());
            int userId = Integer.parseInt(decryptUserIdFunc(cipherText.getCipherText(), key));
            System.out.println("userId "+userId);

            List<String> userState = userRepository.checkLoginStatusOnUser(userId);
            LoginStateModel loginStateModel = new LoginStateModel(Integer.parseInt(userState.get(0)), userId);
            return loginStateModel;

        } catch (Exception e){

            return new LoginStateModel();

        }


    }






//    @PostMapping("/persistMessage")
//    public String persistMessage(@RequestParam("msg") String msg, HttpServletRequest request) {
//        @SuppressWarnings("unchecked")
//        List<String> isLoggedIn = (List<String>) request.getSession().getAttribute("IS_LOGGED_IN");
//        if (isLoggedIn == null) {
//            isLoggedIn = new ArrayList<>();
//            request.getSession().setAttribute("MY_SESSION_MESSAGES", isLoggedIn);
//        }
//        isLoggedIn.add(msg);
//        request.getSession().setAttribute("MY_SESSION_MESSAGES", isLoggedIn);
//        return "redirect:/";
//    }
//
//    @PostMapping("/destroy")
//    public String destroySession(HttpServletRequest request) {
//        request.getSession().invalidate();
//        return "redirect:/";
//    }
}
