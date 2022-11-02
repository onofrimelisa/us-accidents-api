package com.unlp.bbdd2.accidents.controller;

import com.unlp.bbdd2.accidents.dto.*;
import com.unlp.bbdd2.accidents.exceptions.NotFoundException;
import com.unlp.bbdd2.accidents.service.AccidentService;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Polygon;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AccidentController {

    @Autowired
    private AccidentService accidentService;
    @Autowired
    @Qualifier("getCircleRequestDTOMapper")
    private ModelMapper circleRequestMapper;

    @Autowired
    @Qualifier("getPolygonRequestDTOMapper")
    private ModelMapper polygonRequestMapper;

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
    public Page<AccidentDTO> findFromPolygon(@Valid @RequestBody
                                             PolygonRequestDTO polygonRequestDTO) {
        return this.accidentService.findByStartPointWithin(this.polygonRequestMapper.map(
                polygonRequestDTO,
                Polygon.class));
    }

    @Operation(summary = "Get all the accidents within a given circle", tags = "Accidents")
    @PostMapping("/accident/circle")
    public Page<AccidentDTO> findFromCircle(@Valid @RequestBody CircleRequestDTO circleRequestDTO) {
        return this.accidentService.findByStartPointWithin(this.circleRequestMapper.map(circleRequestDTO,
                Circle.class));
    }

    @Operation(summary = "Get the most common weather conditions of the accidents", tags = "Accidents")
    @GetMapping("/accident/conditions/weather")
    public List<WeatherConditionDTO> getMostCommonWeatherConditions(@RequestParam Integer limit) {
        return this.accidentService.getMostCommonWeatherConditions(limit);
    }

    @Operation(summary = "Get the total number of accidents grouped by temperature using the Fahrenheit scale", tags = "Accidents")
    @GetMapping("/accident/conditions/temperature")
    public TemperatureResponseDTO getTotalAccidentsByTemperature() {
        return this.accidentService.getTotalAccidentsByTemperature();
    }

    @Operation(summary = "Get the total number of accidents grouped by relative humidity (%)", tags = "Accidents")
    @GetMapping("/accident/conditions/humidity")
    public HumidityResponseDTO getTotalAccidentsByHumidity() {
        return this.accidentService.getTotalAccidentsByHumidity();
    }
}
