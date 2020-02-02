package com.example.phonesAPI.controller;

import com.example.phonesAPI.exception.ResourceNotFoundException;
import com.example.phonesAPI.model.Phone;
import com.example.phonesAPI.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PhoneController {
    @Autowired
    PhoneRepository phoneRepository;

    // Get All Phone
    @GetMapping("/Phone")
    public List<Phone> getAllPhone() {
        return phoneRepository.findAll();
    }

    // Create a new Phone
    @PostMapping("/Phone")
    public Phone createPhone(@Valid @RequestBody Phone phone) {
        return phoneRepository.save(phone);
    }



    // Get a Single Phone
    @GetMapping("/phone/{I=id}")
    public Phone getPhoneById(@PathVariable(value = "id") String phoneId) throws Throwable {
        return (Phone)phoneRepository.findById(phoneId)
                .orElseThrow(() -> new ResourceNotFoundException("Phone", "id", phoneId));
    }

    // Update a Phone
    @PutMapping("/Phone/{id}")
    public Phone updatePhone(@PathVariable(value = "id") String phoneId,
                           @Valid @RequestBody Phone phoneDetails) throws Throwable {

        Phone phone = (Phone) phoneRepository.findById(phoneId)
                .orElseThrow(() -> new ResourceNotFoundException("Phone", "id", phoneId));

        phone.setId(phoneDetails.getId());
        phone.setMake(phoneDetails.getMake());
        phone.setColor(phoneDetails.getColor());
        phone.setModel(phoneDetails.getModel());
        phone.setPrice(phoneDetails.getPrice());

        Phone updatedPhone = (Phone) phoneRepository.save(phone);
        return updatedPhone;
    }

    // Delete a Phone
    @DeleteMapping("/phone/{id}")
    public ResponseEntity<?> deletePhone(@PathVariable(value = "id") String PhoneId) throws Throwable {
        Phone phone = (Phone) phoneRepository.findById(PhoneId)
                .orElseThrow(() -> new ResourceNotFoundException("Phone", "id", PhoneId));

        phoneRepository.delete(phone);

        return ResponseEntity.ok().build();
    }
}
