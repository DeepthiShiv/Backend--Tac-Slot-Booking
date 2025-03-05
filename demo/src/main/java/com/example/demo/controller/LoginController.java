package com.example.demo.controller;

import com.example.demo.entity.Reviewer;
import com.example.demo.entity.Student;
import com.example.demo.model.LoginRequest;
import com.example.demo.repository.ReviewerRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @SuppressWarnings("rawtypes")
	@Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ReviewerRepository reviewerRepository;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // Check in student table
        Student student = studentRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (student != null) {
            return ResponseEntity.ok("Student Login Successful");
        }

        // Check in reviewer table
        Reviewer reviewer = reviewerRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (reviewer != null) {
            return ResponseEntity.ok("Reviewer Login Successful");
        }

        // Debugging logs
        System.out.println("Login Request: " + loginRequest);
        System.out.println("Student found: " + student);
        System.out.println("Reviewer found: " + reviewer);

        // If not found in either table
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }
}
