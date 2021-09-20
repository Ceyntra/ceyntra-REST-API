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

    public NotificationEntity() {
    }

    public NotificationEntity(int id, int chatRoomID, String message, Date timeStamp) {
        this.id = id;
        this.chatRoomID = chatRoomID;
        this.message = message;
        this.timeStamp = timeStamp;
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
