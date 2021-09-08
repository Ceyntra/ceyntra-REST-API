package com.ceyntra.ceyntraRestAPI.controller;


import com.ceyntra.ceyntraRestAPI.entity.TravellingPlaceEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.repository.TravellingPlaceRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class AdminDashboardController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TravellingPlaceRepository travellingPlaceRepository;

    @GetMapping("/getDashboardDetails")
    public HashMap<String, Object> getDashboardDetails(){
        int numOfTravellers = 0;
        int numOfHotels = 0;
        int numOfTaxiDrivers = 0;
        int numOfGuides = 0;

        List<UserEntity> userList = userRepository.getAllSortByAddedDate();
        HashSet<LocalDate> dateList = new HashSet<>();

//      list of not accepted places
        List<TravellingPlaceEntity> travellingPlaceEntityList = travellingPlaceRepository.getNotAcceptedPlaces();

        for(int i =0; i< userList.size(); i++){

            dateList.add(userList.get(i).getAdded_date());

            if(userList.get(i).getUserType() == 4){
                numOfTravellers = numOfTravellers +1;
            }
            else if(userList.get(i).getUserType() == 3){
                    numOfTaxiDrivers = numOfTaxiDrivers + 1;
            }
            else if(userList.get(i).getUserType() == 2){
                numOfHotels = numOfHotels + 1;
            }
            else if(userList.get(i).getUserType() == 1){
                numOfGuides = numOfGuides + 1;
            }
        }


        ArrayList<LocalDate> localDates = new ArrayList<LocalDate>(dateList);

        localDates.sort(Comparator.naturalOrder());


        HashMap<LocalDate, Integer> dateMap = new LinkedHashMap<>();
        HashMap<LocalDate, Integer> dateMap2 = new LinkedHashMap<>();



        for(int i =0; i< userList.size(); i++){
//
            for(int j =0; j<localDates.size();j++ ){
//
                if(userList.get(i).getAdded_date().equals(localDates.get(j))){
//
                    if(dateMap.containsKey(localDates.get(j))){
//
                        dateMap.put(localDates.get(j), dateMap.get(localDates.get(j)) +1);
                    }
                    else{
//
                        dateMap.put(localDates.get(j), 1);
                    }
                }
            }
        }

        for(int i=0; i < localDates.size(); i++){
            dateMap2.put(localDates.get(i), dateMap.get(localDates.get(i)));
        }



        HashMap<String, Object> details = new HashMap<>();
        details.put("numOfTravellers", numOfTravellers);
        details.put("numOfHotels", numOfHotels);
        details.put("numOfTaxiDrivers", numOfTaxiDrivers);
        details.put("numOfGuides", numOfGuides);
        details.put("dateMap", dateMap2);
        details.put("notAddedPlaces", travellingPlaceEntityList);

        return details;

    }
}
