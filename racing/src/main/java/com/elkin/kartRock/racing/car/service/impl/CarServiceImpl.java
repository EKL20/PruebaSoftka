package com.elkin.kartRock.racing.car.service.impl;

import com.elkin.kartRock.racing.car.dto.CarCreateDTO;
import com.elkin.kartRock.racing.car.dto.CarDTO;
import com.elkin.kartRock.racing.car.mapper.CarMapper;
import com.elkin.kartRock.racing.car.model.Car;
import com.elkin.kartRock.racing.car.repository.CarRepository;
import com.elkin.kartRock.racing.car.service.CarService;
import com.elkin.kartRock.racing.commons.exceptions.GenericNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.elkin.kartRock.racing.car.exceptions.CarError.CAR_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;


    @Override
    @Transactional
    public CarDTO save(CarCreateDTO carDTO) {
        log.debug("Request to save Car : {}", carDTO);
        Car car = carMapper.toEntity(carDTO);
        return carMapper.toDto(carRepository.save(car));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CarDTO> searchCar(String query, Pageable pageable) {
        log.debug("Request to search Car");
        return carRepository.search(query, pageable)
                .map(carMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CarDTO> findOne(Long id) {
        log.debug("Request to get Car : {}", id);
        return carRepository.findById(id)
                .map(carMapper::toDto);
    }

    @Override
    public CarDTO update(CarCreateDTO carDTO, Long id) {
        Boolean existCar = carRepository.existsById(id);
        if (!existCar) {
            throw new GenericNotFoundException(CAR_NOT_FOUND);
        }
        log.debug("Request to Update Car : {}", carDTO);
        Car car = carMapper.toEntity(carDTO);
        car.setId(id);
        car = carRepository.save(car);
        return carMapper.toDto(car);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Car : {}", id);
        carRepository.deleteById(id);
    }
}
