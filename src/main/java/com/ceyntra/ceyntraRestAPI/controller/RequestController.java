package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.NotificationEntity;
import com.ceyntra.ceyntraRestAPI.entity.TravellerRequestEntity;
import com.ceyntra.ceyntraRestAPI.entity.chat.ChatMessage;
import com.ceyntra.ceyntraRestAPI.entity.chat.ChatRoom;
import com.ceyntra.ceyntraRestAPI.model.TravellerRequestModel;
import com.ceyntra.ceyntraRestAPI.repository.NotificationRepository;
import com.ceyntra.ceyntraRestAPI.repository.TravellerRequestRepository;
import com.ceyntra.ceyntraRestAPI.repository.chat.ChatRoomRepository;
import com.ceyntra.ceyntraRestAPI.repository.chat.PrivateChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class RequestController {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private PrivateChatMessageRepository messageRepository;

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @Autowired
    private TravellerRequestRepository travellerRequestRepository;


    @PostMapping("/requestPackage")
    public ResponseEntity<TravellerRequestEntity> requestPackage(@RequestBody TravellerRequestModel requestModel){

        System.out.println(requestModel.toString());

        //2)Add to chat table
        String msg=requestModel.getPackageType().toUpperCase() +" Package Request : " + requestModel.getPackageName()+" sent.";
        ChatMessage req= sendRequestToChat(new ChatMessage(0,requestModel.getTravellerId(),requestModel.getSpId(),msg,null,null));

        //1)Add to notification
        NotificationEntity notificaton=new NotificationEntity(0,req.getChatRoom().getChatRoomId(),"You have new request for "+requestModel.getPackageName(), new Date());
        notificationRepository.save(notificaton);

        //1)Add to request table
        TravellerRequestEntity travellerRequest=travellerRequestRepository.save(new TravellerRequestEntity(0,requestModel.getPackageId(),requestModel.getTravellerId(),requestModel.getTimestamp(),false,requestModel.getSpId(),req.getChatRoom().getChatRoomId(),requestModel.getPackageType()));

        if(travellerRequest==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TravellerRequestEntity());
        }
        return ResponseEntity.ok(travellerRequest);
    }

    public ChatMessage sendRequestToChat(ChatMessage message){

        //Get the chat room for users
        ChatRoom chatRoom=chatRoomRepository.getChatRoomByUsers(message.getSenderId(),message.getRecipientId());

        if(chatRoom == null){
            //Create a chat room
            System.out.println("No chat room. Create a new one");

            chatRoom=new ChatRoom();
            chatRoom.setSenderId(message.getSenderId());
            chatRoom.setRecipientId(message.getRecipientId());
            chatRoom=chatRoomRepository.save(chatRoom);
        }

        //Add timeStamp
        message.setTimestamp(new Date());

        //Complete the Chat MessageModel   {'id': 0,'senderId': chatMessage.senderID,'recipientId': 603,,'content': chatMessage.content,'timestamp':''}
        message.setChatRoom(chatRoom);

        ChatMessage msg=messageRepository.save(message);

        return msg;
    }

    @DeleteMapping("deleteNotification/{chatRoomID}")
    public List<NotificationEntity> deleteNotification(@PathVariable int chatRoomID){
        List<NotificationEntity> notificaton=notificationRepository.deleteNotificationEntitiesByChatRoomID(chatRoomID);
        return notificaton;
    }
    

}
