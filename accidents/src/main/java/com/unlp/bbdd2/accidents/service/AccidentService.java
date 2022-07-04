package com.unlp.bbdd2.accidents.service;

import com.unlp.bbdd2.accidents.model.Accident;
import com.unlp.bbdd2.accidents.repository.AccidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class AccidentService {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private AccidentRepository accidentRepository;

    public Page<Accident> findAll() {
        return this.accidentRepository.findAll(Pageable.ofSize(PAGE_SIZE));
    }

    public Accident findById(String accidentId) {
        return this.accidentRepository.findByAccidentId(accidentId);
    }
}
