package com.unlp.bbdd2.accidents.dto;

public class PolygonRequestDTO {
    private PointDTO firstPoint;
    private PointDTO secondPoint;
    private PointDTO thirdPoint;
    private PointDTO fourthPoint;

    public PointDTO getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(PointDTO firstPoint) {
        this.firstPoint = firstPoint;
    }

    public PointDTO getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(PointDTO secondPoint) {
        this.secondPoint = secondPoint;
    }

    public PointDTO getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(PointDTO thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    public PointDTO getFourthPoint() {
        return fourthPoint;
    }

    public void setFourthPoint(PointDTO fourthPoint) {
        this.fourthPoint = fourthPoint;
    }
}
