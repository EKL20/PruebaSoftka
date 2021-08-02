package com.elkin.kartRock.racing.car.service;

import com.elkin.kartRock.racing.car.dto.CarCreateDTO;
import com.elkin.kartRock.racing.car.dto.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CarService {

    CarDTO save(CarCreateDTO CarDTO);

    Page<CarDTO> searchCar(String query, Pageable pageable);

    Optional<CarDTO> findOne(Long id);

    CarDTO update(CarCreateDTO carDTO, Long id);

    void delete(Long id);
}
