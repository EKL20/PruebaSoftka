package com.elkin.kartRock.racing.lane.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LaneDTO implements Serializable {

    private static final long serialVersionUID = -3827705282315660938L;

    private Long id;

    private String name;

    private int distance;
}
