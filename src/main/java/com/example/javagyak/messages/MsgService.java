package com.example.javagyak.messages;

import com.example.javagyak.login.User;
import com.example.javagyak.login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MsgService {
    private final MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepo;

    public MsgService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<MsgDTO> getLatestMessages() {
        // Legfrissebb 10 üzenet lekérdezése

        Optional<User> user = null;
        return messageRepository.findAllByOrderByCreatedAtDesc(PageRequest.of(
                0,25                )).stream(). map(message -> new MsgDTO(
                message.getUserId() != null ? userRepo.findById(message.getUserId()).get().getUsername() : "Vendég",
                message.getMessage(),
                message.getCreatedAt()
        ))
                .collect(Collectors.toList());
    }
}