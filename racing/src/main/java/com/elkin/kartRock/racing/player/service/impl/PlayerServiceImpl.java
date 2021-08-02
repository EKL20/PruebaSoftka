package com.elkin.kartRock.racing.player.service.impl;

import com.elkin.kartRock.racing.commons.exceptions.GenericNotFoundException;
import com.elkin.kartRock.racing.player.dto.PlayerCreateDTO;
import com.elkin.kartRock.racing.player.dto.PlayerDTO;
import com.elkin.kartRock.racing.player.mapper.PlayerMapper;
import com.elkin.kartRock.racing.player.model.Player;
import com.elkin.kartRock.racing.player.repository.PlayerRepository;
import com.elkin.kartRock.racing.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.elkin.kartRock.racing.player.exceptions.PlayerError.PLAYER_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    @Transactional
    public PlayerDTO save(PlayerCreateDTO playerDTO) {
        log.debug("Request to save Player : {}", playerDTO);
        Player player = playerMapper.toEntity(playerDTO);
        return playerMapper.toDto(playerRepository.save(player));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PlayerDTO> searchPlayer(String query, Pageable pageable) {
        log.debug("Request to search Player");
        return playerRepository.search(query, pageable)
                .map(playerMapper::toDto);
    }

    @Override
    public Optional<PlayerDTO> findOne(Long id) {
        log.debug("Request to get Player : {}", id);
        return playerRepository.findById(id)
                .map(playerMapper::toDto);
    }

    @Override
    public PlayerDTO update(PlayerCreateDTO playerDTO, Long id) {
        Boolean existPlayer = playerRepository.existsById(id);
        if (!existPlayer) {
            throw new GenericNotFoundException(PLAYER_NOT_FOUND);
        }
        log.debug("Request to Update Player : {}", playerDTO);
        Player player = playerMapper.toEntity(playerDTO);
        player.setId(id);
        player = playerRepository.save(player);
        return playerMapper.toDto(player);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Player : {}", id);
        playerRepository.deleteById(id);
    }
}
