package com.example.demo.service;

import com.example.demo.entity.Reviewer;
import com.example.demo.repository.ReviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewerService {
    @Autowired
    private ReviewerRepository reviewerRepository;

    public List<Reviewer> getAllReviewers() {
        return reviewerRepository.findAll();
    }
}