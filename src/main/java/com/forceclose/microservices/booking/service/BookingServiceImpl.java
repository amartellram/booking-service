package com.forceclose.microservices.booking.service;

import com.forceclose.microservices.booking.client.UserServiceClient;
import com.forceclose.microservices.booking.client.dto.UserDto;
import com.forceclose.microservices.booking.domain.Booking;
import com.forceclose.microservices.booking.domain.User;
import com.forceclose.microservices.booking.exception.BadRequestException;
import com.forceclose.microservices.booking.repository.BookingService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserServiceClient userClient;

    @Override
    public Booking register(Booking booking) {
        validateUser(booking.getUser());
        return bookingRepository.save(booking);
    }

    private void validateUser(User user) {
        log.info("User {} is trying to book a table...", user);
        try {
            userClient.findById(user.getId());
        } catch (FeignException.BadRequest e) {
            throw new BadRequestException("User not found");
        }
    }

    @Override
    public List<Booking> findByUserId(String userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public Optional<Booking> findById(String id) {
        return bookingRepository.findById(id);
    }
}
