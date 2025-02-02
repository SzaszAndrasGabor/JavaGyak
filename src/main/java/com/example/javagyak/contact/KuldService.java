package com.example.javagyak.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class KuldService {

    private final KuldRepository kuldRepository;

    @Autowired
    public KuldService(KuldRepository kuldRepository) {
        this.kuldRepository = kuldRepository;
    }

    public boolean saveMessage(String email, String message, Integer userId) {
        try {
            // Új ContactEntity példány létrehozása
            ContactEntity contactEntity = new ContactEntity();
            contactEntity.setEmail(email);
            contactEntity.setMessage(message);
            contactEntity.setUserId(userId);
            contactEntity.setCreatedAt(LocalDateTime.now());

            // Adat mentése az adatbázisba
            kuldRepository.save(contactEntity);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

