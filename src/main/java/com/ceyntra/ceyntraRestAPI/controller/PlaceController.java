package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.*;
import com.ceyntra.ceyntraRestAPI.model.*;
import com.ceyntra.ceyntraRestAPI.repository.*;
import com.ceyntra.ceyntraRestAPI.service.TravellingPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    PlacePhotoRepository placePhotoRepository;


    @PostMapping("/getAllPlaces")
    public List<TravellingPlaceEntity> getAllPlaces(@RequestBody CoordinatesModel currentPlaceCoordinates) throws IOException, InterruptedException {
        List<TravellingPlaceEntity> currentLocationAvailablePlaces = new ArrayList<>();
        List<TravellingPlaceEntity> placeModelList = travellingPlaceRepository.getPlacesAndSortByRating();
        int distance = 0;

        CoordinatesModel anotherPlaceCoordinates = new CoordinatesModel();

        for (int i = 0; i< placeModelList.size(); i++){
            anotherPlaceCoordinates.setLatitude(placeModelList.get(i).getLatitude());
            anotherPlaceCoordinates.setLongitude(placeModelList.get(i).getLongitude());

            distance = travellingPlaceService.calculateDistanceBetweenTwoPlaces(currentPlaceCoordinates, anotherPlaceCoordinates);

            if(distance < 50){
                currentLocationAvailablePlaces.add(placeModelList.get(i));
            }

        }


    return currentLocationAvailablePlaces;
    }


//    dont delete upper commented function, this is dummy function and upper commented function is the real function with API.
//    @PostMapping("/getAllPlaces")
//    public List<TravellingPlaceEntity> getAllPlaces(@RequestBody CoordinatesModel currentPlaceCoordinates) throws IOException, InterruptedException {
//        List<TravellingPlaceEntity> currentLocationAvailablePlaces = new ArrayList<>();
//        List<TravellingPlaceEntity> placeModelList = travellingPlaceRepository.getPlacesAndSortByRating();
//
//
//        CoordinatesModel anotherPlaceCoordinates = new CoordinatesModel();
//
//        for (int i = 0; i< placeModelList.size(); i++){
//            anotherPlaceCoordinates.setLatitude(placeModelList.get(i).getLatitude());
//            anotherPlaceCoordinates.setLongitude(placeModelList.get(i).getLongitude());
//
//                currentLocationAvailablePlaces.add(placeModelList.get(i));
//
//
//        }
//
//
//        return currentLocationAvailablePlaces;
//    }


        @GetMapping("/getPlaceByPlaceName/{place}")
        public TravellingPlaceEntity getPlaceByPlaceName(@PathVariable("place") String place){
            List<TravellingPlaceEntity> travellingPlaceEntityList = travellingPlaceRepository.getPlaceByPlaceName(place);

            return travellingPlaceEntityList.get(0);


        }

    @PostMapping("/getMetadataInPlace")
    public GetMetaDataPlaceModel getMetadataInPlace(@RequestBody UserPlaceId userPlaceId){
        boolean isFavourite = false;
        double myRating = 0.0;
        double placeRating = 0.0;
        int numOfVotesForPlace = 0;
        List<PlaceReviewEntity> reviews = new ArrayList<PlaceReviewEntity>();
        List<UserAndReviewModel> userAndReviewModels = new ArrayList<>();

        Optional<TravellerFavPlaceEntity> details = travellerFavPlaceRepository.findById(userPlaceId);
        List<PlaceReviewEntity> allReviews = placeReviewRepository.getAllReviews(userPlaceId.getPlace_id());
        Optional<PlaceRatingEntity> placeRatingEntity = placeRatingRepository.findById(userPlaceId);
        List<String> placePhotoEntityList = placePhotoRepository.getAllPhotosOfPlace(userPlaceId.getPlace_id());

//setup myRatings
        if(placeRatingEntity.isPresent()){
            myRating = placeRatingEntity.get().getRating();
        }

//        setup reviews
        if(allReviews.size() != 0){


                reviews = allReviews;


            for(int i=0; i< reviews.size();i++){

                TravellerEntity userDetails = travellerRepository.findById(reviews.get(i).getUser_id()).get();
                PlaceRatingEntity ratingDetails = placeRatingRepository.findById(new UserPlaceId(reviews.get(i).getUser_id(), userPlaceId.getPlace_id())).get();
                userAndReviewModels.add(new UserAndReviewModel(reviews.get(i), userDetails, ratingDetails.getRating()));

            }
        }


//        calculate place overall rating
        List<PlaceRatingEntity> ratingEntityList = placeRatingRepository.gePlaceRatingByPlaceId(userPlaceId.getPlace_id());
        if(!ratingEntityList.isEmpty()){
            double sum = 0;
            numOfVotesForPlace = ratingEntityList.size();
            for (int i =0; i<ratingEntityList.size(); i++){
                sum = sum + ratingEntityList.get(i).getRating();
            }

            placeRating = sum/ratingEntityList.size();

            travellingPlaceRepository.updateRatingAndVotes(placeRating, numOfVotesForPlace, userPlaceId.getPlace_id());
        }

// user favourite
        if(!details.isEmpty()){
            isFavourite = true;
        }

        GetMetaDataPlaceModel metaData = new GetMetaDataPlaceModel(isFavourite,myRating, userAndReviewModels, numOfVotesForPlace, placeRating , placePhotoEntityList);
         return metaData;
    }

    @PostMapping("/updateFavouritePlace")
    public void updateFavouritePlace(@RequestBody FavouritePlaceUpdateModel model){


        if(model.isFavouriteStatus()){
            System.out.println("saved");
            travellerFavPlaceRepository.save(new TravellerFavPlaceEntity(model.getUserId(), model.getPlaceId()));
        }
        else{
            System.out.println("deleted");
            travellerFavPlaceRepository.deleteById(new UserPlaceId(model.getUserId(), model.getPlaceId()));
        }
    }

    @PostMapping("/addReview")
    public int addReviewAndUpdateRating(@RequestBody AddReviewModel addReviewModel){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(addReviewModel.getComment() + addReviewModel.getRating());
        PlaceReviewEntity reviewEntity = placeReviewRepository.save(new PlaceReviewEntity(addReviewModel.getUserId(), addReviewModel.getPlaceId(), addReviewModel.getComment(), timestamp));
        if(reviewEntity.getComment() != null){
          Optional<PlaceRatingEntity> ratingEntity =  placeRatingRepository.findById(new UserPlaceId(addReviewModel.getUserId(), addReviewModel.getPlaceId()));
          if(ratingEntity.isPresent()){
              placeRatingRepository.updateRating(addReviewModel.getRating(), addReviewModel.getUserId(), addReviewModel.getPlaceId());
          } else{
              placeRatingRepository.save(new PlaceRatingEntity(addReviewModel.getUserId(), addReviewModel.getPlaceId(), addReviewModel.getRating()));
          }

          return 1;
        }
        return 0;
    }

    @GetMapping("/getTopPlacePhotos/{id}")
    public List<String> getTopPlacePhotos(@PathVariable("id") int id){
        List<String> photoList = placePhotoRepository.getAllPhotosOfPlace(id);

        return photoList;
    }


}
