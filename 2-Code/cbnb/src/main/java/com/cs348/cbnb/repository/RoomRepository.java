package com.cs348.cbnb.repository;

import com.cs348.cbnb.model.Room;
import com.cs348.cbnb.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    public List<Room> findRoomsByDormId(String dormId);
}
