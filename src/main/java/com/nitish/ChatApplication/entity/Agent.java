package com.nitish.ChatApplication.entity;

import javax.persistence.*;

@Entity
@Table(name = "AGENT")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long agentId;

    @Column(name = "name")
    private String name;

    public long getAgentId() {
        return agentId;
    }

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


//CREATE TABLE AGENT (
//    agentId VARCHAR(20) PRIMARY KEY,
//    name VARCHAR(20) NOT NULL
//)
