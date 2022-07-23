package com.unlp.bbdd2.accidents.controller;

import com.unlp.bbdd2.accidents.dto.PolygonRequestDTO;
import com.unlp.bbdd2.accidents.model.Accident;
import com.unlp.bbdd2.accidents.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccidentController {

    @Autowired
    private AccidentService accidentService;

    @GetMapping("/accident/{id}")
    public Accident findById(@PathVariable("id") String id) {
        return this.accidentService.findById(id);
    }

    @GetMapping("/accident")
    public Page<Accident> findAll() {
        return this.accidentService.findAll();
    }

    @PostMapping("/accident/polygon")
    public Page<Accident> findFromPolygon(@RequestBody PolygonRequestDTO polygonRequestDTO) {
        // TODO ver si se usa este dto o no
        Polygon polygon = new Polygon(
            new Point(polygonRequestDTO.getFirstPoint().getLatitude(), polygonRequestDTO.getFirstPoint().getLongitude()),
            new Point(polygonRequestDTO.getSecondPoint().getLatitude(), polygonRequestDTO.getSecondPoint().getLongitude()),
            new Point(polygonRequestDTO.getThirdPoint().getLatitude(), polygonRequestDTO.getThirdPoint().getLongitude()),
            new Point(polygonRequestDTO.getFourthPoint().getLatitude(), polygonRequestDTO.getFourthPoint().getLongitude())
        );
        return this.accidentService.findByStartPointWithin(polygon);
    }
}
