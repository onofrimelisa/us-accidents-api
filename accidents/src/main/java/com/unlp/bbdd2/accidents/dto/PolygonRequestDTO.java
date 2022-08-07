package com.unlp.bbdd2.accidents.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

public class PolygonRequestDTO {
    @Size(min = 4)
    List<PointDTO> points;

    public List<PointDTO> getPoints() {
        return points;
    }

    public void setPoints(List<PointDTO> points) {
        this.points = points;
    }
}
