package com.nitish.ChatApplication.controller;

import com.nitish.ChatApplication.entity.Message;
import com.nitish.ChatApplication.repository.MessageRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/loadChat/{uid}")
    private List<Message> loadUserChat(@PathVariable String uid) {
        List<Message> messageList = Collections.emptyList();
        try {
            messageList = messageRepository.findByUserId(uid);
            Collections.sort(messageList);
        } catch(Exception ex) {
            System.out.println("Exception in fetching userChat history." + ExceptionUtils.getStackTrace(ex));
        }
        return messageList;
    }

    @PostMapping("/sendMessage")
    private ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        ResponseEntity<Message> responseEntity;
        try {
            messageRepository.save(message);
            responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
        } catch(Exception ex) {
            System.out.println("Exception in fetching sending message" + ExceptionUtils.getStackTrace(ex));
            responseEntity = null;
        }
        return responseEntity;
    }
}

