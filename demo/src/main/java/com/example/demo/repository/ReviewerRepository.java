package com.example.demo.repository;

import com.example.demo.entity.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewerRepository extends JpaRepository<Reviewer, Integer> {
    Reviewer findByEmailAndPassword(String email, String password);
}