package com.ceyntra.ceyntraRestAPI.controller;


import com.ceyntra.ceyntraRestAPI.entity.*;
import com.ceyntra.ceyntraRestAPI.model.*;
import com.ceyntra.ceyntraRestAPI.repository.*;
import com.ceyntra.ceyntraRestAPI.service.TravellingPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class SpController {


    @Autowired
    TravellingPlaceService travellingPlaceService;
    @Autowired
    TravellerFavSpRepository travellerFavSpRepository;
    @Autowired
    SpReviewRepository spReviewRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TravellerRepository travellerRepository;
    @Autowired
    SpRatingRepository spRatingRepository;
    @Autowired
    TaxiDriverRepository taxiDriverRepository;
    @Autowired
    HotelPhotoRepository hotelPhotoRepository;
    @Autowired
    GuideRepository guideRepository;
    @Autowired
    HotelRepository hotelRepository;





    @PostMapping("/getAllTaxisForLocation")
    public List<TaxiDriverEntity> getAllPlaces(@RequestBody CoordinatesModel currentPlaceCoordinates) throws IOException, InterruptedException {
        List<TaxiDriverEntity> currentLocationAvailableTaxis = new ArrayList<>();
        List<TaxiDriverEntity> allTaxiDriverList = taxiDriverRepository.getAllTaxiDriversAndSortByRating();

        int distance = 0;


        CoordinatesModel anotherPlaceCoordinates = new CoordinatesModel();

        for (int i = 0; i< allTaxiDriverList.size(); i++){
            anotherPlaceCoordinates.setLatitude(allTaxiDriverList.get(i).getWorking_latitude());
            anotherPlaceCoordinates.setLongitude(allTaxiDriverList.get(i).getWorking_longitude());

            distance = travellingPlaceService.calculateDistanceBetweenTwoPlaces(currentPlaceCoordinates, anotherPlaceCoordinates);

            if(distance < 50){
                currentLocationAvailableTaxis.add(allTaxiDriverList.get(i));
            }



        }


        return currentLocationAvailableTaxis;
    }

    @PostMapping("/getAllHotelsForLocation")
    public List<HotelEntity> getAllHotels(@RequestBody CoordinatesModel currentPlaceCoordinates) throws IOException, InterruptedException {
        List<HotelEntity> currentLocationAvailableHotels = new ArrayList<>();
        List<HotelEntity> allHotelList = hotelRepository.getAllHotelsAndSortByRating();

        int distance = 0;


        CoordinatesModel anotherPlaceCoordinates = new CoordinatesModel();

        for (int i = 0; i< allHotelList.size(); i++){
            anotherPlaceCoordinates.setLatitude(allHotelList.get(i).getLatitude());
            anotherPlaceCoordinates.setLongitude(allHotelList.get(i).getLongitude());

            distance = travellingPlaceService.calculateDistanceBetweenTwoPlaces(currentPlaceCoordinates, anotherPlaceCoordinates);

            if(distance < 50){
                currentLocationAvailableHotels.add(allHotelList.get(i));
            }



        }


        return currentLocationAvailableHotels;
    }

    @PostMapping("/getAllGuidesForLocation")
    public List<GuideEntity> getAllGuides(@RequestBody CoordinatesModel currentPlaceCoordinates) throws IOException, InterruptedException {
        List<GuideEntity> currentLocationAvailableGuides = new ArrayList<>();
        List<GuideEntity> allGuideList = guideRepository.getAllGuidesAndSortByRating();

        int distance = 0;


        CoordinatesModel anotherPlaceCoordinates = new CoordinatesModel();

        for (int i = 0; i< allGuideList.size(); i++){
            anotherPlaceCoordinates.setLatitude(allGuideList.get(i).getLatitude());
            anotherPlaceCoordinates.setLongitude(allGuideList.get(i).getLongitude());

            distance = travellingPlaceService.calculateDistanceBetweenTwoPlaces(currentPlaceCoordinates, anotherPlaceCoordinates);

            if(distance < 50){
                currentLocationAvailableGuides.add(allGuideList.get(i));
            }



        }


        return currentLocationAvailableGuides;
    }



    @PostMapping("/getMetadataInSp")
    public GetMetaDataPlaceModel getMetadataInSp(@RequestBody TravellerSpId travellerSpId ){
        boolean isFavourite = false;
        double myRating = 0.0;
        double spRating = 0.0;
        int numOfVotesForSp = 0;
        List<SpReviewEntity> reviews = new ArrayList<SpReviewEntity>();
        List<UserAndReviewModel> userAndReviewModels = new ArrayList<>();

        int userType = userRepository.findById(travellerSpId.getSp_id()).get().getUserType();

        Optional<TravellerFavSpEntity> details = travellerFavSpRepository.findById(travellerSpId);
        List<SpReviewEntity> allReviews = spReviewRepository.getAllReviews(travellerSpId.getSp_id());
        Optional<SpRatingEntity> spRatingEntity = spRatingRepository.findById(travellerSpId);
        List<String> hotelPhotoEntityList = hotelPhotoRepository.getAllPhotosOfHotel(travellerSpId.getSp_id());



//setup myRatings
        if(spRatingEntity.isPresent()){
            myRating = spRatingEntity.get().getRating();
        }

//        setup reviews
        if(allReviews.size() != 0){
            reviews = allReviews;
            for(int i=0; i< reviews.size();i++){

                TravellerEntity userDetails = travellerRepository.findById(reviews.get(i).getUser_id()).get();
                SpRatingEntity ratingDetails = spRatingRepository.findById(new TravellerSpId(reviews.get(i).getUser_id(), travellerSpId.getSp_id())).get();
                userAndReviewModels.add(new UserAndReviewModel(reviews.get(i), userDetails, ratingDetails.getRating()));

            }
        }


//        calculate place overall rating
        List<SpRatingEntity> ratingEntityList = spRatingRepository.geSpRatingBySpId(travellerSpId.getSp_id());
        if(!ratingEntityList.isEmpty()){
            double sum = 0;
            numOfVotesForSp = ratingEntityList.size();
            for (int i =0; i<ratingEntityList.size(); i++){
                sum = sum + ratingEntityList.get(i).getRating();
            }

            spRating = sum/ratingEntityList.size();
            System.out.println(spRating);

            if(userType == 3){
                taxiDriverRepository.updateRatingAndVotes(spRating, numOfVotesForSp, travellerSpId.getSp_id());
            }
            else if(userType ==2){
                hotelRepository.updateRatingAndVotes(spRating, numOfVotesForSp, travellerSpId.getSp_id());
            }
            else if(userType ==1){
                guideRepository.updateRatingAndVotes(spRating, numOfVotesForSp, travellerSpId.getSp_id());
            }


        }

// user favourite
        if(!details.isEmpty()){
            isFavourite = true;
        }

        GetMetaDataPlaceModel metaData = new GetMetaDataPlaceModel(isFavourite,myRating, userAndReviewModels, numOfVotesForSp, spRating, hotelPhotoEntityList);
        return metaData;
    }


    @PostMapping("/addReviewToSp")
    public int addReviewAndUpdateRating(@RequestBody AddReviewModel addReviewModel){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(addReviewModel.getComment() + addReviewModel.getRating());
        SpReviewEntity reviewEntity = spReviewRepository.save(new SpReviewEntity(addReviewModel.getUserId(), addReviewModel.getPlaceId(), addReviewModel.getComment(), timestamp));
        if(reviewEntity.getComment() != null){
            Optional<SpRatingEntity> ratingEntity =  spRatingRepository.findById(new TravellerSpId(addReviewModel.getUserId(), addReviewModel.getPlaceId()));
            if(ratingEntity.isPresent()){
                spRatingRepository.updateRating(addReviewModel.getRating(),  addReviewModel.getPlaceId(), addReviewModel.getUserId());
            } else{
                spRatingRepository.save(new SpRatingEntity(addReviewModel.getUserId(), addReviewModel.getPlaceId(), addReviewModel.getRating()));
            }

            return 1;
        }
        return 0;
    }

    @PostMapping("/updateFavouriteSp")
    public void updateFavouritePlace(@RequestBody FavouritePlaceUpdateModel model){


        if(model.isFavouriteStatus()){
            System.out.println("saved");
            travellerFavSpRepository.save(new TravellerFavSpEntity(model.getUserId(), model.getPlaceId()));
        }
        else{
            System.out.println("deleted");
            travellerFavSpRepository.deleteById(new TravellerSpId(model.getUserId(), model.getPlaceId()));
        }
    }

}
