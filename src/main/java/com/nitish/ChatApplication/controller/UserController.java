package com.nitish.ChatApplication.controller;

import com.nitish.ChatApplication.entity.User;
import com.nitish.ChatApplication.repository.UserRepository;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{uid}")
    private ResponseEntity<User> getUser(@PathVariable String uid) {
        ResponseEntity<User> responseEntity;
        try{
            User user = userRepository.findByUserId(uid);
            responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Exception in getting open chats" + ExceptionUtils.getStackTrace(ex));
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
