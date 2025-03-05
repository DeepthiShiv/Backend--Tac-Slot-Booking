package com.example.demo.service;

import com.example.demo.entity.Booking;
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.sql.Date;
import java.sql.Time;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking bookSlot(String tacId, Date slotDate, Time slotTime) {
        Booking booking = new Booking();
        booking.setTacId(tacId);
        booking.setSlotDate(slotDate);
        booking.setSlotTime(slotTime);
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}