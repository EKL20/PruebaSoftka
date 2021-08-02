package com.elkin.kartRock.racing.car.controller;

import com.elkin.kartRock.racing.car.dto.CarCreateDTO;
import com.elkin.kartRock.racing.car.dto.CarDTO;
import com.elkin.kartRock.racing.car.service.CarService;
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
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @PostMapping
    public ResponseEntity<CarDTO> createCar(@Valid @RequestBody CarCreateDTO request) throws URISyntaxException {
        log.info("REST request to save Car : {}", request);
        CarDTO result = carService.save(request);
        return ResponseEntity.created(new URI("/car" + result.getId()))
                .body(result);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<CarDTO>> searchCar
            (@RequestParam(name = "query", required = false, defaultValue = "")
                     String query, @RequestParam(defaultValue = "0") int pageNumber,
             @RequestParam(defaultValue = "3") int pageSize) {
        log.info("REST request to get a page of Car");
        Page<CarDTO> page = carService.searchCar(query, PageRequest.of(pageNumber, pageSize));
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CarDTO> searchCar(@PathVariable Long id) {
        log.info("REST request to get Car : {}", id);
        Optional<CarDTO> academicPeriodDTO = carService.findOne(id);
        return ResponseEntity.of(academicPeriodDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CarDTO> updateCar(@Valid @RequestBody CarCreateDTO
                                                                          carCreateDTO,
                                                                  @PathVariable("id") Long id) {
        log.info("REST request to update Car : {}", carCreateDTO);
        CarDTO result = carService.update(carCreateDTO, id);
        return ResponseEntity.ok()
                .body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        log.info("REST request to delete Car : {}", id);
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
