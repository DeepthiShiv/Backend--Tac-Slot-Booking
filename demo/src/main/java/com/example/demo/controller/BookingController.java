// package com.example.demo.controller;

// import com.example.demo.entity.Booking;
// import com.example.demo.model.BookingRequest;
// import com.example.demo.service.BookingService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.sql.Date;
// import java.sql.Time;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// @CrossOrigin(origins = "http://localhost:3000") // Allow requests from React frontend
// @RestController
// @RequestMapping("/api/bookings")
// public class BookingController {

//     @Autowired
//     private BookingService bookingService;

//     @PostMapping
//     public ResponseEntity<?> bookSlot(@RequestBody BookingRequest bookingRequest) {
//         try {
//             // Log the incoming request for debugging
//             System.out.println("Received booking request: " + bookingRequest);

//             // Convert String to Date
//             Date date = Date.valueOf(bookingRequest.getSlotDate());

//             // Convert time from "10:00 AM" to "10:00:00"
//             String timeString = bookingRequest.getSlotTime();
//             if (timeString.endsWith(" AM") || timeString.endsWith(" PM")) {
//                 // Convert 12-hour format to 24-hour format
//                 SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
//                 SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
//                 java.util.Date parsedTime = parseFormat.parse(timeString);
//                 timeString = displayFormat.format(parsedTime);
//             }

//             // Ensure the time is in HH:mm:ss format
//             Time time = Time.valueOf(timeString);

//             // Book the slot
//             Booking booking = bookingService.bookSlot(bookingRequest.getTacId(), date, time);

//             // Return the booked slot details
//             return ResponseEntity.ok(booking);
//         } catch (IllegalArgumentException e) {
//             // Handle invalid date or time format
//             System.err.println("Invalid date or time format: " + e.getMessage());
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid date or time format");
//         } catch (ParseException e) {
//             // Handle time parsing errors
//             System.err.println("Error parsing time: " + e.getMessage());
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid time format. Use 'hh:mm a' (e.g., '10:00 AM').");
//         } catch (Exception e) {
//             // Handle any other exceptions
//             System.err.println("Error booking slot: " + e.getMessage());
//             e.printStackTrace();
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while booking the slot.");
//         }
//     }
// }



package com.example.demo.controller;

import com.example.demo.entity.Booking;
import com.example.demo.model.BookingRequest;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // Allow requests from React frontend
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // POST endpoint to book a slot
    @PostMapping
    public ResponseEntity<?> bookSlot(@RequestBody BookingRequest bookingRequest) {
        try {
            // Log the incoming request for debugging
            System.out.println("Received booking request: " + bookingRequest);

            // Convert String to Date
            Date date = Date.valueOf(bookingRequest.getSlotDate());

            // Convert time from "10:00 AM" to "10:00:00"
            String timeString = bookingRequest.getSlotTime();
            if (timeString.endsWith(" AM") || timeString.endsWith(" PM")) {
                // Convert 12-hour format to 24-hour format
                SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
                SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
                java.util.Date parsedTime = parseFormat.parse(timeString);
                timeString = displayFormat.format(parsedTime);
            }

            // Ensure the time is in HH:mm:ss format
            Time time = Time.valueOf(timeString);

            // Book the slot
            Booking booking = bookingService.bookSlot(bookingRequest.getTacId(), date, time);

            // Return the booked slot details
            return ResponseEntity.ok(booking);
        } catch (IllegalArgumentException e) {
            // Handle invalid date or time format
            System.err.println("Invalid date or time format: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid date or time format");
        } catch (ParseException e) {
            // Handle time parsing errors
            System.err.println("Error parsing time: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid time format. Use 'hh:mm a' (e.g., '10:00 AM').");
        } catch (Exception e) {
            // Handle any other exceptions
            System.err.println("Error booking slot: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while booking the slot.");
        }
    }

    // GET endpoint to fetch all bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
}