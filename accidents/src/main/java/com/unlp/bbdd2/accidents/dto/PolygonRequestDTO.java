package com.unlp.bbdd2.accidents.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
public class PolygonRequestDTO {
    @Size(min = 4, message = "The list of points must have at least four elements.")
    @NotNull(message = "The list of points must not e null.")
    @Valid
    List<PointDTO> points;

    public List<PointDTO> getPoints() {
        return points;
    }

    public void setPoints(List<PointDTO> points) {
        this.points = points;
    }
}
