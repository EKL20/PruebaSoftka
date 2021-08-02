package com.elkin.kartRock.racing.car.repository;

import com.elkin.kartRock.racing.car.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE LOWER(c.name) LIKE LOWER(concat('%', :query, '%')) OR " +
            "LOWER(c.name) LIKE LOWER(concat('%', :query, '%'))")
    Page<Car> search(@Param("query") String query, Pageable pageable);
}
