package com.nitish.ChatApplication.controller;

import com.nitish.ChatApplication.entity.Agent;
import com.nitish.ChatApplication.entity.Window;
import com.nitish.ChatApplication.repository.WindowRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/window")
public class WindowController {

    @Autowired
    private WindowRepository windowRepository;

    @GetMapping("/unresolved")
    public List<Window> getUnresolvedMessage() {
        List<Window> windowList = Collections.emptyList();
        try {
            windowList = windowRepository.findByAgentId(null);
        } catch (Exception ex) {
            System.out.println("Exception in getting open chats" + ExceptionUtils.getStackTrace(ex));
        }
        return windowList;
    }

    @PutMapping("/assignAgent")
    public ResponseEntity<Window> updateWindow(@RequestBody Window _window) {
        ResponseEntity<Window> responseEntity;
        try {
            String userId = _window.getUserId();
            String agentId = _window.getAgentId();
            Window window = windowRepository.findByUserId(userId);
            window.setAgentId(agentId);
            windowRepository.save(window);
            responseEntity = new ResponseEntity<>(window, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Exception in assigning agents to a chat" + ExceptionUtils.getStackTrace(ex));
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
