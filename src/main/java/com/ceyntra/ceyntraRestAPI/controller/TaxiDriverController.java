package com.ceyntra.ceyntraRestAPI.controller;


import com.ceyntra.ceyntraRestAPI.entity.*;
import com.ceyntra.ceyntraRestAPI.model.CoordinatesModel;
import com.ceyntra.ceyntraRestAPI.model.GetMetaDataPlaceModel;
import com.ceyntra.ceyntraRestAPI.model.UserAndReviewModel;
import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;
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
import java.util.Optional;

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



//    @PostMapping("/getMetadataInTaxi")
//    public GetMetaDataPlaceModel getMetadataInPlace(@RequestBody UserPlaceId userPlaceId){
//        boolean isFavourite = false;
//        double myRating = 0.0;
//        double placeRating = 0.0;
//        int numOfVotesForPlace = 0;
//        List<PlaceReviewEntity> reviews = new ArrayList<PlaceReviewEntity>();
//        List<UserAndReviewModel> userAndReviewModels = new ArrayList<>();
//
//
//        Optional<TravellerFavPlaceEntity> details = travellerFavPlaceRepository.findById(userPlaceId);
//        List<PlaceReviewEntity> allReviews = placeReviewRepository.getAllReviews(userPlaceId.getPlace_id());
//        Optional<PlaceRatingEntity> placeRatingEntity = placeRatingRepository.findById(userPlaceId);
//        List<String> placePhotoEntityList = placePhotoRepository.getAllPhotosOfPlace(userPlaceId.getPlace_id());
//
//
////setup myRatings
//        if(placeRatingEntity.isPresent()){
//            myRating = placeRatingEntity.get().getRating();
//        }
//
////        setup reviews
//        if(allReviews.size() != 0){
//
//
//            reviews = allReviews;
//
//
//            for(int i=0; i< reviews.size();i++){
//
//                TravellerEntity userDetails = travellerRepository.findById(reviews.get(i).getUser_id()).get();
//                PlaceRatingEntity ratingDetails = placeRatingRepository.findById(new UserPlaceId(reviews.get(i).getUser_id(), userPlaceId.getPlace_id())).get();
//                userAndReviewModels.add(new UserAndReviewModel(reviews.get(i), userDetails, ratingDetails.getRating()));
//
//            }
//        }
//
//
////        calculate place overall rating
//        List<PlaceRatingEntity> ratingEntityList = placeRatingRepository.gePlaceRatingByPlaceId(userPlaceId.getPlace_id());
//        if(!ratingEntityList.isEmpty()){
//            double sum = 0;
//            numOfVotesForPlace = ratingEntityList.size();
//            for (int i =0; i<ratingEntityList.size(); i++){
//                sum = sum + ratingEntityList.get(i).getRating();
//            }
//
//            placeRating = sum/ratingEntityList.size();
//
//            travellingPlaceRepository.updateRatingAndVotes(placeRating, numOfVotesForPlace, userPlaceId.getPlace_id());
//        }
//
//// user favourite
//        if(!details.isEmpty()){
//            isFavourite = true;
//        }
//
//        GetMetaDataPlaceModel metaData = new GetMetaDataPlaceModel(isFavourite,myRating, userAndReviewModels, numOfVotesForPlace, placeRating , placePhotoEntityList);
//        return metaData;
//    }
}
