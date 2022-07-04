package com.unlp.bbdd2.accidents.controller;

import com.unlp.bbdd2.accidents.model.Accident;
import com.unlp.bbdd2.accidents.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    public Page<Accident> findFromPolygon() {
        return null;
    }
}
