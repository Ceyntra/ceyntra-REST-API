package com.ceyntra.ceyntraRestAPI.entity.chat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chatMessage")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int senderId; //
    private int recipientId; //
    private String content; //
    private Date timestamp; //

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "chatRoomId")
    private ChatRoom chatRoom;

    public ChatMessage() {
    }

    public ChatMessage(int id, int senderId, int recipientId, String content, Date timestamp, ChatRoom chatRoom) {
        this.id = id;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.content = content;
        this.timestamp = timestamp;
        this.chatRoom = chatRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }
}
