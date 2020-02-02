package com.example.phonesAPI.repository;

import com.example.phonesAPI.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository <Phone, Long> {
    Optional<Object> findById(String phoneId);
}
