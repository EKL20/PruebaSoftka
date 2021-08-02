package com.elkin.kartRock.racing.player.controller;

import com.elkin.kartRock.racing.player.dto.PlayerCreateDTO;
import com.elkin.kartRock.racing.player.dto.PlayerDTO;
import com.elkin.kartRock.racing.player.service.PlayerService;
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
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerDTO> createPlayer(@Valid @RequestBody PlayerCreateDTO request) throws URISyntaxException {
        log.info("REST request to save Player : {}", request);
        PlayerDTO result = playerService.save(request);
        return ResponseEntity.created(new URI("/player" + result.getId()))
                .body(result);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<PlayerDTO>> searchPlayer
            (@RequestParam(name = "query", required = false, defaultValue = "")
                     String query, @RequestParam(defaultValue = "0") int pageNumber,
             @RequestParam(defaultValue = "3") int pageSize) {
        log.info("REST request to get a page of Player");
        Page<PlayerDTO> page = playerService.searchPlayer(query, PageRequest.of(pageNumber, pageSize));
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PlayerDTO> searchPlayer(@PathVariable Long id) {
        log.info("REST request to get Player : {}", id);
        Optional<PlayerDTO> playerDTO = playerService.findOne(id);
        return ResponseEntity.of(playerDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(@Valid @RequestBody PlayerCreateDTO
                                                            playerCreateDTO,
                                              @PathVariable("id") Long id) {
        log.info("REST request to update Player : {}", playerCreateDTO);
        PlayerDTO result = playerService.update(playerCreateDTO, id);
        return ResponseEntity.ok()
                .body(result);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        log.info("REST request to delete Player : {}", id);
        playerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
