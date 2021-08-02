package com.elkin.kartRock.racing.player.service;

import com.elkin.kartRock.racing.player.dto.PlayerCreateDTO;
import com.elkin.kartRock.racing.player.dto.PlayerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PlayerService {

    PlayerDTO save(PlayerCreateDTO PlayerDTO);

    Page<PlayerDTO> searchPlayer(String query, Pageable pageable);

    Optional<PlayerDTO> findOne(Long id);

    PlayerDTO update(PlayerCreateDTO PlayerDTO, Long id);

    void delete(Long id);
}
