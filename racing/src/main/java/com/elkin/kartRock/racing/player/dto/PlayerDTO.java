package com.elkin.kartRock.racing.player.dto;

import com.elkin.kartRock.racing.car.model.Car;
import com.elkin.kartRock.racing.player.model.Enum.TypePlayer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO implements Serializable {

    private static final long serialVersionUID = -955217451181178846L;

    private Long id;

    private String name;

    private Car car;

    private TypePlayer typePlayer;
}
