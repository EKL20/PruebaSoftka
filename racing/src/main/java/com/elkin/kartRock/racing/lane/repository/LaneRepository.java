package com.elkin.kartRock.racing.lane.repository;

import com.elkin.kartRock.racing.lane.model.Lane;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LaneRepository extends JpaRepository<Lane, Long> {
    @Query("SELECT l FROM AcademicPeriod l WHERE LOWER(l.name) LIKE LOWER(concat('%', :query, '%')) OR " +
            "LOWER(l.name) LIKE LOWER(concat('%', :query, '%'))")
    Page<Lane> search(@Param("query") String query, Pageable pageable);

}
