package com.elkin.kartRock.racing.lane.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class LaneCreateDTO implements Serializable {
    private static final long serialVersionUID = -7361823172603908593L;

    @NotBlank
    @Size(max = 15)
    private String name;

    @NotNull
    private int distance;
}
