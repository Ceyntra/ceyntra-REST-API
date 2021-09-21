package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.BannedTaxiEntity;
import com.ceyntra.ceyntraRestAPI.entity.TaxiDriverEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.BriefDetailsModel;
import com.ceyntra.ceyntraRestAPI.model.UserAndTaxiModel;
import com.ceyntra.ceyntraRestAPI.model.UserContactModel;
import com.ceyntra.ceyntraRestAPI.repository.BannedTaxiRepository;
import com.ceyntra.ceyntraRestAPI.repository.TaxiDriverRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import com.ceyntra.ceyntraRestAPI.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class TaxiDashboardController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaxiDriverRepository taxiDriverRepository;

    @Autowired
    BannedTaxiRepository bannedTaxiRepository;

    @Autowired
    EmailService emailService;

    @GetMapping("/getTaxiData")
    public List<Object> getCount(){
        List<Object> dataList=new ArrayList<>();
        int count = taxiDriverRepository.getDriverCount();
        int requestCount = taxiDriverRepository.getRequestCount();
        dataList.add(count);
        dataList.add(requestCount);
        List<Object> top=taxiDriverRepository.getTopFive();
        dataList.add(top);
        List<BannedTaxiEntity> bannedTaxi=bannedTaxiRepository.findAll();
        dataList.add(bannedTaxi);
        return dataList;
    }

    @GetMapping("/getDriverBriefDetails")
    public List<BriefDetailsModel> getHotelBriefDetails(){

        List<BriefDetailsModel> briefDetailsModelAll = new ArrayList<>();

        List<TaxiDriverEntity> driverList=taxiDriverRepository.getRegisteredDrivers();

        for (int i=0; i<driverList.size(); i++){
            Optional<UserEntity> user = userRepository.findById(driverList.get(i).getTaxi_driver_id());
            UserContactModel userContactModel = new UserContactModel();
            userContactModel.setEmail(user.get().getEmail());
            userContactModel.setTelephone(user.get().getTelephone());
            briefDetailsModelAll.add(new BriefDetailsModel(driverList.get(i).getTaxi_driver_id(), (driverList.get(i).getFirst_name()+' '+driverList.get(i).getLast_name()), driverList.get(i).getDistrict(), userContactModel));
        }
        return briefDetailsModelAll;
    }

    @PutMapping("/approveTaxiRequest/{id}")
    public int approveTaxiRequest(@PathVariable int id){
        int result=taxiDriverRepository.approveDriver(id);
        String mail=userRepository.getHotelEmail(id);
        String body = "Congratulations! Your account has been approved by the CeynTra team. Start your services and thank you for choosing CeynTra.";
        emailService.sendEmail(mail, body, "Account Approved");
        return result;
    }

    @DeleteMapping("/rejectTaxiRequest/{id}")
    public int rejectTaxiRequest(@PathVariable int id){
        String mail=userRepository.getHotelEmail(id);
        userRepository.deleteById(id);
        taxiDriverRepository.deleteById(id);
        String body = "Sorry... Your account has been rejected by the CeynTra team. Check and input valid account details and try to join the CeynTra group.";
        emailService.sendEmail(mail, body, "Account Rejected");
        if(userRepository.existsById(id) || taxiDriverRepository.existsById(id)){
            return 0;
        }else{
            return 1;
        }
    }

    @GetMapping("/getTaxis/{district}")
    public List<UserAndTaxiModel> getTaxiDetails(@PathVariable String district){

        List<UserAndTaxiModel> userAndTaxiModelAll = new ArrayList<>();

        List<TaxiDriverEntity> taxiList=taxiDriverRepository.getDistrictDrivers(district);

        for (int i=0; i<taxiList.size(); i++){
            Optional<UserEntity> user = userRepository.findById(taxiList.get(i).getTaxi_driver_id());
            UserContactModel userContactModel = new UserContactModel();
            userContactModel.setEmail(user.get().getEmail());
            userContactModel.setTelephone(user.get().getTelephone());
            userAndTaxiModelAll.add(new UserAndTaxiModel(taxiList.get(i), userContactModel));
        }
        return userAndTaxiModelAll;
    }

    @PostMapping("/bannedTaxi/{id}")
    public int banTaxi(@PathVariable int id){
        UserEntity user=userRepository.getById(id);
        TaxiDriverEntity taxi=taxiDriverRepository.getById(id);
        userRepository.deleteById(id);
        taxiDriverRepository.deleteById(id);
        BannedTaxiEntity bannedTaxiEntity=new BannedTaxiEntity(taxi.getFirst_name(), taxi.getLast_name(), taxi.getDriver_license(),
            user.getEmail(), user.getTelephone(), taxi.getRating(), taxi.getDistrict(), taxi.getProfile_photo());
        bannedTaxiRepository.save(bannedTaxiEntity);
        if(userRepository.existsById(id) || taxiDriverRepository.existsById(id)){
            return 0;
        }else{
            return 1;
        }
    }
}
