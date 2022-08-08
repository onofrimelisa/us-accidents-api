package com.unlp.bbdd2.accidents.service;

import com.unlp.bbdd2.accidents.model.Accident;
import org.springframework.data.domain.Page;
import org.springframework.data.geo.Polygon;
import org.springframework.data.geo.Circle;

public interface IAccidentService {
    Page<Accident> findAll();
    Accident findById(String accidentId);
    Page<Accident> findByStartPointWithin(Polygon polygon);
    Page<Accident> findByStartPointWithin(Circle circle);
}
