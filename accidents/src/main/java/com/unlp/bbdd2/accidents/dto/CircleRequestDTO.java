package com.unlp.bbdd2.accidents.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Validated
public class CircleRequestDTO {
    @NotNull(message = "The point must not be null.")
    @Valid
    PointDTO point;
    @NotNull(message = "The radius must not be null.")
    @Positive(message = "The radius value must be positive.")
    Double radius;

    public PointDTO getPoint() {
        return point;
    }

    public void setPoint(PointDTO point) {
        this.point = point;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
