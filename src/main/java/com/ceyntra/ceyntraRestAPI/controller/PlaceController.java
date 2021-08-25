package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.*;
import com.ceyntra.ceyntraRestAPI.model.*;
import com.ceyntra.ceyntraRestAPI.repository.*;
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
    @Autowired
    UserRepository userRepository;
    @Autowired
    TravellerRepository travellerRepository;
    @Autowired
    PlaceRatingRepository placeRatingRepository;


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
    public GetMetaDataPlaceModel getMetadataInPlace(@RequestBody UserPlaceId userPlaceId){
        boolean isFavourite = false;
        double myRating = 0.0;
        List<PlaceReviewEntity> reviews = new ArrayList<PlaceReviewEntity>();
        List<UserAndReviewModel> userAndReviewModels = new ArrayList<>();

        Optional<TravellerFavEntity> details = travellerFavPlaceRepository.findById(userPlaceId);
        List<PlaceReviewEntity> allReviews = placeReviewRepository.getAllReviews(userPlaceId.getPlace_id());
        Optional<PlaceRatingEntity> placeRatingEntity = placeRatingRepository.findById(userPlaceId);

        if(placeRatingEntity.isPresent()){
            myRating = placeRatingEntity.get().getRating();
        }

        if(allReviews.size() != 0){


                reviews = allReviews;


            for(int i=0; i< reviews.size();i++){

                TravellerEntity userDetails = travellerRepository.findById(reviews.get(i).getUser_id()).get();
                PlaceRatingEntity ratingDetails = placeRatingRepository.findById(new UserPlaceId(reviews.get(i).getUser_id(), userPlaceId.getPlace_id())).get();
                userAndReviewModels.add(new UserAndReviewModel(reviews.get(i), userDetails, ratingDetails.getRating()));

            }
        }

// user favourite
        if(!details.isEmpty()){
            isFavourite = true;
        }

        GetMetaDataPlaceModel metaData = new GetMetaDataPlaceModel(isFavourite,myRating, userAndReviewModels );
         return metaData;
    }
}
