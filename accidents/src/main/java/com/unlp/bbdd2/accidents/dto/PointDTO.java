package com.unlp.bbdd2.accidents.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public class PointDTO {
    @NotNull(message = "The X coordinate of the point must not be null.")

    private Double x;
    @NotNull(message = "The Y coordinate of the point must not be null.")
    private Double y;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
