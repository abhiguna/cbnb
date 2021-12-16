package com.cs348.cbnb.repository;

import com.cs348.cbnb.model.Dorm;
import com.cs348.cbnb.model.University;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DormRepository extends JpaRepository<Dorm, Long> {
    @Procedure(procedureName = "num_spots")
    public int numSpots(LocalDate date, String dormID);

    public Dorm findByName(String name);

    @Query(value = "SELECT * FROM Dorm WHERE uID = ?1", nativeQuery = true)
    public List<Dorm> getDorms(String college);

    @Query(value = "SELECT * FROM Dorm WHERE uID = ?1 GROUP BY name ORDER BY name", nativeQuery = true)
    public List<Dorm> sortByDormName(String college);

    @Query(value = "SELECT * FROM Dorm WHERE uID = ?1 GROUP BY name ORDER BY dorm_type", nativeQuery = true)
    public List<Dorm> sortByDormType(String college);

    @Query(value = "SELECT * FROM Dorm WHERE uID = ?1 GROUP BY name ORDER BY SUM(Dorm.total_guests) ASC", nativeQuery = true)
    public List<Dorm> sortByTotalGuests(String college);

    @Query(value = "SELECT * FROM Dorm WHERE uID = ?1 GROUP BY name ORDER BY Dorm.rooms_available", nativeQuery = true)
    public List<Dorm> sortByRoomsAvailable(String college);

    @Query(value = "SELECT * FROM Dorm WHERE uID = ?1 GROUP BY Dorm.name, Dorm.address, Dorm.total_guests, Dorm.rooms_available, Dorm.dorm_type", nativeQuery = true)
    public List<Dorm> sortByAll(String college);

}
