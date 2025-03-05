package com.example.demo.service;

import com.example.demo.entity.ReviewerBooking;
import com.example.demo.repository.ReviewerBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
public class ReviewerBookingService {

    @Autowired
    private ReviewerBookingRepository reviewerBookingRepository;

    // Method to book a slot for a reviewer
    public ReviewerBooking bookSlot(String reviewerId, Date slotDate, Time slotTime) {
        ReviewerBooking booking = new ReviewerBooking();
        booking.setReviewerId(reviewerId);
        booking.setSlotDate(slotDate);
        booking.setSlotTime(slotTime);
        return reviewerBookingRepository.save(booking);
    }

    // Method to fetch all bookings for reviewers
    public List<ReviewerBooking> getAllBookings() {
        return reviewerBookingRepository.findAll();
    }
}