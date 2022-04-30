package com.unlp.bbdd2.accidents.controller;

import com.unlp.bbdd2.accidents.dto.PolygonRequestDTO;
import com.unlp.bbdd2.accidents.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class AccidentController {

    @Autowired
    private AccidentService accidentService;

    @GetMapping("/accident/{airportCode}")
    public Object findByAirportCode(@PathVariable("airportCode") String airportCode) {
        return this.accidentService.findByAirportCode(airportCode);
    }

    @GetMapping("/accident")
    public Object findAll() {
        return this.accidentService.findAll();
    }

    @PostMapping("/accident/polygon")
    public Object findFromPolygon() throws IOException {
        return this.accidentService.findByPolygon();
    }
}
