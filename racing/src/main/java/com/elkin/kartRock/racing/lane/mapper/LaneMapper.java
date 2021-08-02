package com.elkin.kartRock.racing.lane.mapper;

import com.elkin.kartRock.racing.commons.mapper.EntityMapper;
import com.elkin.kartRock.racing.lane.dto.LaneCreateDTO;
import com.elkin.kartRock.racing.lane.dto.LaneDTO;
import com.elkin.kartRock.racing.lane.model.Lane;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface LaneMapper extends EntityMapper<LaneDTO, Lane> {

    Lane toEntity(LaneCreateDTO lane);
}
