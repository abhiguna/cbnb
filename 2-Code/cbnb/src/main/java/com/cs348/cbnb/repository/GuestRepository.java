package com.cs348.cbnb.repository;

import com.cs348.cbnb.model.Booking;
import com.cs348.cbnb.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

}
