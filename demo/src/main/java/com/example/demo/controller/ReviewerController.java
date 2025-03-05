package com.example.demo.controller;

import com.example.demo.entity.Reviewer;
import com.example.demo.service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reviewers")
public class ReviewerController {

    @Autowired
    private ReviewerService reviewerService;

    @GetMapping
    public List<Reviewer> getAllReviewers() {
        return reviewerService.getAllReviewers();
    }
}
