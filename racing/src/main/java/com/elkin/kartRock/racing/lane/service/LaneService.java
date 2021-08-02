package com.elkin.kartRock.racing.lane.service;

import com.elkin.kartRock.racing.lane.dto.LaneCreateDTO;
import com.elkin.kartRock.racing.lane.dto.LaneDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LaneService {

    LaneDTO save(LaneCreateDTO LaneDTO);

    Page<LaneDTO> searchLane(String query, Pageable pageable);

    Optional<LaneDTO> findOne(Long id);

    LaneDTO update(LaneCreateDTO laneDTO, Long id);

    void delete(Long id);
}
