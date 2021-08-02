package com.elkin.kartRock.racing.player.mapper;

import com.elkin.kartRock.racing.car.mapper.CarMapper;
import com.elkin.kartRock.racing.commons.mapper.EntityMapper;
import com.elkin.kartRock.racing.player.dto.PlayerCreateDTO;
import com.elkin.kartRock.racing.player.dto.PlayerDTO;
import com.elkin.kartRock.racing.player.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CarMapper.class})
public interface PlayerMapper extends EntityMapper<PlayerDTO, Player> {

    @Mapping(source = "car", target = "car")
    PlayerDTO toDto(Player player);
    @Mapping(source = "car.id", target = "carId")
    Player toEntity(PlayerCreateDTO player);
}
