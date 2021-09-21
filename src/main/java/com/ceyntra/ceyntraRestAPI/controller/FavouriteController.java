package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.*;
import com.ceyntra.ceyntraRestAPI.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FavouriteController {

    @Autowired
    TravellerFavPlaceRepository travellerFavPlaceRepository;
    @Autowired
    TravellingPlaceRepository travellingPlaceRepository;
    @Autowired
    TravellerFavSpRepository travellerFavSpRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TaxiDriverRepository taxiDriverRepository;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    GuideRepository guideRepository;

    @GetMapping("/loadFavPlaces/{id}")
    public List<TravellingPlaceEntity> loadFavPlaces(@PathVariable("id") int id){
        List<TravellingPlaceEntity> travellingPlaceEntityList = new ArrayList<>();
        List<TravellerFavPlaceEntity> travellerFavPlaceEntityList = travellerFavPlaceRepository.getFavPlaces(id);

        for(int i=0; i<travellerFavPlaceEntityList.size(); i++){
            travellingPlaceEntityList.add(travellingPlaceRepository.findById(travellerFavPlaceEntityList.get(i).getPlace_id()).get());
        }

        return travellingPlaceEntityList;

    }


    @GetMapping("/loadFavTaxies/{id}")
    public  List<TaxiDriverEntity>  loadFavTaxies(@PathVariable("id") int id){
        List<TaxiDriverEntity> taxiDriverEntityList = new ArrayList<>();
        List<TravellerFavSpEntity> travellerFavSpEntityList = travellerFavSpRepository.getFavTaxi(id);

        for(int i=0; i<travellerFavSpEntityList.size(); i++){
            int userType = userRepository.findById(travellerFavSpEntityList.get(i).getSp_id()).get().getUserType();
            if(userType == 3){

                taxiDriverEntityList.add(taxiDriverRepository.findById(travellerFavSpEntityList.get(i).getSp_id()).get());

            }
        }

        return taxiDriverEntityList;

    }


    @GetMapping("/loadFavHotels/{id}")
    public  List<HotelEntity>  loadFavHotels(@PathVariable("id") int id){
        List<HotelEntity> hotelEntityList = new ArrayList<>();
        List<TravellerFavSpEntity> travellerFavSpEntityList = travellerFavSpRepository.getFavTaxi(id);

        for(int i=0; i<travellerFavSpEntityList.size(); i++){
            int userType = userRepository.findById(travellerFavSpEntityList.get(i).getSp_id()).get().getUserType();
            if(userType == 2){

                hotelEntityList.add(hotelRepository.findById(travellerFavSpEntityList.get(i).getSp_id()).get());

            }
        }

        return hotelEntityList;

    }

    @GetMapping("/loadFavGuides/{id}")
    public   List<GuideEntity>  loadFavGuides(@PathVariable("id") int id){
        List<GuideEntity> guideEntityList = new ArrayList<>();
        List<TravellerFavSpEntity> travellerFavSpEntityList = travellerFavSpRepository.getFavTaxi(id);

        for(int i=0; i<travellerFavSpEntityList.size(); i++){
            int userType = userRepository.findById(travellerFavSpEntityList.get(i).getSp_id()).get().getUserType();
            if(userType == 1){

                guideEntityList.add(guideRepository.findById(travellerFavSpEntityList.get(i).getSp_id()).get());

            }
        }

        return guideEntityList;

    }
}
