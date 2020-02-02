package com.example.phonesAPI.controller;

import com.example.phonesAPI.exception.ResourceNotFoundException;

import com.example.phonesAPI.model.Customers;
import com.example.phonesAPI.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomersController {
    @Autowired
    CustomersRepository  customersRepository;

    // Get All Customers
    @GetMapping("/customers")
    public List<Customers> getAllCustomers() {
        return customersRepository.findAll();
    }

    // Get a Single Customers
    @GetMapping("/customers/{id}")
    public Customers getCustomersById(@PathVariable(value = "id") Long customersId) throws Throwable {
        return (Customers) customersRepository.findById(customersId)
                .orElseThrow(() -> new ResourceNotFoundException("Customers", "id", customersId));
    }

    // Create a new Customers
    @PostMapping("/customers")
    public Customers createCustomers(@Valid @RequestBody Customers customers) {
        return (Customers) customersRepository.save(customers);
    }

    // Update a Customers
    @PutMapping("/customers/{id}")
    public Customers updateCustomers(@PathVariable(value = "id") Long customersId,
                           @Valid @RequestBody Customers customersDetails) throws Throwable {

        Customers customers = (Customers) customersRepository.findById(customersId)
                .orElseThrow(() -> new ResourceNotFoundException("Customers", "id", customersId));

        customers.setName(customersDetails.getName());
        customers.setSurname(customersDetails.getSurname());
        customers.setUsername(customersDetails.getUsername());
        customers.setAge(customersDetails.getAge());


        Customers updatedCustomers = (Customers)customersRepository.save(customers);
        return updatedCustomers;
    }

    // Delete a Customers
    @DeleteMapping("/customers/{id}")
      public ResponseEntity<?> deleteCustomers(@PathVariable(value = "id") Long customersId) throws Throwable {
        Customers customers = (Customers) customersRepository.findById(customersId)
                .orElseThrow(() -> new ResourceNotFoundException("Customers", "id", customersId));

        customersRepository.delete(customers);

        return ResponseEntity.ok().build();
    }
}
