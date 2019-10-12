package com.forceclose.microservices.booking.repository;

import com.forceclose.microservices.booking.domain.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    Booking register(Booking booking);
    List<Booking> findByUserId(String userId);
    Optional<Booking> findById(String id);
}
