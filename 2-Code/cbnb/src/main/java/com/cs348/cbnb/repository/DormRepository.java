package com.cs348.cbnb.repository;

import com.cs348.cbnb.model.Dorm;
import com.cs348.cbnb.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DormRepository extends JpaRepository<Dorm, Long> {
}
