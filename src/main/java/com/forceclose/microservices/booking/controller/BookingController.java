package com.forceclose.microservices.booking.controller;

import com.forceclose.microservices.booking.domain.Booking;
import com.forceclose.microservices.booking.repository.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    @PostMapping
    public ResponseEntity<Booking> register(@RequestBody @Valid Booking booking) throws Exception {
        booking = bookingService.register(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> findByUserId(@RequestParam(name = "userId") String userId) {
        List<Booking> bookings = bookingService.findByUserId(userId);
        if (bookings == null || bookings.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(bookings, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> findById(@PathVariable("id") String id){
        Optional<Booking> booking = bookingService.findById(id);
        return booking
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


}
