package com.unlp.bbdd2.accidents.dto;

public class CircleRequestDTO {
    PointDTO point;
    double radius;

    public PointDTO getPoint() {
        return point;
    }

    public void setPoint(PointDTO point) {
        this.point = point;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
