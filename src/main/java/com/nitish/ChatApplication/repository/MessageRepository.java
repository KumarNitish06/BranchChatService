package com.nitish.ChatApplication.repository;

import com.nitish.ChatApplication.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByUserId(String userId);
}
