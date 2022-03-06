package com.nitish.ChatApplication.entity;

import javax.persistence.*;

@Entity
@Table(name = "XWINDOW")
public class Window {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "agent_id")
    private String agentId;

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

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}

//CREATE TABLE WINDOW (
//    id INT AUTO_INCREMENT  PRIMARY KEY,
//    userId VARCHAR(20) FOREIGN KEY REFERENCES USER(userId) NOT NULL,
//    agentId INT FOREIGN KEY REFERENCES AGENT(agentId)
//)