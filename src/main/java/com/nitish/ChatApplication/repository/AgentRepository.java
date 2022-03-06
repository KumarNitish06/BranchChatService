package com.nitish.ChatApplication.repository;

import com.nitish.ChatApplication.entity.Agent;
import com.nitish.ChatApplication.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    Agent getByAgentId(long agentId);
}
