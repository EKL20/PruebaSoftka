package com.elkin.kartRock.racing.lane.service.impl;

import com.elkin.kartRock.racing.commons.exceptions.GenericNotFoundException;
import com.elkin.kartRock.racing.lane.dto.LaneCreateDTO;
import com.elkin.kartRock.racing.lane.dto.LaneDTO;
import com.elkin.kartRock.racing.lane.mapper.LaneMapper;
import com.elkin.kartRock.racing.lane.model.Lane;
import com.elkin.kartRock.racing.lane.repository.LaneRepository;
import com.elkin.kartRock.racing.lane.service.LaneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.elkin.kartRock.racing.lane.exceptions.LaneError.LANE_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class LaneServiceImpl implements LaneService {

    private final LaneRepository laneRepository;
    private final LaneMapper laneMapper;

    @Override
    @Transactional
    public LaneDTO save(LaneCreateDTO laneDTO) {
        log.debug("Request to save Lane : {}", laneDTO);
        Lane lane = laneMapper.toEntity(laneDTO);
        return laneMapper.toDto(laneRepository.save(lane));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<LaneDTO> searchLane(String query, Pageable pageable) {
        log.debug("Request to search Lane");
        return laneRepository.search(query, pageable)
                .map(laneMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LaneDTO> findOne(Long id) {
        log.debug("Request to get Lane : {}", id);
        return laneRepository.findById(id)
                .map(laneMapper::toDto);
    }

    @Override
    public LaneDTO update(LaneCreateDTO laneDTO, Long id) {
        Boolean existLane = laneRepository.existsById(id);
        if (!existLane) {
            throw new GenericNotFoundException(LANE_NOT_FOUND);
        }
        log.debug("Request to Update Lane : {}", laneDTO);
        Lane lane = laneMapper.toEntity(laneDTO);
        lane.setId(id);
        lane = laneRepository.save(lane);
        return laneMapper.toDto(lane);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Lane : {}", id);
        laneRepository.deleteById(id);
    }
}
