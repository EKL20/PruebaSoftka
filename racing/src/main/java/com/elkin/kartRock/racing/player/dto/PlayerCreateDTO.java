package com.elkin.kartRock.racing.player.dto;

import com.elkin.kartRock.racing.car.model.Car;
import com.elkin.kartRock.racing.player.model.Enum.TypePlayer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class PlayerCreateDTO implements Serializable {

    private static final long serialVersionUID = -6485149591634615607L;

    @NotBlank
    @Size(max = 15)
    private String name;

    @NotNull
    private Car car;

    @NotNull
    private TypePlayer typePlayer;
}
