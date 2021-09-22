package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.TravellingPlaceEntity;
import com.ceyntra.ceyntraRestAPI.repository.TravellingPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class PlaceDashboardController {

    @Autowired
    TravellingPlaceRepository travellingPlaceRepository;

    @GetMapping("/getPlaceData")
    public List<Object> getCount(){
        List<Object> dataList=new ArrayList<>();
        int count = travellingPlaceRepository.getPlaceCount();
        dataList.add(count);
        List<Object> top=travellingPlaceRepository.getTopFive();
        dataList.add(top);
        return dataList;
    }

    @GetMapping("/getPlaces/{district}")
    public List<TravellingPlaceEntity> getPlaceDetails(@PathVariable String district){
        List<TravellingPlaceEntity> placeList=travellingPlaceRepository.getDistrictPlaces(district);
        return placeList;
    }

    @DeleteMapping("/deletePlace/{id}")
    public int deletePlace(@PathVariable int id){
        travellingPlaceRepository.deleteById(id);
        if(travellingPlaceRepository.existsById(id)){
            return 0;
        }else{
            return 1;
        }
    }
}
