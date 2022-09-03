package com.unlp.bbdd2.accidents.controller;

import com.unlp.bbdd2.accidents.dto.AccidentDTO;
import com.unlp.bbdd2.accidents.dto.CircleRequestDTO;
import com.unlp.bbdd2.accidents.dto.PolygonRequestDTO;
import com.unlp.bbdd2.accidents.exceptions.NotFoundException;
import com.unlp.bbdd2.accidents.service.AccidentService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Get an accident by its id", tags = "Accidents")
    @GetMapping("/accident/{id}")
    public AccidentDTO findById(@PathVariable("id") String id) throws NotFoundException {
        return this.accidentService.findById(id);
    }

    @Operation(summary = "Get all the accidents", tags = "Accidents")
    @GetMapping("/accident")
    public Page<AccidentDTO> findAll() {
        return this.accidentService.findAll();
    }

    @Operation(summary = "Get all the accidents within a given polygon", tags = "Accidents")
    @PostMapping("/accident/polygon")
    public Page<AccidentDTO> findFromPolygon(@Valid @RequestBody PolygonRequestDTO polygonRequestDTO) {
        return this.accidentService.findByStartPointWithin(this.mapPolygonRequestDTOToPolygon(polygonRequestDTO));
    }

    @Operation(summary = "Get all the accidents within a given circle", tags = "Accidents")
    @PostMapping("/accident/circle")
    public Page<AccidentDTO> findFromCircle(@Valid @RequestBody CircleRequestDTO circleRequestDTO) {
        return this.accidentService.findByStartPointWithin(this.mapCircleRequestDTOToCircle(circleRequestDTO));
    }

    // TODO remove this and use the model mapper
    private Polygon mapPolygonRequestDTOToPolygon(PolygonRequestDTO polygonRequestDTO) {
        List<Point> points = new ArrayList<>();
        polygonRequestDTO.getPoints().forEach(point -> points.add(new Point(point.getX(), point.getY())));

        return new Polygon(points);
    }

    // TODO remove this and use the model mapper
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
