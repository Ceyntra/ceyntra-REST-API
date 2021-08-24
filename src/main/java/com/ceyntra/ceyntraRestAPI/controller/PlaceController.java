package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.PlaceReviewEntity;
import com.ceyntra.ceyntraRestAPI.model.CoordinatesModel;
import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;
import com.ceyntra.ceyntraRestAPI.model.TravellingPlaceModel;
import com.ceyntra.ceyntraRestAPI.entity.TravellerFavEntity;
import com.ceyntra.ceyntraRestAPI.repository.PlaceReviewRepository;
import com.ceyntra.ceyntraRestAPI.repository.TravellerFavPlaceRepository;
import com.ceyntra.ceyntraRestAPI.repository.TravellingPlaceRepository;
import com.ceyntra.ceyntraRestAPI.service.TravellingPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class PlaceController {

    @Autowired
    TravellingPlaceRepository travellingPlaceRepository;
    @Autowired
    TravellingPlaceService travellingPlaceService;
    @Autowired
    TravellerFavPlaceRepository travellerFavPlaceRepository;
    @Autowired
    PlaceReviewRepository placeReviewRepository;


//    @PostMapping("/getAllPlaces")
//    public List<TravellingPlaceModel> getAllPlaces(@RequestBody CoordinatesModel currentPlaceCoordinates) throws IOException, InterruptedException {
//        List<TravellingPlaceModel> currentLocationAvailablePlaces = new ArrayList<>();
//        List<TravellingPlaceModel> placeModelList = travellingPlaceRepository.getPlacesAndSortByRating();
//        int distance = 0;
//
//        CoordinatesModel anotherPlaceCoordinates = new CoordinatesModel();
//
//        for (int i = 0; i< placeModelList.size(); i++){
//            anotherPlaceCoordinates.setLatitude(placeModelList.get(i).getLatitude());
//            anotherPlaceCoordinates.setLongitude(placeModelList.get(i).getLongitude());
//
//            distance = travellingPlaceService.calculateDistanceBetweenTwoPlaces(currentPlaceCoordinates, anotherPlaceCoordinates);
//
//            if(distance < 100){
//                currentLocationAvailablePlaces.add(placeModelList.get(i));
//            }
//
//        }
//
//
//    return currentLocationAvailablePlaces;
//    }


//    dont delete upper commented function, this is dummy function and upper commented function is the real function with API.
    @PostMapping("/getAllPlaces")
    public List<TravellingPlaceModel> getAllPlaces(@RequestBody CoordinatesModel currentPlaceCoordinates) throws IOException, InterruptedException {
        List<TravellingPlaceModel> currentLocationAvailablePlaces = new ArrayList<>();
        List<TravellingPlaceModel> placeModelList = travellingPlaceRepository.getPlacesAndSortByRating();
        int distance = 0;

        CoordinatesModel anotherPlaceCoordinates = new CoordinatesModel();

        for (int i = 0; i< placeModelList.size(); i++){
            anotherPlaceCoordinates.setLatitude(placeModelList.get(i).getLatitude());
            anotherPlaceCoordinates.setLongitude(placeModelList.get(i).getLongitude());

                currentLocationAvailablePlaces.add(placeModelList.get(i));


        }


        return currentLocationAvailablePlaces;
    }

    @PostMapping("/getMetadataInPlace")
    public void getMetadataInPlace(@RequestBody UserPlaceId userPlaceId){
        boolean isFavourite = false;
        List<PlaceReviewEntity> reviews = new ArrayList<PlaceReviewEntity>();


        Optional<TravellerFavEntity> details = travellerFavPlaceRepository.findById(userPlaceId);
        List<PlaceReviewEntity> allReviews = placeReviewRepository.getAllReviews(userPlaceId.getUser_id(), userPlaceId.getPlace_id());
        if(allReviews.size() > 20)
        {
            reviews = allReviews.subList(0,19);
        }
        else if(allReviews.size() == 0){
            reviews = new ArrayList<PlaceReviewEntity>();
        }
        else {
            reviews = allReviews;
        }

        if(!details.isEmpty()){
            isFavourite = true;
            System.out.println(details.get().getPlace_id());
        }

    }
}
