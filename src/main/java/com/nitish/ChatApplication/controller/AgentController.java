package com.nitish.ChatApplication.controller;

import com.nitish.ChatApplication.entity.Agent;
import com.nitish.ChatApplication.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;

    @GetMapping("/login/{agentId}")
    public ResponseEntity<Agent> login(@PathVariable long agentId) {
        Agent agent = agentRepository.getByAgentId(agentId);
        if(agent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(agent, HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public ResponseEntity<Agent> register(@RequestBody Agent agent) {
        try {
            Agent _agent = agentRepository.save(agent);
            return new ResponseEntity<>(_agent, HttpStatus.CREATED);
        } catch(Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
