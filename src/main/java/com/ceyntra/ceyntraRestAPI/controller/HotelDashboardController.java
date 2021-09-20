package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.BannedHotelsEntity;
import com.ceyntra.ceyntraRestAPI.entity.HotelEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.AllSPModel;
import com.ceyntra.ceyntraRestAPI.model.BriefDetailsModel;
import com.ceyntra.ceyntraRestAPI.model.UserAndHotelModel;
import com.ceyntra.ceyntraRestAPI.model.UserContactModel;
import com.ceyntra.ceyntraRestAPI.repository.BannedHotelsRepository;
import com.ceyntra.ceyntraRestAPI.repository.HotelRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import com.ceyntra.ceyntraRestAPI.service.EmailService;
import net.bytebuddy.utility.JavaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class HotelDashboardController {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    BannedHotelsRepository bannedHotelsRepository;

    @GetMapping("/getHotelsCount")
    public List<Object> getCount(){
        List<Object> countList=new ArrayList<>();
        int count = hotelRepository.getCount();
        int requestCount = hotelRepository.getRequestCount();
        countList.add(count);
        countList.add(requestCount);
        List<Object> top=hotelRepository.getTopFive();
        countList.add(top);
        List<BannedHotelsEntity> bannedHotels=bannedHotelsRepository.findAll();
        countList.add(bannedHotels);
        return countList;
    }

    @GetMapping("/getHotelsBriefDetails")
    public List<BriefDetailsModel> getHotelBriefDetails(){

        List<BriefDetailsModel> briefDetailsModelAll = new ArrayList<>();

        List<HotelEntity> hotelList=hotelRepository.getRegisteredHotels();

        for (int i=0; i<hotelList.size(); i++){
            Optional<UserEntity> user = userRepository.findById(hotelList.get(i).getHotel_id());
            UserContactModel userContactModel = new UserContactModel();
            userContactModel.setEmail(user.get().getEmail());
            userContactModel.setTelephone(user.get().getTelephone());
            briefDetailsModelAll.add(new BriefDetailsModel(hotelList.get(i).getHotel_id(), hotelList.get(i).getName(), hotelList.get(i).getDistrict(), userContactModel));
        }
        return briefDetailsModelAll;
    }

    @GetMapping("/getHotels/{district}")
    public List<UserAndHotelModel> getHotelDetails(@PathVariable String district){

        List<UserAndHotelModel> userAndHotelModelAll = new ArrayList<>();

        List<HotelEntity> hotelList=hotelRepository.getDistrictHotels(district);

        for (int i=0; i<hotelList.size(); i++){
            Optional<UserEntity> user = userRepository.findById(hotelList.get(i).getHotel_id());
            UserContactModel userContactModel = new UserContactModel();
            userContactModel.setEmail(user.get().getEmail());
            userContactModel.setTelephone(user.get().getTelephone());
            userAndHotelModelAll.add(new UserAndHotelModel(hotelList.get(i), userContactModel));
        }
        return userAndHotelModelAll;
    }

    @GetMapping("/getNewRequests/{userType}")
    public List<AllSPModel> getNewRequests(@PathVariable int userType){
        List<AllSPModel> allSPModels = new ArrayList<>();

        if(userType==1){
            List<HotelEntity> hotelRequestList=hotelRepository.getNewRequests();
            for (int i=0; i<hotelRequestList.size(); i++){
                Optional<UserEntity> user = userRepository.findById(hotelRequestList.get(i).getHotel_id());
                UserContactModel userContactModel = new UserContactModel();
                userContactModel.setEmail(user.get().getEmail());
                userContactModel.setTelephone(user.get().getTelephone());
                allSPModels.add(new AllSPModel(new UserAndHotelModel(hotelRequestList.get(i), userContactModel)));
            }
        }

        return allSPModels;
    }

    @PutMapping("/approveHotelRequest/{id}")
    public int approveHotelRequest(@PathVariable int id){
        int result=hotelRepository.approveHotel(id);
        String mail=userRepository.getHotelEmail(id);
        String body = "Congratulations! Your account has been approved by the CeynTra team. Start your services and thank you for choosing CeynTra.";
        emailService.sendEmail(mail, body, "Account Approved");
        return result;
    }

    @DeleteMapping("/rejectHotelRequest/{id}")
    public int rejectHotelRequest(@PathVariable int id){
        String mail=userRepository.getHotelEmail(id);
        userRepository.deleteById(id);
        hotelRepository.deleteById(id);
        String body = "Sorry... Your account has been rejected by the CeynTra team. Check and input valid account details and try to join the CeynTra group.";
        emailService.sendEmail(mail, body, "Account Rejected");
        if(userRepository.existsById(id) || hotelRepository.existsById(id)){
            return 0;
        }else{
            return 1;
        }
    }

    @PostMapping("/bannedHotel/{id}")
    public int banHotel(@PathVariable int id){
        UserEntity user=userRepository.getById(id);
        HotelEntity hotel=hotelRepository.getById(id);
        userRepository.deleteById(id);
        hotelRepository.deleteById(id);
        BannedHotelsEntity bannedHotelsEntity=new BannedHotelsEntity(user.getEmail(), user.getTelephone(), hotel.getName(),
                hotel.getDistrict(), hotel.getRegistration_number(), hotel.getRating(), hotel.getProfile_photo());
        bannedHotelsRepository.save(bannedHotelsEntity);
        if(userRepository.existsById(id) || hotelRepository.existsById(id)){
            return 0;
        }else{
            return 1;
        }
    }
}
