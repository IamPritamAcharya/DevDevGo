package com.devdevgo.backend.repository;

import com.devdevgo.backend.model.UserTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserTopicRepository extends JpaRepository<UserTopic, Long> {

    List<UserTopic> findByUser_Id(Long userId);

}