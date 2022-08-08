package com.unlp.bbdd2.accidents.service;
import com.unlp.bbdd2.accidents.model.Accident;
import com.unlp.bbdd2.accidents.repository.AccidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.data.geo.Shape;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccidentService implements IAccidentService {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private AccidentRepository accidentRepository;

    public Page<Accident> findAll() {
        return this.accidentRepository.findAll(Pageable.ofSize(PAGE_SIZE));
    }

    public Accident findById(String accidentId) {
        return this.accidentRepository.findByAccidentId(accidentId);
    }

    public Page<Accident> findByStartPointWithin(Polygon polygon) {
        // TODO el accidente tiene startPoint y stopPoint, tendriamos que chequear que alguno de los dos puntos este dentro del poligono
        // TODO por ahora solo se esta chequeando el startPoint
        return this.accidentRepository.findByStartPointWithin(
            polygon,
            Pageable.ofSize(PAGE_SIZE)
        );
    }

    public Page<Accident> findByStartPointWithin(Circle circle) {
        // TODO el accidente tiene startPoint y stopPoint, tendriamos que chequear que alguno de los dos puntos este dentro del circulo
        // TODO por ahora solo se esta chequeando el startPoint
        return this.accidentRepository.findByStartPointWithin(
                circle,
                Pageable.ofSize(PAGE_SIZE)
        );
    }
}
