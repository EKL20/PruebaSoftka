package com.elkin.kartRock.racing.lane.controller;

import com.elkin.kartRock.racing.car.dto.CarCreateDTO;
import com.elkin.kartRock.racing.car.dto.CarDTO;
import com.elkin.kartRock.racing.lane.dto.LaneCreateDTO;
import com.elkin.kartRock.racing.lane.dto.LaneDTO;
import com.elkin.kartRock.racing.lane.service.LaneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/lane")
public class LaneController {

    private final LaneService laneService;

    @PostMapping
    public ResponseEntity<LaneDTO> createLane(@Valid @RequestBody LaneCreateDTO request) throws URISyntaxException {
        log.info("REST request to save Lane : {}", request);
        LaneDTO result = laneService.save(request);
        return ResponseEntity.created(new URI("/lane" + result.getId()))
                .body(result);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<LaneDTO>> searchLane
            (@RequestParam(name = "query", required = false, defaultValue = "")
                     String query, @RequestParam(defaultValue = "0") int pageNumber,
             @RequestParam(defaultValue = "3") int pageSize) {
        log.info("REST request to get a page of Lane");
        Page<LaneDTO> page = laneService.searchLane(query, PageRequest.of(pageNumber, pageSize));
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LaneDTO> searchLane(@PathVariable Long id) {
        log.info("REST request to get Lane : {}", id);
        Optional<LaneDTO> laneDTO = laneService.findOne(id);
        return ResponseEntity.of(laneDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LaneDTO> updateLane(@Valid @RequestBody LaneCreateDTO
                                                        laneCreateDTO,
                                            @PathVariable("id") Long id) {
        log.info("REST request to update Lane : {}", laneCreateDTO);
        LaneDTO result = laneService.update(laneCreateDTO, id);
        return ResponseEntity.ok()
                .body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteLane(@PathVariable Long id) {
        log.info("REST request to delete Lane : {}", id);
        laneService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
