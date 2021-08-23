package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.model.TravellingPlaceModel;
import com.ceyntra.ceyntraRestAPI.repository.TravellingPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PlaceController {

    @Autowired
    TravellingPlaceRepository travellingPlaceRepository;

    @GetMapping("/getAllPlaces")
    public List<TravellingPlaceModel> getAllPlaces(){
    List<TravellingPlaceModel> placeModelArrayList = travellingPlaceRepository.getPlacesAndSortByRating();
    return placeModelArrayList;
    }
}
