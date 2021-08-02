package com.elkin.kartRock.racing.car.dto;

import com.elkin.kartRock.racing.lane.model.Lane;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO implements Serializable {

    private static final long serialVersionUID = -3409912794695368176L;

    private Long id;

    private String name;

    private Lane lane;
}
