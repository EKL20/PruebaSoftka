package com.elkin.kartRock.racing.car.dto;

import com.elkin.kartRock.racing.lane.model.Lane;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarCreateDTO implements Serializable {

    private static final long serialVersionUID = -5107073347615519961L;

    @NotBlank
    @Size(max = 15)
    private String name;

    @NotNull
    private Lane lane;
}
