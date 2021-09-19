package com.ceyntra.ceyntraRestAPI.repository.chat;

import com.ceyntra.ceyntraRestAPI.entity.chat.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom,Integer> {

   // ChatRoom getChatRoomBySenderIdAndRecipientId(String senderId,String recipientId);


    @Query("Select r from ChatRoom r where (r.recipientId=:user1 and r.senderId=:user2) OR r.recipientId=:user2 and r.senderId=:user1")
    ChatRoom getChatRoomByUsers(@Param("user1") int user1, @Param("user2") int user2);


    String getChatIdBySenderIdAndRecipientId(String senderId,String recipientId);

    @Query("select c from ChatRoom c where c.senderId=:userId OR c.recipientId =:userId")
    List<ChatRoom> findChatRoomByUserId(@Param("userId") int userId);




}
