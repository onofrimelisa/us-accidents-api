package com.unlp.bbdd2.accidents.service;

import com.unlp.bbdd2.accidents.repository.AccidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccidentService {

    @Autowired
    private AccidentRepository accidentRepository;

    public Object findByAirportCode(String airportCode) {
        return this.accidentRepository.findByAirportCode(airportCode, Pageable.ofSize(10));
    }

    public Object findAll() {
        return this.accidentRepository.findAll(Pageable.ofSize(10));
    }
}
