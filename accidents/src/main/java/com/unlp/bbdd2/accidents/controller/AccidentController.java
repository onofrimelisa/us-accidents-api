package com.unlp.bbdd2.accidents.controller;

import com.unlp.bbdd2.accidents.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
