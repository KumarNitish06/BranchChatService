package com.nitish.ChatApplication.repository;

import com.nitish.ChatApplication.entity.Message;
import com.nitish.ChatApplication.entity.Window;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WindowRepository extends JpaRepository<Window, Long> {
    List<Window> findByAgentId(Long AgentId);
    Window findByUserId(String userId);

}
