package com.elkin.kartRock.racing.player.repository;

import com.elkin.kartRock.racing.player.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("SELECT p FROM Car p WHERE LOWER(p.name) LIKE LOWER(concat('%', :query, '%')) OR " +
            "LOWER(p.name) LIKE LOWER(concat('%', :query, '%'))")
    Page<Player> search(@Param("query") String query, Pageable pageable);
}
