package com.ceyntra.ceyntraRestAPI.controller;


import com.ceyntra.ceyntraRestAPI.entity.TaxiDriverEntity;
import com.ceyntra.ceyntraRestAPI.entity.TravellingPlaceEntity;
import com.ceyntra.ceyntraRestAPI.model.CoordinatesModel;
import com.ceyntra.ceyntraRestAPI.repository.TaxiDriverRepository;
import com.ceyntra.ceyntraRestAPI.service.TravellingPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TaxiDriverController {


    @Autowired
    TaxiDriverRepository taxiDriverRepository;

    @Autowired
    TravellingPlaceService travellingPlaceService;


    @PostMapping("/getAllTaxisForLocation")
    public List<TaxiDriverEntity> getAllPlaces(@RequestBody CoordinatesModel currentPlaceCoordinates) throws IOException, InterruptedException {
        List<TaxiDriverEntity> currentLocationAvailableTaxis = new ArrayList<>();
        List<TaxiDriverEntity> allTaxiDriverList = taxiDriverRepository.getAllTaxiDriversAndSortByRating();

//        int distance = 0;
//
//
//        CoordinatesModel anotherPlaceCoordinates = new CoordinatesModel();
//
//        for (int i = 0; i< allTaxiDriverList.size(); i++){
//            anotherPlaceCoordinates.setLatitude(allTaxiDriverList.get(i).getWorking_latitude());
//            anotherPlaceCoordinates.setLongitude(allTaxiDriverList.get(i).getWorking_longitude());
//
//            distance = travellingPlaceService.calculateDistanceBetweenTwoPlaces(currentPlaceCoordinates, anotherPlaceCoordinates);
//
//            if(distance < 100){
//                currentLocationAvailableTaxis.add(allTaxiDriverList.get(i));
//            }
//
//
//
//        }


        return allTaxiDriverList;
    }
}
