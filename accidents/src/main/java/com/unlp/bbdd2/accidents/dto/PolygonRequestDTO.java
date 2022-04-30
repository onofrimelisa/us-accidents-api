package com.unlp.bbdd2.accidents.dto;

import org.elasticsearch.common.geo.GeoPoint;

import java.util.List;

public class PolygonRequestDTO {
    List<GeoPoint> geoPoints;

    public List<GeoPoint> getGeoPoints() {
        return geoPoints;
    }

    public void setGeoPoints(List<GeoPoint> geoPoints) {
        this.geoPoints = geoPoints;
    }
}
