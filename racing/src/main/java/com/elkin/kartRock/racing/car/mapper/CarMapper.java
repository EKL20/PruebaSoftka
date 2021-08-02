package com.elkin.kartRock.racing.car.mapper;

import com.elkin.kartRock.racing.car.dto.CarCreateDTO;
import com.elkin.kartRock.racing.car.dto.CarDTO;
import com.elkin.kartRock.racing.car.model.Car;
import com.elkin.kartRock.racing.commons.mapper.EntityMapper;
import com.elkin.kartRock.racing.lane.mapper.LaneMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LaneMapper.class})
public interface CarMapper extends EntityMapper<CarDTO, Car> {

    @Mapping(source = "lane", target = "lane")
    CarDTO toDto(Car car);
    @Mapping(source = "lane.id", target = "laneId")
    CarDTO toEntity(CarCreateDTO car);
}
