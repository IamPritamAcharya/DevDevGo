package com.devdevgo.backend.repository;

import com.devdevgo.backend.model.Content;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {
    @Query("""
                SELECT DISTINCT c FROM Content c
                JOIN ContentTopic ct ON ct.content = c
                WHERE ct.topic.id IN :topicIds
                ORDER BY c.createdAt DESC
            """)
    List<Content> findByTopicIds(@Param("topicIds") List<Long> topicIds);
}