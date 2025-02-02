package com.example.javagyak.messages;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {

    
    List<MessageEntity> findAllByOrderByCreatedAtDesc(Pageable pageable);
}