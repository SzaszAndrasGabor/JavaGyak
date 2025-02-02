package com.example.javagyak.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KuldRepository extends JpaRepository<ContactEntity, Integer> {
}
