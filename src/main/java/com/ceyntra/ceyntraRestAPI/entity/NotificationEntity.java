package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="notification")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int chatRoomID;
    private String message;
    private Date timeStamp;
    private int spID;

    public NotificationEntity() {
    }

    public NotificationEntity(int id, int chatRoomID, String message, Date timeStamp,int spID) {
        this.id = id;
        this.chatRoomID = chatRoomID;
        this.message = message;
        this.timeStamp = timeStamp;
        this.spID=spID;
    }

    @Override
    public String toString() {
        return "NotificationEntity{" +
                "id=" + id +
                ", userID=" + chatRoomID +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }

    public int getChatRoomID() {
        return chatRoomID;
    }

    public void setChatRoomID(int chatRoomID) {
        this.chatRoomID = chatRoomID;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getSpID() {
        return spID;
    }

    public void setSpID(int spID) {
        this.spID = spID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return chatRoomID;
    }

    public void setUserID(int userID) {
        this.chatRoomID = userID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }
}
