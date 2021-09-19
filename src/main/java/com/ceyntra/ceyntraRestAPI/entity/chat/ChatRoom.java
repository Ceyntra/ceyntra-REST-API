package com.ceyntra.ceyntraRestAPI.entity.chat;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "chatroom")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatRoomId;
    private int senderId;
    private int recipientId;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chatRoom",targetEntity = ChatMessage.class,fetch = FetchType.LAZY)
    private Set<ChatMessage> chatMessageSet = new HashSet<ChatMessage>();

    public ChatRoom() {
    }

    public ChatRoom(int chatRoomId, int senderId, int recipientId, Set<ChatMessage> chatMessageSet) {
        this.chatRoomId = chatRoomId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.chatMessageSet = chatMessageSet;
    }

    public int getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(int chatRoomId) {
        this.chatRoomId = chatRoomId;
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

    public Set<ChatMessage> getChatMessageSet() {
        return chatMessageSet;
    }

    public void setChatMessageSet(Set<ChatMessage> chatMessageSet) {
        this.chatMessageSet = chatMessageSet;
    }
}