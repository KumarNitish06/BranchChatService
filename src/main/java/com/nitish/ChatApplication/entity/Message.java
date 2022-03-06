package com.nitish.ChatApplication.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "MESSAGE")
public class Message implements Comparable<Message>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "is_user_message")
    private boolean isUserMessage;

    @Column(name = "agent_id")
    private String agentId;

    @Column(name = "message")
    private String message;

    @Column(name = "message_time")
    private Timestamp messageTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isUserMessage() {
        return isUserMessage;
    }

    public void setUserMessage(boolean userMessage) {
        isUserMessage = userMessage;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Timestamp messageTime) {
        this.messageTime = messageTime;
    }

    @Override
    public int compareTo(Message o) {
        if(getMessageTime().before(o.getMessageTime()))
            return -1;
        else
            return 1;
    }
}

