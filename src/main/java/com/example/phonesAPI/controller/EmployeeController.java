package com.example.phonesAPI.controller;

import com.example.phonesAPI.exception.ResourceNotFoundException;
import com.example.phonesAPI.model.Employee;

import com.example.phonesAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController  {

    @Autowired
    EmployeeRepository employeeRepository;

    // Get All Employee
    @GetMapping("/Employee")
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll(); }



    // Create a new Employee
    @PostMapping("/Employee")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return (Employee) employeeRepository.save(employee); }

    // Get a Single Employee
    @GetMapping("/Employee/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Long employeeId) throws Throwable {
        return (Employee) employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
    }

    // Update a Employee
    @PutMapping("/Employee/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Long employeeId,
                           @Valid @RequestBody Employee employeeDetails) throws Throwable {

        Employee employee = (Employee) employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id",employeeId));

        employee.setId(employeeDetails.getId());
        employee.setNickname(employeeDetails.getNickname());
        employee.setName(employeeDetails.getName());
        employee.setWorkingyears(employeeDetails.getWorkingyears());


        Employee updatedEmployee = (Employee) employeeRepository.save(employee);
        return updatedEmployee;
    }

    // Delete a Employee
    @DeleteMapping("/Employee /{id}")
    public ResponseEntity<?> deleteEmployee (@PathVariable(value = "id") Long employeeId) throws Throwable {
        Employee  employee  = (Employee) employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee ", "id", employeeId));

        employeeRepository.delete(employee);

        return ResponseEntity.ok().build();
    }
}
