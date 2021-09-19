package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.HotelEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.BriefDetailsModel;
import com.ceyntra.ceyntraRestAPI.model.UserAndHotelModel;
import com.ceyntra.ceyntraRestAPI.model.UserContactModel;
import com.ceyntra.ceyntraRestAPI.repository.HotelRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getHotelsCount")
    public List<Integer> getCount(){
        List<Integer> countList=new ArrayList<>();
        int count = hotelRepository.getCount();
        int requestCount = hotelRepository.getRequestCount();
        countList.add(count);
        countList.add(requestCount);
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
}
