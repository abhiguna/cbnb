package com.cs348.cbnb.service;

import com.cs348.cbnb.model.Booking;
import com.cs348.cbnb.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void createBooking(Booking b) {
        bookingRepository.save(b);
    }
}
