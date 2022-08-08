package com.unlp.bbdd2.accidents.controller;

import com.unlp.bbdd2.accidents.dto.CircleRequestDTO;
import com.unlp.bbdd2.accidents.dto.PolygonRequestDTO;
import com.unlp.bbdd2.accidents.model.Accident;
import com.unlp.bbdd2.accidents.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
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
    public Page<Accident> findFromPolygon(@Valid @RequestBody PolygonRequestDTO polygonRequestDTO) {
        return this.accidentService.findByStartPointWithin(this.mapPolygonRequestDTOToPolygon(polygonRequestDTO));
    }

    @PostMapping("/accident/circle")
    public Page<Accident> findFromCircle(@Valid @RequestBody CircleRequestDTO circleRequestDTO) {
        return this.accidentService.findByStartPointWithin(this.mapCircleRequestDTOToCircle(circleRequestDTO));
    }

    private Polygon mapPolygonRequestDTOToPolygon(PolygonRequestDTO polygonRequestDTO) {
        List<Point> points = new ArrayList<>();
        polygonRequestDTO.getPoints().forEach(point -> points.add(new Point(point.getX(), point.getY())));

        return new Polygon(points);
    }

    private Circle mapCircleRequestDTOToCircle(CircleRequestDTO circleRequestDTO) {
        return new Circle(
                new Point(
                        circleRequestDTO.getPoint().getX(),
                        circleRequestDTO.getPoint().getY()
                ),
                circleRequestDTO.getRadius()
        );
    }
}
