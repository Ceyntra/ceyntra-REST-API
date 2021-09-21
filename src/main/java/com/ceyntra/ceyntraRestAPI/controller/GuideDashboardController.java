package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.BannedGuideEntity;
import com.ceyntra.ceyntraRestAPI.entity.GuideEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.BriefDetailsModel;
import com.ceyntra.ceyntraRestAPI.model.UserAndGuideModel;
import com.ceyntra.ceyntraRestAPI.model.UserContactModel;
import com.ceyntra.ceyntraRestAPI.repository.BannedGuideRepository;
import com.ceyntra.ceyntraRestAPI.repository.GuideRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import com.ceyntra.ceyntraRestAPI.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class GuideDashboardController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GuideRepository guideRepository;

    @Autowired
    BannedGuideRepository bannedGuideRepository;

    @Autowired
    EmailService emailService;

    @GetMapping("/getGuideData")
    public List<Object> getCount(){
        List<Object> dataList=new ArrayList<>();
        int count = guideRepository.getGuideCount();
        int requestCount = guideRepository.getRequestCount();
        dataList.add(count);
        dataList.add(requestCount);
        List<Object> top=guideRepository.getTopFive();
        dataList.add(top);
        List<BannedGuideEntity> bannedGuide=bannedGuideRepository.findAll();
        dataList.add(bannedGuide);
        return dataList;
    }

    @GetMapping("/getGuideBriefDetails")
    public List<BriefDetailsModel> getGuideBriefDetails(){

        List<BriefDetailsModel> briefDetailsModelAll = new ArrayList<>();

        List<GuideEntity> guideList=guideRepository.getRegisteredGuides();

        for (int i=0; i<guideList.size(); i++){
            Optional<UserEntity> user = userRepository.findById(guideList.get(i).getGuide_id());
            UserContactModel userContactModel = new UserContactModel();
            userContactModel.setEmail(user.get().getEmail());
            userContactModel.setTelephone(user.get().getTelephone());
            briefDetailsModelAll.add(new BriefDetailsModel(guideList.get(i).getGuide_id(), (guideList.get(i).getFirst_name()+' '+guideList.get(i).getLast_name()), guideList.get(i).getDistrict(), userContactModel));
        }
        return briefDetailsModelAll;
    }

    @PutMapping("/approveGuideRequest/{id}")
    public int approveGuideRequest(@PathVariable int id){
        int result=guideRepository.approveGuide(id);
        String mail=userRepository.getHotelEmail(id);
        String body = "Congratulations! Your account has been approved by the CeynTra team. Start your services and thank you for choosing CeynTra.";
        emailService.sendEmail(mail, body, "Account Approved");
        return result;
    }

    @DeleteMapping("/rejectGuideRequest/{id}")
    public int rejectGuideRequest(@PathVariable int id){
        String mail=userRepository.getHotelEmail(id);
        userRepository.deleteById(id);
        guideRepository.deleteById(id);
        String body = "Sorry... Your account has been rejected by the CeynTra team. Check and input valid account details and try to join the CeynTra group.";
        emailService.sendEmail(mail, body, "Account Rejected");
        if(userRepository.existsById(id) || guideRepository.existsById(id)){
            return 0;
        }else{
            return 1;
        }
    }

    @GetMapping("/getGuides/{district}")
    public List<UserAndGuideModel> getGuideDetails(@PathVariable String district){

        List<UserAndGuideModel> userAndGuideModelAll = new ArrayList<>();

        List<GuideEntity> guideList=guideRepository.getDistrictGuides(district);

        for (int i=0; i<guideList.size(); i++){
            Optional<UserEntity> user = userRepository.findById(guideList.get(i).getGuide_id());
            UserContactModel userContactModel = new UserContactModel();
            userContactModel.setEmail(user.get().getEmail());
            userContactModel.setTelephone(user.get().getTelephone());
            userAndGuideModelAll.add(new UserAndGuideModel(guideList.get(i), userContactModel));
        }
        return userAndGuideModelAll;
    }

    @PostMapping("/bannedGuide/{id}")
    public int banGuide(@PathVariable int id){
        UserEntity user=userRepository.getById(id);
        GuideEntity guide=guideRepository.getById(id);
        userRepository.deleteById(id);
        guideRepository.deleteById(id);
        BannedGuideEntity bannedGuideEntity=new BannedGuideEntity(guide.getFirst_name(), guide.getLast_name(), guide.getNic(),
                guide.getDistrict(), user.getEmail(), user.getTelephone(), guide.getRating(), guide.getProfile_photo());
        bannedGuideRepository.save(bannedGuideEntity);
        if(userRepository.existsById(id) || guideRepository.existsById(id)){
            return 0;
        }else{
            return 1;
        }
    }
}
