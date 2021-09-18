package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.*;
import com.ceyntra.ceyntraRestAPI.model.TravellerActivityModel;
import com.ceyntra.ceyntraRestAPI.model.TravellerViewModel;
import com.ceyntra.ceyntraRestAPI.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class TravellerController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TravellerRepository travellerRepository;

    @Autowired
    private TravellerRequestRepository travellerRequestRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private TaxiDriverRepository taxiDriverRepository;

    @Autowired
    private GuideRepository guideRepository;


    @GetMapping("/getTravellersForAdmin")
    public List<TravellerViewModel> getTravellerByID(){

        List<TravellerEntity> travellerEntities=travellerRepository.findAll();
        List<TravellerViewModel> travellerViewModels=new ArrayList<TravellerViewModel>();

        travellerEntities.forEach(travellerEntity -> {
            Optional<UserEntity> user=userRepository.findById(travellerEntity.getUserID());
            //add both
            travellerViewModels.add(new TravellerViewModel(user.get(),travellerEntity));
        });

        return travellerViewModels;
    }

    //Get traveller recent Activities(Requests) by userID
    @GetMapping("/getActivities/{userID}")
    public List<TravellerActivityModel> getTravellerActivities(@PathVariable("userID") int userID){

        List<TravellerActivityModel > travellerActivityModels=new ArrayList<TravellerActivityModel>();

        List<TravellerRequestEntity> requestEntities=travellerRequestRepository.getTravellerRequestEntitiesByTraveller_id(userID);

        requestEntities.forEach(travellerRequest ->{

            TravellerActivityModel travellerActivityModel=new TravellerActivityModel();

            //Set Package Type
            travellerActivityModel.setPackageType(travellerRequest.getPackage_type());
            //Set package ID
            travellerActivityModel.setPackageID(travellerRequest.getPackage_id());
            //Set package Time stamp
            travellerActivityModel.setDate(""+travellerRequest.getTimestamp().toLocalDateTime().getMonth()+"  "+travellerRequest.getTimestamp().toLocalDateTime().getDayOfMonth()+","+travellerRequest.getTimestamp().toLocalDateTime().getYear());
//            travellerActivityModel.setTime(""+travellerRequest.getTimestamp().toLocalDateTime().getHour()+":"+travellerRequest.getTimestamp().toLocalDateTime().getMinute()+" "+travellerRequest.getTimestamp().toLocalDateTime().get());
           travellerActivityModel.setTime(""+travellerRequest.getTimestamp().toLocalDateTime().format(DateTimeFormatter.ofPattern("hh:mm a")));

            if(travellerRequest.getPackage_type().equals("taxi")){

                TaxiDriverEntity taxiDriverEntity=taxiDriverRepository.getTaxiDriverEntityByTaxi_driver_id(travellerRequest.getSp_id());
                //Set SP Name
                travellerActivityModel.setSpName(taxiDriverEntity.getFirst_name()+" "+taxiDriverEntity.getLast_name());

            }else if(travellerRequest.getPackage_type().equals("hotel")){

                HotelEntity hotelEntity=hotelRepository.getHotelEntityByHotel_id(travellerRequest.getSp_id());
                //Set SP Name
                travellerActivityModel.setSpName(hotelEntity.getName());


            }
            else if(travellerRequest.getPackage_type().equals("guide")){

                GuideEntity guideEntity=guideRepository.getGuideEntityByGuide_id(travellerRequest.getSp_id());
                //Set SP Name
                travellerActivityModel.setSpName(guideEntity.getFirst_name()+" "+guideEntity.getLast_name());
            }

            travellerActivityModels.add(travellerActivityModel);

        });

        return travellerActivityModels;
    }




}
